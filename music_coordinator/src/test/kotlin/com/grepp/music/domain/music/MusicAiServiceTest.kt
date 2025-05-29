package com.grepp.music.domain.music

import dev.langchain4j.model.chat.ChatModel
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel
import dev.langchain4j.service.AiServices
import kotlin.test.Test


class MusicAiServiceTest{
    @Test
    fun testMusicAiService(){
        val model: ChatModel = GoogleAiGeminiChatModel.builder()
            .apiKey("AIzaSyCrqW4mTbGmiqfS2_8HqhTfNN2q2yOHabc")
            .modelName("gemini-2.0-flash-lite")
            .build()

        val musicAiService = AiServices.create(MusicAiService::class.java, model)
        val musics = musicAiService.recommend("오늘 코틀린을 다 배웠어! 너무 신나")
        println(musics)
    }
}