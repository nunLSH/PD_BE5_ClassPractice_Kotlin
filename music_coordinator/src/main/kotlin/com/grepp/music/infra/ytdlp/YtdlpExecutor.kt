package com.grepp.music.infra.ytdlp

object YtdlpExecutor {
    fun execute(command: YtdlpCommand) {
        val pb = ProcessBuilder()
        pb.command(
            command.commandArgs()
        )
        pb.start()
    }
}