package classAndObjects

/**
 * 空值和空类型
 */
fun main() {
    // 在Kotlin中，对空值处理是非常严格的，正常情况下，我们的变量是不能直接赋值为`null`的，否则会报错，无法编译通过
//    var str: String = null // Null cannot be a value of a non-null type 'String'

    // 希望某个变量在初始情况下使用`null`而不去引用某一个具体对象
    var str: String? = null
    if (str != null) println(str.length)
    //使用非空断言操作符!!.来明确不会出现null问题
    println(str!!.length)
    // 更安全的空类型操作，要安全地访问可能包含`null`值的对象的属性，请使用安全调用运算符`?.`，如果对象的属性为`null`则安全调用运算符返回`null`
    println(str?.length)

    val f: Fruit2? = null
    println(f?.hello())


    // Elvis运算符 ?: 左侧为空值检测目标，右侧为检测到null时返回的结果
    val len: Int = str?.length ?: 0
}