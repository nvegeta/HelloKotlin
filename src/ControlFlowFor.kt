/**
 * 流程控制语句 [for]
 */
fun main() {

    for (i in 0..9) {
        if (i == 1) continue
        if (i == 9) break
        println(i)
    }

    println("...倒着遍历...")

    for (i in 9 downTo 0 step 2) {
        println(i)
    }

    println("...嵌套循环...")

    outer@ for (i in 1..3) {   //在循环语句前，添加 标签@ 来进行标记
        inner@ for (j in 1..3) {
            if (i == j) break@inner  //break后紧跟要结束的循环标记，当i == j时终止内层循环
            println("$i, $j")
        }
    }

}