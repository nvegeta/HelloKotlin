package com.test

var a = 20

fun message() {
    println("I'm message method in Test.kt")
}

class User

/*
在类、对象、接口、构造函数和函数，以及属性上，可以为其添加 *可见性修饰符* 来控制其可见性，在Kotlin中有四个可见性修饰符，它们分别是：`private`、`protected`、`internal`和`public`，默认可见性是`public`，在使用顶级声明时，不同可见性的访问权限如下：

- 如果不使用可见性修饰符，则默认使用`public`，这意味着这里声明的内容将在任何地方可访问。
- 如果使用`private`修饰符，那么声明的内容只能在当前文件中可访问。
- 如果使用`internal`修饰符，它将在同一[模块](https://kotlinlang.org/docs/visibility-modifiers.html#modules)中可见（当前的项目中可以随意访问，与public没大差别，但是如果别人引用我们的项目，那么无法使用）
- 顶级声明不支持使用`protected`修饰符。
 */

private fun inner() {
    //我们不希望这个函数能够在其他地方被调用
}

/*
在类中定义成员属性时，不同可见性的访问权限如下：

- `private`意味着该成员仅在此类中可见（包括其所有成员）
- `protected`与`private`的可见性类似，外部无法使用，但在子类中可以使用（子类会在下一章中介绍）
- `internal`意味着本项目中任何地方都会看到其`internal`成员，但是别人引用我们项目时不行。
- `public`意味着任何地方都可以访问。
 */
class StudentM(
    private var name: String, //name属性无法被外部访问，因为是私有的
    internal var age: Int //age可以被外部访问，但是无法再其他项目中访问到
) {
    private constructor() : this("", 10)//这个无参构造无法被外部访问，因为是私有的
}