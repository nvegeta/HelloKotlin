package encapInherPolymor

/**
 * 顶层Any类
 * 在我们不继承任何类的情况下，实际上Kotlin会有一个默认的父类，所有的类默认情况下都是继承自Any类的
 * 到目前为止，我们认识了Kotlin中两种相等的判断方式：
 *
 * * *结果上* 相等 (`==` 等价于 `equals()`)
 * * *引用上* 相等 (`===` 判断两个变量是否都是引用的同一个对象)
 *
 * 默认情况下，如果我们不重写类的`equals`函数，那么会直接对等号两边的变量进行引用判断`===`判断是否为同一个对象。
 */
class TlcA(val p1: String, val p2: Int) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true //如果引用的是同一个对象，肯定是true
        if (other !is TlcA) return false //如果要判断的对象根本不是同一类型的，那也不用继续了
        if (p1 != other.p1) return false //判断成员变量1是否相同
        if (p2 != other.p2) return false //判断成员变量2是否相同
        return true //都没问题，那就是相等了
    }

    /**
     * 实际上在我们重写类的`equals`函数时，根据约定，必须重写对于的hashCode函数
     */
    override fun hashCode(): Int {
        var result = p2
        result = 31 * result + p1.hashCode()
        return result
    }

    override fun toString(): String { //直接重写toString函数, 不重写 打印的结果是对象的`类型@十六进制哈希值`
        return "TlcA(p1='$p1', p2='$p2')"
    }
}

fun main() {
    val tlc1 = TlcA("A", 1)
    val tlc2 = TlcA("B", 2)
    val tlc3 = TlcA("A", 1)
    println(tlc1 == tlc1) //返回true因为就是自己
    println(tlc1 == tlc2)//返回false因为成员变量的值不一样
    println(tlc1 == tlc3) //返回true因为成员变量的值完全一样
    println(tlc2)
}