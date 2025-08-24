package encapInherPolymor


/**
 * 类的扩展
 * Kotlin提供了扩展类或接口的操作，而无需通过类继承或使用*装饰器*等设计模式，来为某个类添加一些额外的函数或是属性，我们只需要通过一个被称为*扩展*的特殊声明来完成。
 *
 * 例如，您可以从无法修改的第三方库中为类或接口编写新函数，这些函数可以像类中其他函数那样进行调用，就像它们是类中的函数一样，这种机制被称为*扩展函数*。
 * 还有*扩展属性*，允许您为现有类定义新属性
 *
 * 通过这种机制，我们可以将那些第三方类不具备的功能强行进行扩展，来方便我们的操作
 *
 * 注意，类的扩展是静态的，实际上并不会修改它们原本的类，也不会将新成员插入到类中，仅仅是将我们定义的功能变得可调用，使用起来就像真的有一样。
 * 同时，在编译时也会明确具体调用的扩展函数
 */

fun String.test() = "Extension Function to String class"

open class Shape
class Rectangle : Shape()

fun Shape.getName() = "Shape"
fun Rectangle.getName() = "Rectangle" //虽然这里同时扩展了父类和子类的getName函数

fun printClassName(s: Shape) { //但由于这里指定的类型是Shape，因此编译时也只会使用Shape扩展的getName函数
    println(s.getName())
}

class Test {
    fun hello() = println("Hello")
}

fun Test.hello() = "Hello Extension"
fun Test.hello(str: String) = println(str) //重载一个不同参数的同名函数

/*
可以看到直接扩展属性是不允许的，前面我们说过，扩展并不是真的往类中添加属性，因此，扩展属性本质上也不会真的插入一个成员字段到类的定义中，这就导致并没有变量去存储我们的数据，
我们只能明确定义一个getter和setter来创建扩展属性，才能让它使用起来真的像是类的属性一样
 */
//val Shape.width: Double = 23.78 //Extension property cannot be initialized because it has no backing field.
val Shape.length: Double
    get() = 34.52

/**
    backing field
 *
 */
class Person {
    var name: String = ""
        // 只有当你想自定义逻辑时才需要显式写 get()/set()
        get() {
            println("正在读取 name")
            return field  // 使用 field 关键字访问后备字段
        }
        set(value) {
            println("正在设置 name: $value")
            field = value  // 使用 field 关键字修改后备字段
        }
}

fun main() {
    val text = "Hello"
    println(text.test())
    println("-------类的扩展-------")
    printClassName(Rectangle())
    println("-------如果是类本身就具有同名同参数的函数，那么扩展的函数将失效-------")
    Test().hello()
    println("-------我们如果通过这种方式实现函数的重载，是完全没有问题的-------")
    Test().hello("World") //有效果
    println("-------属性的扩展-------")
    val s = Shape()
    println(s.length)
}