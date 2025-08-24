package encapInherPolymor

/**
 * 属性的覆盖
 */
open class FruitSuper {
    //注意，跟类一样，函数必须添加open关键字才能被子类覆盖
    open fun hello() = println("Hello World")

    open val test: String = "Here is a msg in superclass"
    fun printTest() = println("val test's value: $test") //这里拿到的test就会变成被覆盖掉的

    open val name: String = "Fruit superclass"

    init {
        println("init in super class: name is $name") //这里拿到的name实际上是还未初始化的子类name -> null
    }
}

//在主构造函数中覆盖，也是可以的，这样会将构造时传入的值进行覆盖
class FruitSubA(override val name: String) : FruitSuper() {
    fun makeJuice() = println("Fruit subA can make juice")

    //在子类中编写一个同名函数，并添加override关键字，我们就可以在子类中进行覆盖了，然后编写自己的实现
    override fun hello() { //覆盖父类函数
        super.hello() //使用super.xxx来调用父类的函数实现，这里super同样表示父类
        println("Hello World, I'm FruitSub") //再写自己的逻辑
    }

    override val test: String = "Here is a msg in subclass"

}

class FruitSubB(override val name: String) : FruitSuper() {
    fun addToTea(): Boolean {
        println("Fruit subB can be added to tea")
        return true
    }
}

fun main() {
    val f = FruitSubA("Fruit subclass A")
    println("-------覆盖父类方法-------")
    f.hello()
    println("-------覆盖父类变量-------")
    f.printTest()
    println("-------把子类当父类使用-------")
    val f2: FruitSuper = FruitSubA("Fruit subclass A")
    f2.hello()
    println("-------多个子类进行类型判断-------")
    println(f2 is FruitSubA) //true，因为确实是这个类型
    println(f2 is FruitSubB) //false，因为不是这个类型
    println(f2 is FruitSuper) //true，因为是这个类型的子类
    println("-------类型转换-------")
    if (f2 is FruitSubA) {
        val f3 = f2 as FruitSubA
        f3.makeJuice() //强制类型转换之后，可以直接变回原本的类型去使用
    }
    println("-------智能转换-------")
    /*
    不仅仅是if判断的场景、包括when、while，以及`&&` `||` 等运算符都支持智能转换，只要上下文语境符合就能做到
     */
    val f4: FruitSuper? = FruitSubB("Fruit subclass B")
    while (f4 is FruitSubB) f4.addToTea() // 根据语境直接智能转换
    if (f4 is FruitSubB && f4.addToTea()) { //很明显如果这前面已经判断为真了，那肯定是这个类型，后面也可以智能转换
        return
    }
    f4?.hello()
    if (f4 != null) { //判断到如果不为null
        f4.hello() //根据语境智能转换为了非空类型
    }
    // 在处理一些可空类型时，为了防止出现异常，我们可以使用更加安全的`as?`运算符
    val f5: FruitSuper? = FruitSubB("Fruit subclass B")
    val f6: FruitSubB? = f5 as? FruitSubB //当f5为null时，不会得到异常，而是返回null作为结果
}