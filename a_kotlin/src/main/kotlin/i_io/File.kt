package i_io

import java.io.File

private val fileName = "test.txt"
private val directory = "file"

fun main(){
//    createDirectory()
//    createFile()
    fileInfo()
}

// 디렉토리 생성
private fun createDirectory(){
    val dir = File(directory)
    if(!dir.exists()){
        dir.mkdirs()
    }
}

// 파일 생성
private fun createFile(){
    val file = File("$directory/$fileName")
    // use : try - with - resources 역할을 수행 (코틀린의 모든 예외는 unchecked exception)
    file.bufferedWriter().use {
        it.write("IO 태스트 입니다.")
    }
}

private fun fileInfo(){
    val file = File("$directory/$fileName")
    println("이름 : ${file.name}")
    println("경로 : ${file.absolutePath}")
    println("존재 여부 : ${file.exists()}")
    println("파일 여부 : ${file.isFile}")
    println("디렉토리 여부 : ${file.isDirectory}")
}