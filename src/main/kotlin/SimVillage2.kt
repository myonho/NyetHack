
fun main(args: Array<String>) {
    runSimulation()
}

fun runSimulation() {
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("Guyal"))
    /**
     * runBuildingsは無名関数の外側で定義されているが無名関数はアクセスして変更できる（myonhoでは7にインクリメントされる）
     * */
    println(greetingFunction("Myonho"))
}

/**
 * 必要な変数をもらってラムダを組み立てたらラムダを呼び出し側に返す
 *
 * ローカル変数 structureType と numBuildingsを使っているのはラムダの中...
 * ラムダがクロージャだから可能...定義の外側のスコープにある変数を閉じ込めて存続させられる
 * */

fun configureGreetingFunction(): (String) -> String {
    val structureType = "hospitals"
    var numBuildings = 5
    return { playerName: String ->
        val currentYear = 2018
        numBuildings += 1
        println("Adding $numBuildings $structureType")
        "Welcome to SimVillage, $playerName!! (copyright $currentYear)"
    }
}