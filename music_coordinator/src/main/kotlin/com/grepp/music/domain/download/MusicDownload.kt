package com.grepp.music.domain.dowload

import com.grepp.music.domain.music.Music
import com.grepp.music.infra.ytdlp.YtdlpCommand
import com.grepp.music.infra.ytdlp.YtdlpExecutor
import kotlinx.coroutines.*
import org.openqa.selenium.By
import org.openqa.selenium.chrome.ChromeDriver

class MusicDownload {
    fun download(musicList: List<Music>) = runBlocking {
        val scrapeList = generateScrapList(musicList)
        val scrapeResults:List<ScrapeResult> = scrape(scrapeList)
        val ytdlpCommands: List<YtdlpCommand> = generateYtdlpCommands(scrapeResults)
        ytdlpCommands.forEach {
            launch {
                YtdlpExecutor.execute(it)
            }
        }
    }

    private fun generateYtdlpCommands(scrapeResults: List<ScrapeResult>): List<YtdlpCommand> {
        val downloadUrl = "https://www.youtube.com/watch?"
        val savePath = "${System.getProperty("user.home")}\\music\\"
        val ytdlpCommands: List<YtdlpCommand> = scrapeResults.map {
            YtdlpCommand(
                url = "$downloadUrl${it.result}",
                savePath = savePath,
                fileName = it.fileName
            )
        }.toList()
        return ytdlpCommands
    }

    private fun generateScrapList(musicList: List<Music>):List<Scrape> = runBlocking{
        val searchUrl = "https://www.youtube.com/results?search_query="
        val res = musicList.map {
            async(Dispatchers.Default) {
                Scrape("${it.artist}-${it.title}",
                    "$searchUrl${it.artist}-${it.title}",
                    "a[href^=\"/watch?\"]",
                    "href")
            }
        }.awaitAll()
        res
    }

    private fun scrape(scrapeList: List<Scrape>): List<ScrapeResult>  = runBlocking{
        return@runBlocking scrapeList.map{
            async (Dispatchers.Default){
                val driver = ChromeDriver()
                driver[it.searchUrl]
                val element = driver.findElement(By.cssSelector(it.cssSelector))
                val downloadUrl = element.getDomAttribute(it.htmlAttr)
                driver.quit()
                ScrapeResult(result = downloadUrl, fileName = it.searchKeyword)
            }
        }.awaitAll()
    }
}