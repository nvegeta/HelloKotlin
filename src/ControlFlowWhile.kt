/**
 * 流程控制语句 [while]
 */
fun main() {

    var i = 100
    while (i > 0) {
        if (i < 10) break
        println(i)
        i /= 2
    }

    var i1 = 0 //比如现在我们想看看i不断除以2得到的结果会是什么，但是循环次数我们并不明确
    do {  //无论满不满足循环条件，先执行循环体里面的内容
        println("Hello World!")
        i1++
    } while (i1 < 10) //再做判断，如果判断成功，开启下一轮循环，否则结束


}