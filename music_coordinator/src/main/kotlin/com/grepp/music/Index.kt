package com.grepp.music

import com.grepp.music.domain.coordinator.MusicCoordinator
import com.grepp.music.domain.music.Music

fun main(){
    println("\n==================")
    println("오늘 기분은 어때요? 기분에 어울리는 노래를 추천해드려요!")
    print("입력 : ")
    val input = readln()
    val musics:List<Music> = MusicCoordinator().recommend(input)
    musics.forEach { println(it) }
}