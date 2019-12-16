const val TAVERN_NAME = "Taernyl's Folly"
// String
fun main(args: Array<String>) {
    placeOrder("shandy,Dragon's Breath,5.91")
}

private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.".toUpperCase())

    val (type, name, price) = menuData.split(',')
    println("Madrigal buys a $name ($type) for $price")

    val phrase = "Ah, delicious $name！"
    println("Madrigal exclaims: ${toDragonSpeak(phrase)}")
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiou]")) {
        when (it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
}

// null let
//fun main(args: Array<String>) {
//    var beverage = readLine()?.let{
//        if (it.isNotBlank()) {
//            it.capitalize()
//        } else {
//            "Buttered Ale"
//        }
//    }
////    beverage = null
//    println(beverage)
//}
