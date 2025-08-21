package classAndObjects

/**
 * 1. 类的定义
 * 2. 对象创建：
 * 除了直接在某个.kt文件中直接编写之外，为了规范，我们一般将一个类单独创建一个文件
 */
class Student0 { // √√√ 1.1 使用关键字`class`声明
    //在没有任何内容时，花括号可以省略
}


class Student constructor(var name: String, val age: Int = 18) { // √√√ 1.2 主构造函数是类定义的一部分
    /*
    比如学生有name和age属性，那么我们可以在类名后面constructor的括号中编写，并用逗号隔开
    这里跟定义变量差不多，也是变量名称:类型，这些作为类的成员属性，后续可以在类中使用
    如果主构造函数没有任何注释或可见性修饰符，则可以省略`constructor`关键字，如果类中没有其他内容要写，可以直接省略花括号，最后就变成这样了:
    class Student(name: String, age: Int)
    这里仅仅是定义了构造函数的参数，这还不是类的属性，
    √√√ 1.3 那么我们要怎么才能定义为类的属性呢？我们可以为这些属性添加`var`或`val`关键字来表示这个属性是可变还是不变的
    class Student(var name: String, val age: Int)
    这样才算是定义了类的属性，我们也可以给这些属性设置初始值
    class Student(var name: String, val age: Int = 18)  //默认每个学生18岁
     */
}

/**
 * √√√ 1.4 除了将属性添加到构造函数中，我们也可以将这些属性直接作为类的成员变量写到类中，但是这种情况必须要配一个默认值，否则无法通过编译
 */
class Student1 {
    var name: String = "" //必须配一个默认值
    var age: Int = 0
    /*
    这样我们就可以不编写主构造函数也能定义属性，但是这里仍然会隐式生成一个无参的构造函数
     */
}

/**
 * √√√ 1.5 为了构造函数能够方便地传值初始化，也可以像这样写：
 */
class Student2(name: String, age: Int) {
    var name: String = name //通过构造函数传递过来
    val age: Int = age
}

/**
 * √√√ 1.6 如果各位不希望这些属性在一开始就有初始值，而是之后某一个时刻去设定初始值，我们也可以为其添加懒加载
 */
class Student3 {
    lateinit var name: String //懒加载的属性可以不用在一开始赋值，但是在下一次使用之前一定要先完成赋值，否则报错
    var age: Int = 0
}

/**
 * √√√ 1.7 像这样编写的类成员变量，也可以自定义对应的getter和setter属性
 */
class Shape(var width: Int, var height: Int) {
    val area get() = width * height
}

/**
 * √√√ 1.8 添加次要构造函数
 */
class Student4(var name: String, val age: Int) {
    //这里可以使用constructor关键字继续声明次要构造函数
    //次要构造函数中的参数仅仅是表示传入的参数，不能像主构造函数那样定义属性
    //这里的this表示是当前这个类，this()就是调用当前类的构造函数
    constructor(name: String) : this(name, 18) // //这里其实是调用主构造函数，并且参数只有name，年龄直接给个默认值18
}

/**
 * √√√ 1.9 如果一个类没有主构造函数，那么我们也可以直接在在类中编写次要构造函数，
 * 但是不需要主动委托一次主构造函数，他这里会隐式包含，所以说我们直接写就行了
 */
class Student5 {
    constructor(str: String) { //注意，这里的参数不是类属性，仅仅是一个形参！
        println("我的名字是: $str") // 次要构造函数可以编写自定义的函数体
    }
}

fun main() {
    println("------对象的创建------")

    // √√√ 2.1 我们可以直接使用 类名() 的形式创建对象 - 无参构造
    Student1()
    // √√√ 2.2 有构造函数的类，我们只需要填写需要的参数即可，调用之后，类的属性就是这里我们给进去的参数了
    Student("Apple", 18)
    // √√√ 2.3 使用Student类型的变量接收构造方法得到的对象
    var stuO: Student = Student("Orange", 21)
    // √√√ 2.4 有一个我们需要注意的点，这里的stu存放的是对象的引用，而不是本体，我们可以通过对象的引用来间接操作对象。
    val s1 = Student("Banana", 23)
    val s2 = s1
    println(s1 === s2) // //使用 === 可以判断两个变量引用的是不是同一个对象

    val s3 = Student("Apple", 18) //即使名字和年龄一样，但是由于这里重新创建了一次对象
    println(s3 === s1) //这里比较的就不是同一个对象了

    println("------对象的属性------")
    // √√√ 2.5 我们可以使用`.`运算符来访问对象的属性
    val s4 = Student2("Cherry", 22)
    println("对象的name=${s4.name}, age=${s4.age}")
    s4.name = "Coconut"
//    s4.age = 19 //由于age属性是val，所以说无法修改，只能读取
    println("对象修改后的name=${s4.name}, age=${s4.age}")

    println("------使用次要构造函数构造对象------")
    val s5 = Student4("Apricot")
    val s6 = Student5("Avocado")

    /*
    主构造函数相比次要（辅助）构造函数：

    * **主构造函数：** 可以直接在主构造函数中定义类属性，使用更方便，但是主构造函数只能存在一个，并且无法编写函数体，只有为类属性做初始化赋值的效果。
    * **辅助（次要）构造函数：** 可以存在多个，并且可以自定义函数体，但是无法像主构造函数那样定义类属性，并且当类具有主构造函数时，所有次要构造函数必须直接或间接地调用主构造函数。

    Kotlin语言本身比较灵活，类中并不是一定需要主构造函数，全部写辅助构造函数也是可以的，但是再怎么都得有构造函数。
     */

}