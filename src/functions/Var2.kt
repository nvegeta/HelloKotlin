package functions

/**
 * 再谈变量
 */
var str: String = "Hello World " //顶层定义的变量跟定义函数一样，直接写在Kt文件中
    get() {
        println("获取变量的值：") //获取的时候打印一段文本
        return field + "Kotlin" // 使用filed代表当前这个变量(字段)的值，这里返回值拼接的结果
    }
    set(value) { //这里的value就是给过来的值
        println("设置变量的值：")
        field = value //注意，对于val类型的变量，没有set函数，因为不可变
    }

val strConst get() = str // 一个常量有些时候可能会写成这样， 当然，默认情况下其实没有必要去重写get和set除非特殊需求

/*
作用域的提升，使得变量可以被随意使用

var <propertyName>[: <PropertyType>] [= <property_initializer>]
    [<getter>]
    [<setter>]
 */
fun main() {
    println(str)

}

fun test() = println(str)

