package com.grepp.music.infra.ytdlp

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.test.Test

class YtdlpExecutorTest {

    @Test
    fun testProcessBuilder() = runBlocking {
        val url = "https://www.youtube.com/watch?v=Q_TzqcWKz00"

        listOf(0, 1).forEach {
            launch {
                val pb = ProcessBuilder()
                pb.command(
                    "yt-dlp",
                    "--extract-audio",
                    "--audio-format=mp3",
                    "--audio-quality=0",
                    "-o",
                    "/Users/imseohyeon/desktop/Programmers/backend/g_kotlin/music/PLAVE(플레이브) '왜요 왜요 왜？ (Why？)' ｜ Official Lyric Video [Q_TzqcWKz00]$it",
                    url
                )

                val process = pb.start()
                delay(10000)
            }
        }
    }
}