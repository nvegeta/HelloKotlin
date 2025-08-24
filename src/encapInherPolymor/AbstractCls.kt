package encapInherPolymor

/**
 * 抽象类
 * 有些情况下，我们设计的类可能仅仅是作为给其他类继承使用的类，而其本身并不需要创建任何实例对象
 */
open class ClsSuper  protected constructor() { //无法构造这个父类，要求使用子类
    open fun hello() = println("Hello World!")

}

class ClsSubA: ClsSuper() {
    override fun hello() = println("Hello Implementation A") //两个子类都对hello进行了实现，采用各自的方式
}

class ClsSubB: ClsSuper() {
    override fun hello() = println("Hello Implementation B")
}

//使用abstract表示这个是一个抽象类
abstract class AbstractClsA {
    abstract val type: String //抽象类中可以存在抽象成员属性
    abstract fun hello() //抽象类中可以存在抽象函数
    //注意抽象的属性不能为private，不然子类就没法重写了

    //  同样可以定义非抽象的属性或函数
    fun test() = println("Method defined in AbstractCls") //定义非抽像属性或函数，在子类中不强制要求重写
}

class AbstractClsImplA(override val type: String = "Implementation A") : AbstractClsA() {
    override fun hello() {
        println("Hello Implementation A")
    }

}

//抽象类也可以继承自其他的类（可以是抽象类也可以是普通类）
open class CommonCls
abstract class AbstractClsB : CommonCls() //直接继承一个普通的类