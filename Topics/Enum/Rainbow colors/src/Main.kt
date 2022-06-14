enum class Rainbow(val color: String) {
    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue"),
    INDIGO("Indigo"),
    VIOLET("Violet")
}
fun main() {
    val colorName = readln()
    fun isRainbow(color: String) : Boolean {
        for (enum in Rainbow.values()) {
            if (colorName.toUpperCase() == enum.name) return true
        }
        return false
    }
    println(isRainbow(colorName))
}

