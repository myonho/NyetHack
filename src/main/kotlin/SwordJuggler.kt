import java.lang.Exception

fun main(args: Array<String>) {
    var swordsJuggling: Int? = null
    if ((1..3).random() == 3) { swordsJuggling = 2 }

    try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling!!.plus(1)
    } catch (ex: Exception) {
        println(ex)
    }

    println("You juggle $swordsJuggling swords!")
}

fun proficiencyCheck(swordsJuggling: Int?) {
//    swordsJuggling ?: throw UnSkilledSwordJugglerException()
    checkNotNull(swordsJuggling, { "Player cannot juggle swords!" })
}

//class UnSkilledSwordJugglerException() : IllegalStateException("Player cannot juggle swords!")