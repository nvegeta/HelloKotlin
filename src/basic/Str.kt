package basic

/**
 * 字符串
 * 注意，字符串中的字符一旦确定，无法进行修改，只能重新创建。
 */
fun main() {
    val str: String = "Hello\nworld"
    println(str)

    val text = """
    这是第一行
    这第二行
    别\n了，没用
    真牛逼啊，这功能隔壁Java15才有
    """
    println(text)


    // 我们需要注意字符串拼接的顺序，只能由字符串拼接其他类型，如果是其他类型拼接字符串，可能会出现问题
    //    println(10 + functions.str) // ERROR
    println(str + 10)

    val a = 10
    println("$a$str")

    val text2 = "$a 这是拼接的值" //注意这里$a之后必须空格，否则会把后面的整个字符串认为这个变量的名字
    val text3 = "${a}这是拼接的值"  //添加花括号就可以消除歧义了
    val text4 = "${a > 0}这是拼接的值"  //花括号中也可以写成表达式

    val text5 = "\$这是美元符"   //普通字符串直接使用\$表示
    //原始字符串要套个娃
    val str2 = """
  ${'$'}这是美元符    
	"""
}
