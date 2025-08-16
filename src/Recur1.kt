/**
 * 递归函数
 */
fun test(n: Int): Int { //这个函数实现了计算0-n的和的功能
    if (n <= 0) return 0 //当n等于0的时候就不再向下，而是直接返回0
    return n + test(n - 1) //n不为0就返回当前的n加上test参数n-1的和
}

fun fibonacci(n: Int): Int {
    if (n <= 2) return 1
    return fibonacci(n - 1) + fibonacci(n - 2)
}

fun main() {
    println(test(5))
}