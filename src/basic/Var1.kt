package basic

fun main() {
    // var [name]: [type] = [value]
    val count: UInt = 10u // 'val' cannot be reassigned.  U -> unassigned

    var count1: Int
    count1 = 20

    var count2 = 30
    count2 = count1 * count2

    println(count)
    println(count1)
    println(count2)
    println(count1 + count2)

}