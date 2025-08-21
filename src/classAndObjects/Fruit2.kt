package classAndObjects

/**
 * 4. 类的成员函数
 */
class Fruit2(private var name: String, private var calories: Int) {
    fun hello() {
        println("Hello, Everyone!")
    }

    fun introduction() {
        println("I'm $name with calories $calories")
    }

    fun changeName(name: String) {
        println("The name is $name") // 优先使用作用域最近的一个
        println("The original name is ${this.name}") // 如果我们需要获取的是类中的成员属性，需要使用`this`关键字来表示当前类
    }

    // 方法重载
    fun hello(txt: String) {
        println("Hello $txt")
    }
}

fun main() {
    val f1 = Fruit2("Apricot", 123)
    f1.hello()
    f1.introduction()
    f1.hello("World")

    println("----------------------------------")
    val f2 = Fruit2("Banana", 89)
    f2.hello()
    f2.introduction()
    f2.changeName("Blackberry")
}