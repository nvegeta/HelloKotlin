import kotlin.math.* // 我们需要使用import来引入某些库，这样才能使用库函数

/**
 * 实用库函数
 */
fun main() {
//    val text = readln()
//    println("读取到用户输入：$text")

    println("......数学工具类......")
    println(1.0.pow(4.0)) // a的b次方
    println(abs(-1))
    println(max(19, 20))
    println(min(2, 4))
    println(sqrt(9.0)) //求一个数的算术平方根

    println("......三角函数......")
    println(sin(PI / 2)) //求π/2的正弦值，这里我们可以使用预置的PI进行计算
    println(cos(PI))
    println(tan(PI / 4))
    println(asin(1.0))
    println(acos(1.0))
    println(atan(0.0))

    println(sin(PI)) // 1.2246467991473532E-16 -> 0 其实这个数是非常接近于0，这是因为精度问题导致的，所以说实际上结果就是0

    println("......对数函数......")
    println(ln(E)) //e为底的对数函数，其实就是ln，我们可以直接使用Math中定义好的e
    println(log10(100.0)) //10为底的对数函数
    println(log2(8.0)) //2为底的对数函数
    //利用换底公式，我们可以弄出来任何我们想求的对数函数
    val a = ln(4.0) / ln(2.0) //这里是求以2为底4的对数，log(2)4 = ln4 / ln2
    println(a)

    println("......特殊计算......")
    println(ceil(4.5)) //通过使用ceil来向上取整
    println(floor(5.6)) //通过使用floor来向下取整

}
