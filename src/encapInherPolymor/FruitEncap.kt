package encapInherPolymor

/**
 * 类的封装
 */
class FruitEncap private constructor (private var name: String, private var calories: Int) { // 主构造函数改成私有的
    constructor() : this("Eggfruit", 99)

    fun getName(): String = name
    fun getCalories(): Int = calories

    /*
    这不就是我们之前讲的属性的getter和setter函数吗，没错，哪怕我们不手动编写，成员属性也会存在默认的。
    但是，除了直接赋值之外我们也可以设置更多参数才能给水果改名字
     */
    fun setName(name: String, upper: Boolean) { //使用set函数来修改
        this.name = if (upper) name.uppercase() else name.lowercase()
    }

    fun setCalories(cal: Int) {
        this.calories = cal
    }
}

fun main() {
    val f = FruitEncap()
//    f.name // 这样就不行了
    println(f.getName())
}