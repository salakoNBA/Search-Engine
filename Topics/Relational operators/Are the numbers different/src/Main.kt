fun main() {
    // put your code here
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()

    if (a != b && a != c && b != c) {
        println(true)
    } else {
        println(false)
    }
}