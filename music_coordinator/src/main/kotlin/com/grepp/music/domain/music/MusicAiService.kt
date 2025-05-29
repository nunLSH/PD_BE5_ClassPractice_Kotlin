package com.grepp.music.domain.music

import dev.langchain4j.model.chat.ChatModel
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel
import dev.langchain4j.service.AiServices
import dev.langchain4j.service.SystemMessage
import dev.langchain4j.service.UserMessage

interface MusicAiService {
    @SystemMessage("당신은 상대방 기분에 어울리는 노래를 추천해주는 전문가 입니다. " +
            "사용자 기분에 어울리는 노래를 2곡 추천해주세요.")
    @UserMessage("{{it}} 이 기분에 어울리는 노래 2곡 추천해줘.")
    fun recommend(message:String):MusicList

    companion object{
        private var instance:MusicAiService? = null

        fun create():MusicAiService?{
            if(instance == null){
                val model: ChatModel = GoogleAiGeminiChatModel.builder()
                    .apiKey("AIzaSyCrqW4mTbGmiqfS2_8HqhTfNN2q2yOHabc")
                    .modelName("gemini-2.0-flash-lite")
                    .build()

                instance = AiServices.create(MusicAiService::class.java, model)
            }

            return instance
        }
    }
}