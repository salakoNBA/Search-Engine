fun main() {
    // put your code here
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()

    if (a >= 1 && b <= 0 && c <= 0) {
        println("true")
    } else if(b >= 1 && a <= 0 && c <= 0) {
        println("true")
    } else if (c >= 1 && b <= 0 && a <= 0) {
        println("true")
    } else {
        println("false")
    }
}