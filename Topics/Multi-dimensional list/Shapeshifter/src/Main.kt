fun main() {
    //Do not touch code below
    val inputList: MutableList<MutableList<String>> = mutableListOf()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val strings = readLine()!!.split(' ').toMutableList()
        inputList.add(strings)
    }
    // write your code here
    val a = mutableListOf(inputList.last())
    val b = mutableListOf(inputList.first())
    val c = mutableListOf(
        mutableListOf(a), mutableListOf(b)
    )
    println(c)

}