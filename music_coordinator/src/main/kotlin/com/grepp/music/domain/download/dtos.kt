package com.grepp.music.domain.dowload

data class Scrape(
    val searchKeyword:String,
    val searchUrl: String,
    val cssSelector: String,
    val htmlAttr: String
)

data class ScrapeResult(
    val fileName: String,
    val result:String?
)