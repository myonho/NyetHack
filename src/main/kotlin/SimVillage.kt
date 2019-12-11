/**
    println({...}())
    × {} ○ {}()
    この丸括弧のおかげで関数になっている
    × count ○ count()
    {}だとブロックになっちゃう

    ()は引数が入ることもあるアレだけども、この場合は引数なし

fun main(args: Array<String>) {
    println({
        val currentYear = 2019
        "Welcome to SimVillage, Mayor!! (copyright $currentYear)"
    }())
}
 */
/**
    val greetingFunction(): -> String
    変数について、引数を受け取らないこと、Stringを返す関数を代入できることを宣言

    無名関数にreturnは必要ない（むしろ許さない）
 */
fun main(args: Array<String>) {
    runSimulation("Mayor") { playerName, numBuildings ->
        val currentYear = 2019
        "Adding $numBuildings houses," +
                "Welcome to SimVillage, $playerName!! (copyright $currentYear)"
    }
}

fun runSimulation(playerName: String, greetingFunction: (String, Int) -> String) {
    val numBuilding = (1..3).random()
    println(greetingFunction(playerName, numBuilding))
}
