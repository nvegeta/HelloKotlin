package basic

/**
 * 字符类型
 */
fun main() {
    val c: Char = 'A'
    println(c)
    println(c.code)

    val checkMarker = '\u2713' //符号✓对应的Unicode编码为10003，这里需要转换为16进制表示，结果为0x2713
    println(checkMarker)
}