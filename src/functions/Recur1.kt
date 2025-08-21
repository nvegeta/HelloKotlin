package functions

/**
 * 递归函数
 */
fun test(n: Int): Int { //这个函数实现了计算0-n的和的功能
    if (n <= 0) return 0 //当n等于0的时候就不再向下，而是直接返回0
    return n + test(n - 1) //n不为0就返回当前的n加上test参数n-1的和
}

fun fibonacci(n: Int): Int {
    if (n <= 2) return 1 //我们知道前两个一定是1，所以直接返回
    return fibonacci(n - 1) + fibonacci(n - 2) //当前fib(n)的结果就是前两个结果之和，直接递归继续找
}

/*
tailrec: 尾部作为返回值进行递归
 */
tailrec fun test2(n: Int, sum: Int = 0): Int {
    if (n <= 0) return sum //到底时返回累加的结果
    return test2(n - 1, sum + n) //不断累加
}

tailrec fun fibonacci2(n: Int, prev: Int = 0, next: Int = 1): Int {
    return if (n == 0) prev else fibonacci2(n - 1, next, prev + next) //从0和1开始不断向后，直到n为0就返回
}

fun main() {
    println(test(5))
    println(test2(5))

    println(fibonacci(8))
    println(fibonacci2(8))
}