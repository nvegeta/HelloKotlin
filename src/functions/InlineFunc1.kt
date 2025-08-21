package functions

/**
 * 内联函数
 */
/*
使用高阶函数会可能会影响运行时的性能：每个函数都是一个对象，而且函数内可以访问一些局部变量，但是这可能会在内存分配（用于函数对象和类）和虚拟调用时造成额外开销。

为了优化性能，开销可以通过内联Lambda表达式来消除。
使用`inline`关键字会影响函数本身和传递给它的lambdas，它能够让方法的调用在编译时，直接替换为方法的执行代码
 */

inline fun inlineFunc() {
    println("这是一个内联函数inlineFunc")
    println("这是一个内联函数inlineFunc")
    println("这是一个内联函数inlineFunc")
}

inline fun inlineFunc2(func: (String) -> Unit) {
    println("这是一个内联函数inlineFunc2")
    func("functions.HelloWorld")
}

inline fun inlineFunc3(func: (String) -> Unit) {
    println("这是一个内联函数inlineFunc3")
    func("functions.HelloWorld")
//    var a = func  // 内联函数中的函数形参，无法作为值给到变量，只能调用
}

inline fun inlineFunc4(func: (String) -> Unit) {
    func("functions.HelloWorld")
    println("调用内联函数inlineFunc4之后")
}

//在不需要内联的函数形参上添加noinline关键字，来防止此函数的调用内联
inline fun inlineFunc5(func: (String) -> Unit, noinline func2: (Int) -> Unit) {
    println("这是一个内联函数inlineFunc5")
    func("functions.HelloWorld")
    val a = func2 // 这样就不会报错，但是不会内联了
    func2(789)

}

fun main() {
    inlineFunc()
    /*
    由于inlineFunc函数是内联函数，在编译之后，会原封不动地把代码搬过去
    fun functions.basic.main() {
        println("这是一个内联函数")   //这里是test函数第一行，直接搬过来
        println("这是一个内联函数")
        println("这是一个内联函数")
    }
     */

    println("-----------------1------------------")
    inlineFunc2 { println("打印：$it") }
    /*
    fun functions.basic.main() {
        println("这是一个内联函数")   //这里是test函数第一行
        val it = "functions.HelloWorld"  //这里是函数内传入的参数
        println("打印：$it")  //第二行是调用传入的函数，自动贴过来
    }
     */

    // 由于内联，导致代码被直接搬运，所以Lambda中的return语句可以不带标签，这种情况会导致直接返回
    println("-----------------2------------------")
    /*functions.inlineFunc4 { return } //内联高阶函数的Lambda参数可以直接写return不指定标签
    println("调用上面方法之后")*/
    /*
    上述代码的运行结果就是，直接结束，两句println都不会打印，这种情况被称为**非局部返回**
     */

    // 在Kotlin中Lambda表达式支持一个叫做"标签返回"（labeled return）的特性，
    // 这使得你能够从一个Lambda表达式中返回一个值给外围函数，而不是简单地返回给Lambda表达式所在的最近的封闭函数
    println("-----------------3------------------")
    /*functions.inlineFunc4 { return@functions.basic.main }//标签可以直接指定为外层函数名称main来提前终止整个外部函数
    println("调用上面方法之后")*/
    /*
    效果跟上面是完全一样的，为了避免这种情况，我们也可以像之前一样将标签写为@test来防止非局部返回
     */
    println("-----------------4------------------")
    inlineFunc4 { return@inlineFunc4 } //这样就只会使inlineFunc4返回，而不会影响到外部函数了
    println("调用上面方法之后")


    // 有些时候，可能一个内联的高阶函数中存在好几个函数参数，但是我们希望其中的某一个函数参数不使用内联，能够跟之前一样随意当做变量使用
    println("-----------------5------------------")
    inlineFunc5({ println("我是一号：$it") }, { println("我是二号：$it") })
    /*
    fun functions.basic.main() {
        println("这是一个内联函数")
        val it = "functions.HelloWorld"
        println("打印：$it")
        //第二个参数由于不是内联，这里依然作为Lambda使用
        val func2: (Int) -> Unit = { println("我是二号：$it") }
        func2(666)
    }
     */

}