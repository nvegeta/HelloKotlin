package classAndObjects

/**
 * 中缀函数 [eg 位运算 println(i shl 1)]
 * 用`infix`关键字标记的函数被称为中缀函数，在使用时，可以省略调用的点和括号进行调用，Infix函数必须满足以下要求：
 *
 * - 必须是成员函数。
 * - 只能有一个参数。
 * - 参数不能有默认值。
 */
class Fruit4(var name: String, var calories: Int) {
    infix fun test(str: String): String{
        //这个中缀函数实现了将给定字符串与当前对象的名字拼接并返回
        return name + str
    }

    infix fun add(str: String) {
        /*...*/
    }

    fun build() { // 如果需在类中使用中缀函数，必须明确函数的调用方（接收器）
        this add "abc"
        add("abc")
//        add "abc" // 错误: 没有指定调用方或无法隐式表达
    }
}

fun main() {
    val f = Fruit4("Date", 50)
    println(f test " Yummy") // 像运算符一样使用
    println(f.test(" Yummy")) // 也可以把它当做一个普通的函数进行调用，效果是完全等价的

}

/*
中缀函数调用的优先级低于算术运算符、类型转换和`rangeTo`运算符，例如以下表达式就是等效的：

- `1 shl 2 + 3`相当于`1 shl (2 + 3)`
- `0 until n * 2`相当于`0 until (n * 2)`
- `xs union ys as Set<*>`相当于`xs union (ys as Set<*>)`（类型转换会在下一章多态进行介绍）

另一方面，infix函数调用的优先级高于布尔运算符`&&`和`||`、`is`-和`in`-checks以及其他一些运算符的优先级。这些表达式也是等价的：

- `a && b xor c`相当于`a && (b xor c)`
- `a xor b in c`相当于`(a xor b) in c`
 */