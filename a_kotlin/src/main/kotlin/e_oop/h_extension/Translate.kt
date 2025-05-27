package e_oop.h_extension

// 확장함수의 확장속성
private val Payment.chinaPrice:String
    // payment 의 this 가 전달됨
    get() = "${this.payPrice / 200} wian"

fun main(){
    val payment = Payment("아메리카노", 3, 9000)
    println(payment.chinaPrice)
}