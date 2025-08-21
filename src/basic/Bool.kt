package basic

/**
 * 布尔类型
 */
fun main() {
    val a = 10
    val b = 8
    println(a == b)
    println(a >= b)
    println(a < b)
    val c: Boolean = a != b
    println(c)

    /*
    区间：in !in
    a..b = [a, b]
    a..<b = [a, b)
     */
    println("...........区间...........")
    println(a in 1..10)
    println(a in 1..<10)
    println(a !in 1..10)

    println("...........逻辑与/或...........")
    println(100 >= a && b >= 60)
    println(100 >= a || b >= 60)
}