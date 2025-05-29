package com.grepp.music.domain.coordinator

import com.grepp.music.domain.dowload.MusicDownload
import com.grepp.music.domain.music.Music
import com.grepp.music.domain.music.MusicAiService
import com.grepp.music.domain.music.MusicList

class MusicCoordinator {
    fun recommend(message: String): List<Music> {
        val musicAiService = MusicAiService.create()
        val response: MusicList = musicAiService!!.recommend(message)
        MusicDownload().download(response.musicList)
        return response.musicList
    }
}