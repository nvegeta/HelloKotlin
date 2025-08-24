package generics

import kotlin.system.exitProcess

//因为Any是所有类型的父类，因此既可以存放Int也能存放String
class ScoreAny(var name: String, var id: String, var value: Any)

//这里的T就是一个待定的类型，同样是这个类具有的，我们称为泛型参数
class Score<T>(var name: String, var id: String, var value: T) {
    fun test() {
        println(value) // 而泛型类型在类内部使用时，由于无法确定具体类型，也只能当做Any类去使用
//        val t = T() // 不能通过这个不确定的类型变量就去直接创建对象
    }
}

// 可以一次性定义多个类型参数
class GenericA<K, V>(val key: K, val value: V)

fun <K : Comparable<V>, V> test() {} //类型参数中第一个类型参数可以直接推断得到

interface InterfA<T> {}

/*
    子类在继承时，可以选择将父类的泛型参数给明确为某一类型，或是使用子类定义的泛型参数作为父类泛型参数的实参使用
*/
abstract class AbstractA<T> {
    abstract fun test(): T
}

class ImplA : AbstractA<String>() { //子类直接明确为String类型
    override fun test(): String = "Hello World" //明确后所有用到泛型的地方都要变成具体类型
}

abstract class AbstractB<D> : AbstractA<D>() { //子类也有泛型参数D
    abstract override fun test(): D
}

//在函数名称前添加<T>来增加类型参数，之后函数的返回值或是参数都可以使用这个类型
fun <T> test1(t: T): T = t
//在使用函数类型的参数时，我们可以使用泛型来代表不确定的类型
fun <T> test2(func: (Int) -> T): T { //只要是有类型的地方都可以用T代替
    return func(1)
}
fun <T> test2(func: T.() -> Unit) { //甚至还可以是T类型的扩展函数

}

fun main() {
    val s1 = ScoreAny("Data Structure and Algorithm", "EP074512", "A")
    val s2 = ScoreAny("Operation System", "EP074533", 95)

    val a: Int = s2.value as Int //获取成绩需要进行强制类型转换

    val s3 = Score<String>("Data Structure and Algorithm", "EP074512", "A")
    val v3 = s3.value //得到的直接就是String类型的结果

    /*
    泛型将数据类型的确定控制在了编译阶段，在编写代码的时候就能明确泛型的类型，如果类型不符合，将无法通过编译，
    同时，如果我们这里填入的参数明确是一个String类型的值，创建时不需要指定T的类型也会自动匹配
     */
    val s4 = Score("Operation System", "EP074533", 95) //自动匹配为Int类型

    test<Int, _>() // 下划线运算符可以自动推断类型


    val implA = ImplA()
    println(implA.test())

    val v2: String = test1("Hello World from test1 function") //调用函数时自动明确类型
}

