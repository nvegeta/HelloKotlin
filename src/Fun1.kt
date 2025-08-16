import kotlin.io.println

/**
 * 创建和使用函数
 */
fun hello(): Unit { // 本质上应该是返回Unit类型，这个类型表示空，类似于Java中的void，默认情况下可以省略
    println("Hello, Kotlin!")
}

/*
name : type
fun name() : returnType {} -> 有冒号后面就要写类型，不然会报错
 */
fun say(message: String) { // 行参
    println("I say: $message")
}

fun sum(a: Int, b: Int): Int { // 返回值
    return a + b
}

fun test(text: String = "我是默认值") {
    println(text)
}

/*
对于一些内容比较简单的函数，比如上面仅仅是计算两个参数的和，我们可以直接省略掉花括号，像这样编写：
fun test(a: Int = 6, b: Int = 10): Int = a + b   //函数的结果直接缩减为 = a + b 效果跟之前是一样的
fun test(a: Int = 6, b: Int = 10) = a + b  //返回类型可以自动推断，这里可以吧返回类型省掉
 */
fun test(a: Int = 6, b: Int = 10): Int {
//    a = 2 // 'val' cannot be reassigned. -> 函数的形式参数默认情况下为常量，无法进行修改，只能使用
    return a + b
}

fun outer() {
    val x = 5

    fun inner() {// 函数内部也可以定义函数
        println(x) // 内部函数可以访问外部函数中的变量
    }

    inner() // 函数内的函数作用域是受限的，我们只能在函数内部使用
}


fun main() {
    hello()

    val str: String = "Hello, Kotlin!"
    say(str) // 实参

    println(sum(3, 9))

    /*
    函数重载：编写同名但不同参数的函数
     */
    test() //调用函数时，如果对应参数有默认值，可以不填
    println(test(b = 3)) //这里如果只想填写第二个参数b，我们可以直接指定吧实参给到哪一个形参
    println(test(3)) //这种情况就是只填入第一个实参
}