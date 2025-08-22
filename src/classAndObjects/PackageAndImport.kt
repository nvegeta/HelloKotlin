package classAndObjects

import com.test.User //使用import关键字进行导入，导入时需要输入 包名.类型/顶级函数名称 来完成
import com.test.message as outer // 我们可以使用`as`关键字来为导入的内容起个新的名字

fun main() {
    val u = User()
    /*
    优先使用导入的函数，而不是在当前文件中定义的同名函数
    如何去解决这种冲突的情况呢？我们可以使用`as`关键字来为导入的内容起个新的名字
     */
    message()

    outer()
}

fun message() {
    println("I'm a message method in PackageAndImport.kt")
}