package e_oop.f_object

// singleton 으로 생성되는 객체
// 생성자를 가질 수 없다.
object JdbcTemplate {
    // 싱글톤으로 올라가는 객체의 특성 상 setter, getter 로 열어주지 않는 것이 안전
    const val user: String = "admin"
    val password: String = "1234"

    fun connect() {
        println("연결")
    }

    fun commit() {
        println("commit")
    }

}

fun main() {
    // 바로 객체에 접근해서 사용 가능
    println(JdbcTemplate.user)
    println(JdbcTemplate.password)
    println(JdbcTemplate.commit())
    println(JdbcTemplate.connect())
}
