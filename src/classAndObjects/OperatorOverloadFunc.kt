package classAndObjects

/**
 * 运算符重载函数
 */
class Fruit3(var name: String, var calories: Int) {
    //注意，二元运算符必须带一个形参，表示右侧的操作数，返回值为计算出来的结果
    //形参和结果可以是任意类型，我们还可以提供多次编写同名的运算符重载函数来适配不同的类型
    operator fun plus(another: Fruit3): Fruit3 {
        //比如这里我们希望两个对象相加，得到的结果为名字相加，卡路里相加的一个新水果
        return Fruit3(this.name + another.name, this.calories + another.calories)
    }

    operator fun not(): Fruit3 { // 重载一元运算符 - 取反运算符
        this.name = this.name.reversed()
        return this //这里可以直接在当前对象上进行操作，然后返回当前对象
    }
}

fun main() {
    val a = Fruit3("Apple", 30)
    val b = Fruit3("Banana", 50)
    val c = a + b;
    println("运算后得到的新水果，名称：${c.name}, 热量：${c.calories}")
    val d = !c
    println("运算后得到的新水果，名称：${d.name}, 热量：${d.calories}")

}