import java.io.File


fun main(args: Array<String>) {
    val list = File(args[1]).readLines().toMutableSet()
    val searchEngine = SearchEngine(list)

    var n: Int
    do {
        println("=== Menu ====")
        println("1. Find a person")
        println("2. Print all persona")
        println("0. Exit")
        n = readLine()!!.toInt()
        when (n) {
            1 -> {
                println("Select a matching strategy: ALL, ANY, NONE")
                val strategy = SearchStrategry.valueOf(readLine()!!)
                println("Enter a name or email to search all matching people.")
                val query = readLine()!!
                val result = searchEngine.search(query, strategy)
                println("Found ${result.size} persons:")
                for (person in result) {
                    println(person)
                }
            }
            2 -> list.forEach { println(it.toString())}
            0 -> println("Bye")
        }

    } while (n != 0)

}
enum class SearchStrategry {
    ALL, ANY, NONE
}
class SearchEngine(private val index: Set<String>) {
    fun search(query: String, strategry: SearchStrategry): Set<String> =
        when (strategry) {
            SearchStrategry.ALL -> this.findAll(query)
            SearchStrategry.ANY -> this.findAny(query)
            SearchStrategry.NONE -> this.findNone(query)
        }
    private fun findAll(query: String): Set<String> =
        this.filterIndex {
            words(query).all { word ->
                it.contains(word, true)
            }
        }
    private fun findAny(query: String): Set<String> =
        this.filterIndex {
            containsAny(it, query)
        }
    private fun findNone(query: String): Set<String> =
        this.filterIndex {
            !containsAny(it, query)
        }
    private fun words(text: String) =
        text.split(" ").toSet()

    private inline fun filterIndex(predicate: (String) -> Boolean): Set<String> =
        index.filter(predicate).toSet()

    private fun containsAny(text: String, words: String) =
        words(words).any {
            text.contains(it, true)
        }
}



