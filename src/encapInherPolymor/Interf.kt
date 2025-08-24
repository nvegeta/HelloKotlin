package encapInherPolymor

/**
 * 接口
 * 由于Kotlin中不存在多继承的操作，我们可以使用接口来替代
 *
 * 在 Kotlin 接口中，不能使用幕后字段（backing field），因为：
 * - 接口没有状态存储（不能有字段）
 * - 接口只定义契约，不包含实现状态
 */
interface InterfA {
    var x: String //接口中所有属性默认都是abstract的（可省略关键字）
        get() = "default value" //只能重写getter，不能直接赋值，因为默认情况下getter是返回的field的值，但是接口里不让用
        set(value) { // ✅ 正确：不使用 field [默认的setter会直接报错，因为使用了field字段]
            println("Setting to: $value") // 不能存储值，但可以执行其他操作
//            this.x = value // ❌ 无限递归！
        }

    fun sleep() //接口中所有函数默认都是abstract的（可省略关键字）默认情况下是open的，除非private掉

    fun eat() = println("I'm eating") // 接口也可以为函数编写默认实现
}

interface InterfB {
    fun game()
}

class InterfImpl1 : InterfA, InterfB { //接口的实现与类的继承一样，直接写到后面，多个接口用逗号隔开
    override var x: String = "prop x" //跟抽象类一样，接口中的内容是必须要实现的
    override fun sleep() = println("I'm sleeping...")
    override fun game() = println("I'm gaming...")
}
/*
接口跟类的最大区别其实就是状态的保存，这从上面的成员属性我们就可以看的很清楚。
 */
interface InterfC {
    fun method1() = println("method 1 in InterfC")
    fun method() = println("method in InterfC")
}
interface InterfD {
    fun method2() = println("method 2 in InterfD")
    fun method() = println("method in InterfD")
}
interface InterfE: InterfC, InterfD { //接口的继承写法是一样的，并且接口继承接口是支持多继承的
    override fun method() { //手动重写method函数，自行决定如何处理冲突
        super<InterfC>.method() //使用super关键字然后添加尖括号指定对应接口，并手动调用接口对应函数
    }

}

class InterfImpl2 : InterfE //直接获得三个接口的功能

fun main() {
    /*
    将变量的类型设定为一个接口的类型，当做某一个接口的实现来使用，同时也支持`is`、`as`等关键字进行类型判断和转换
     */
    val a: InterfA = InterfImpl1()
    a.sleep() //直接当做A接口用（只能使用A接口中定义的内容）
    println(a is InterfB) //判断a引用的对象是否为B接口的实现类
}