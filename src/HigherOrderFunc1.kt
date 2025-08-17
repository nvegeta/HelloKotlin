/**
 * 高阶函数: 正是得益于函数可以作为变量的值进行存储，因此，如果一个函数接收另一个函数作为参数，或者返回值的类型就是一个函数，那么该函数称为高阶函数
 *
 * Function as parameter	函数作为参数	list.filter { it > 0 }
 * Function as return type	函数作为返回值	fun makeLogger(): (String) -> Unit { ... }
 * Lambda expression	Lambda 表达式	{ x: Int -> x * 2 }
 * unction reference	函数引用	::println
 *
 */

//典型的函数类型 (参数...) -> 类型  小括号中间是一个剪头一样的符号，然后最后是返回类型
var func0: ((Int) -> Unit)? = null // [初始为null, 后续赋值] 这里的 (Int) -> Unit 表示这个变量存储的是一个有一个int参数并且没有返回值的函数
var func1: (Double, Double) -> String = { _, _ -> "" } // [默认空实现] 同理，代表两个Double参数返回String类型的函数

fun test(other: (Int) -> String) { // 作为函数的参数也可以像这样表示
    println(other(1)) //这里提供的函数接受一个Int参数返回string，那么我们可以像普通函数一样传入参数调用它
}

// 由于函数可以接受函数作为参数，所以说你看到这样的套娃场景也不奇怪
//var func: (Int) -> ((String) -> Double) = TODO()
// 不过这样写可能有些时候不太优雅，我们可以为类型起别名来缩短名称
typealias HelloWorld = (String) -> Double

fun main() {
    var func: HelloWorld

    fun test1(str: String): Int {
        return str.toInt()
    }

    val func2: (String) -> Int = ::test1 //使用双冒号来引用一个现成的函数

    val func3: (String) -> Int = fun(str: String): Int { // 实用匿名函数
        println("这是传入的内容$str")
        return str.toInt()
    }

    val func4: (String) -> Int = { //一个Lambda表达式只需要直接在花括号中编写函数体即可
        println("这是传入的参数：$it") //默认情况下，如果函数只有一个参数，我们可以使用it代表传入的参数
        it.toInt() //跟之前的if表达式一样，默认最后一行为返回值
    }

    println(func4("41"))

    val func5: (String, String) -> Unit = { str1, str2 -> //我们需要手动添加两个参数这里的形参名称，不然没法用他两
        println("这是传入的第一个参数$str1, 第二个参数$str2") //直接使用上面的形参即可
    }

    val func6: (String, String) -> Unit = { _, str2 ->
        println("这是传入的第二个参数$str2")   //假如这里不使用第一个参数，也可以使用_下划线来表示不使用
    }

    func5("Hello", "World")


    println("......调用一个高阶函数的方式......")

    // 1. 最直接的方式
    fun test2(func: (Int) -> String) {
        println(func(87))
    }

    val func7: (Int) -> String = { "收到的参数为$it" }
    test2(func7)

    // 2. 直接把一个Lambda作为参数传入作为实际参数使用
    test2({ "收到的参数为$it" })
    // 3. 如果函数的最后一个形式参数是一个函数类型，可以直接写在括号后面
    test2() { "收到的参数为$it" }
    // 4. 由于小括号里面此时没有其他参数了，还能继续省，直接把小括号也给干掉
    test2 { "收到的参数为$it" }


    fun test3(i: Int, func: (Int) -> String) {
        println(func(36))
    }
    test3(1) { "收到的参数为$it" }// 如果在这之前有其他的参数，只能写成这样了
    /*
    这种语法也被称为 尾随lambda表达式，能省的东西都省了，不过只有在最后一个参数是函数类型的情况下才可以，如果不是最后一位，就没办法做到尾随了
     */

    // 最后需要特别注意的是，在Lambda中没有办法直接使用`return`语句返回结果，而是需要用到之前我们学习流程控制时用到的标签
    val func8: (Int) -> String = test2@{
        //比如这里判断到it大于10就提前返回结果
        if(it > 10) return@test2 "我是提前返回的结果"
        println("我是正常情况")
        "收到的参数为$it"
    }
    test2(func8)

    // 如果是函数调用的尾随lambda表达式，默认的标签名字就是函数的名字
    fun testName(func: (Int) -> String) {
        println(func(26))
    }
    testName { // 默认使用函数名称
        if (it > 10) return@testName "我是提前返回的结果"
        println("我是正常情况")
        "收到的参数为$it"
    }
}


