package basic

/**
 * 流程控制语句 [if-else]
 */
fun main() {
    val score = 2

    if (score >= 90) //90分以上才是优秀
        println("优秀")
    else if (score >= 70) //当上一级if判断失败时，会继续判断这一级
        println("良好")
    else if (score >= 60) {
        println("及格")
    }
    else  //当之前所有的if都判断失败时，才会进入到最后的else语句中
        println("不及格")


    //这里判断socre是否大于60，是就得到Yes，否就得到No，并且可以直接赋值给变量
    val res = if (score > 60) "Yes" else "No"

    println(res)


}