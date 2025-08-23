package encapInherPolymor

import classAndObjects.Fruit

/**
 * 类的继承
 * 默认情况下，Kotlin类是“终态”的（不能被任何类继承）要使类可继承，请用`open`关键字标记需要被继承的类
 */
open class FruitInher {
    constructor(name: String)
    constructor(name: String, calories: Int)
    init {
        println("FruitInher initialized")
    }
    val xxx = "Fruit Family"
    fun sayHi() = println("Hello World!")

}

//子类必须适配其父类的构造函数，因为需要先对父类进行初始化
//其实就是去调用一次父类的构造函数，填入需要的参数即可，这里的参数可以是当前子类构造方法的形参，也可以是直接填写的一个参数
//如果父类存在多个构造函数，可以任选一个
open class CitrusFruit(name: String, calories: Int) : FruitInher(name, 100) { //以调用构造函数的形式进行声明
    init {
        println("Citrus Fruit initialized")
    }
    fun makeJuice() = println("Fresh juice is delicious and refreshing!")
}

//子类不写主构造函数时，可以直接在冒号后面添加父类类名
open class Orange: CitrusFruit{
    constructor(name: String): this(name, 220) //也可以调用子类其他构造函数，但是其他构造函数依然要间接或直接调用父类构造函数
    constructor(name: String, calories: Int): super(name, calories) //使用super来调用父类构造函数,super表示父类（超类）
}

class NavelOrange(name: String, calories: Int): Orange(name, calories)

fun main() {
    var fruit = CitrusFruit("Citrus Fruit", 200)
    fruit.sayHi()
    fruit.makeJuice()
    println(fruit.xxx)
}
/*
* 构造函数相当于是这个类初始化的最基本函数，在构造对象时一定要调用
* 主构造函数因为可能存在一些类的属性，所以说必须在初始化时调用，不能让这些属性初始化时没有初始值
* 子类因为是父类的延展，因此，子类在初始化时，必须先初始化父类，就好比每个学生都有学生证，这是属于父类的属性，如果子类在初始化时可以不去初始化父类，那岂不是美术生可以没有学生证？显然是不对的。

优先级关系：父类初始化 > 子类主构造 > 子类辅助构造
* Kotlin 的构造函数调用链必须保持：次构造 → 本业主构造 → 父业主构造 的顺序
 */