package classAndObjects

/**
 * 3. 对象初始化
 *
 */
class Fruit(var name: String, var calories: Int) {
    /*
    >>> 无论是有主构造函数还是没有主构造函数（会生成一个默认的无参构造函数）都会先执行
     */
    //由于主构造函数无法编写函数体
    //因此我们可以在init的花括号中编写初始化代码
    //注意这段初始化代码块，是在上面的类属性被赋值之后才执行的，所以说能拿到已经赋值的age属性
    init {
        println("This is an initialization.")
        if(calories < 10) calories = 10
        println("Initialization finished.")
    }

    //注意，多个初始化操作时，从上往下按顺序执行
    init {
        println("This is an initialization [2].")
    }

    // 将成员属性写到类中的情况，同样是按照顺序向下执行
    val a = 999
    init {
        println("This is an initialization [3].")
        println("Member properties a = ${a}.")
    }

    // 次要构造函数实际上需要先执行主构造函数，而在执行主构造函数时，会优先将之前我们讲解的初始化代码块执行
    constructor(name: String) : this(name, 0) {
        println("This is a secondary constructor...") // 在次要构造函数中编写一些初始化代码
    }
}


fun main() {
    val f1 = Fruit("Apricot", 20)
    println(f1.calories)
    val f2 = Fruit("Avocado")
    println(f2.calories)

}