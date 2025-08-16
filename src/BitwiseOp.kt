/**
 * 位运算操作
 */
fun main() {
    val a = 9 // 1001
    val b = 3 // 0011
    val c = a and b // 0001
    val d = a or b // 1011
    val e = a xor b // 1010

    val i127 = 127 // 01111111
    val f = i127.inv() // 10000000

    val g = 1 shl 2 // 00000001 -> 00000100 左移两位，尾部使用0填充 -> *2
    val h = -8 shr 2
    /*
    无符号右移是ushr，移动会直接考虑符号位
    11111111 11111111 11111111 11111111 [-1]
    ->
    01111111 11111111 11111111 11111111 [正数的最大值 2147483647]（无符号右移使用0填充高位）

    注意，不存在无符号左移操作
     */
    val i = -1 ushr 1 //


    println("Bitwise AND: $c")
    println("Bitwise OR: $d")
    println("Bitwise XOR: $e")
    println("Bitwise NOT: $f")
    println("Left shift: $g")
    println("Right shift: $h")
    println("Unsigned right shift: $i")
}