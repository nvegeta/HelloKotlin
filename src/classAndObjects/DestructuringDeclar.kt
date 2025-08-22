package classAndObjects

/**
 * 解构声明
 */
class Fruit5(var name: String, var calories: Int) {
    operator fun component1() = name //使用component1表示解构出来的第一个参数
    operator fun component2() = calories//使用component2表示解构出来的第二个参数
}

fun main() {
    val f = Fruit5("Banana", 89)
    val (a, b) = f // 解构出来的参数按顺序就是componentN的结果了
    println("name = $a, calories = $b")
    val (_, c) = f // 只想要使用第二个参数，而第一个参数不需要，可以直接使用`_`来忽略掉
    println("only destructuring calories = $c")

    println("-------解构用在Lambda表达式中-------")
    val func: (Fruit5) -> Unit = { (c1, c2) -> println("name = $c1, calories = $c2") }
    /*
    为什么说这是"函数式接口的实现"？
        (Fruit5) -> Unit 定义了一个接口契约：
            接收一个 Fruit5 参数
            返回 Unit（相当于 void）

        { fruit -> ... } 提供了这个接口的具体实现。

        func 变量持有这个实现实例的引用。
     */
    val func2: (Fruit5, Int) -> Unit = { (c1, c2), i ->
        println("name = $c1, calories = $c2")
        println(i)
    }
    val func3: (Fruit5, Int) -> Unit = { (_, c2), i ->
        println("calories = $c2")
        println(i)
    }

    func3(f, 785)
}