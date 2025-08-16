/**
 * 流程控制语句 [when] 类似Java和C语言中的`switch`语句
 */
fun main() {
    val c = 'A'

    when (c) {
        'A' -> println("去尖子班！准备冲刺985大学！")
        'B' -> println("去平行班！准备冲刺一本！")
        'C' -> println("去职高深造。")
    }

    val numericValue = when (c) {
        'B' -> 0
        'A' -> 1
        else -> 2    //还有其他情况，这里必须添加else，不然其他情况岂不是没返回的东西？
    }

    /*
    在`when`*语句*中，遇到以下情况，携带`else`分支是必须的：
        - `when`分支中仅有一个`Boolean`类型、枚举 或 密封，以及用于判断的目标变量是可空的情况（后面会讲解）
        - `when`分支没有包括该判断目标的所有可能的值。
     */
    when (numericValue) {
        0, 1 -> print("numericValue == 0 or numericValue == 1")
        else -> print("otherwise")
    }

    val score = 10
    val grade = when(score) {
        //使用in判断目标变量值是否在指定范围内
        in 100..90 -> "优秀"
        in 89..80 -> "良好"
        in 79..70 -> "及格"
        in 69..60 -> "牛逼"
        else -> "不及格"
    }
}