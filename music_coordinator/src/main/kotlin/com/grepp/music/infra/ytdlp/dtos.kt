package com.grepp.music.infra.ytdlp

enum class YtdlpFormat(val desc:String){
    MP3("mp3"),
    AAC("aac"),
    MP4("mp4"),
    MKV("mkv")
}

data class YtdlpCommand(
    val format:YtdlpFormat = YtdlpFormat.MP3,
    val quality:String = "0",
    val savePath:String,
    val fileName:String,
    val url:String
){
    fun commandArgs():List<String>{
        return listOf("./yt-dlp",
            "--extract-audio",
            "--audio-format=${format.desc}",
            "--audio-quality=$quality",
            "-o", "$savePath\\$fileName",
            url)
    }
}