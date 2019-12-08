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