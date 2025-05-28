package h_collection

fun main(){
    //immutable list
    val list = listOf(1,2,3,4,5)
    val mutableList = mutableListOf<Int>(1,2,3,4,5)

    mutableList.addLast(0)
    println(list)
    println(mutableList)

    println("=============")
    val set = setOf(1,2,3,4,5,6)
    val mutableSet = mutableSetOf(1,2,3,4)

    println(set)
    println(mutableSet)

    println("==============")

    val map = mapOf(Pair("name", "lsh"), Pair("age", "100"))
    val ageMap = mapOf("lsh" to 30, "hmd" to 30)
    println(map)
    println(ageMap)
    println(map["name"])
}