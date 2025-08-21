package classAndObjects

/**
 * 再谈基本类型
 */
fun main() {
    var a = 10 //这里其实是一个Int类型的对象，值为10，而a持有的是对这个Int对象的引用
    var b = a //这里的b复制了对上面Int类型对象的引用

    /*
    **特别说明：**
    * 在Kotlin中，虽然编码时万物皆对象，但是在最终编译时，会根据上下文进行优化性能，大部分情况下会优先编译为Java原生基本数据类型（不是对象）
    * 而另一部分情况下才会编译为Java中的Integer包装类型。因此很容易出现以下迷惑行为：
     */
    val c: Int = 12345
    val d: Int = 12345
    println(c === d) // true
    val e: Int? = 12345 // ? -> nullable -> wrapper types
    val f: Int? = 12345
    println(e === f) // false

    // 既然这些基本类型也是类，那么肯定同样具有成员属性和成员函数，我们可以使用这些成员方法方便我们的项目开发
    val g: Int = 1.25.toInt() //使用类中的类型转换函数

    val h = "Hi"
    println(h.uppercase())
    println(h.lowercase())
    println(h.replace("i", "a"))
    println(h.startsWith("H"))
    println(h.isEmpty())
    println(h.isBlank())
    /*
    不过需要注意的是，我们在前面就说过，字符串一旦创建就是不可变的，
    因此，字符串中所有的函数得到的新字符串，都是重新创建的一个新的对象，而不是在原本的字符串上进行修改
     */


}