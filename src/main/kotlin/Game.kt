/** == ：構造等価演算子（structural equality operator）< 比較演算子（comparison operator）
 * c.f.意味を間違いそうなやつ
 * == 左辺と右辺の値が等しい（ !=）
 * === 2つのインスタンスが同じ参照である（!==）
 *
 * + ：文字列結合（string concatenation）
 *
 * && || ! ：論理演算子（logical operators）
 * && ：論理積演算子（logical 'and' operator）左辺*右辺...どちらも真で真
 * || ：論理和演算子（logical 'or' operator）左辺+右辺...どちらかが真で真
 *
 * private fun hoge(fuga: String): String {
 *  ...
 *  return piyo
 * }
 *
 * private...visibility modifier...option どの範囲から関数を使えるか？ default: public
 *
 * const -> ファイルレベルの変数（コンパイル時変数）...関数やクラスのローカルではないから
 * プロジェクトのどこからでも参照できる変数になる
 * */

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 100

    val healthStatus = when (healthPoints) {
        100 -> " is in excellent condition!!"
        in 90..99 -> " has a few scratches"
        in 75..89 -> " has some mirror wounds"
        in 15..74 -> " look pretty hurt"
        else -> " is in awful condition!"
    }
    println(name + healthStatus)
}
// Kotlinのちょっとしたコード試すのにKotlin REPLが便利
// 1 in 1..3
//res0: kotlin.Boolean = true
//
//1 in 3 downTo 1
//res1: kotlin.Boolean = true
//
//(1..3).toList()
//res2: kotlin.collections.List<kotlin.Int> = [1, 2, 3]
//
//1 in 1 until 3
//res3: kotlin.Boolean = true
//
//3 in 1 until 3
//res4: kotlin.Boolean = false
//
//2 in 1..3
//res5: kotlin.Boolean = true
//
//2 !in 1..3
//res6: kotlin.Boolean = false
//
//'x' in 'a'..'z'
//res7: kotlin.Boolean = true
