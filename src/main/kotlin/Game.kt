/** == ：構造等価演算子（structural equality operator）< 比較演算子（comparison operator）
 * c.f.意味を間違いそうなやつ
 * == 左辺と右辺の値が等しい（ !=）
 * === 2つのインスタンスが同じ参照である（!==）
 *
 * + ：文字列結合（string concatenation）
 * */

fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 100

    if (healthPoints == 100) {
        println("$name is in excellent condition!!")
    } else {
        println("$name is in awful condition!")
    }
}