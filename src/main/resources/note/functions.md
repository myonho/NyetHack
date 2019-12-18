### 標準関数
ラムダで指定された処理を実行する代表的な関数をメモ
#### apply
設定用の関数：ラムダを実行したらレシーバ（型のインスタンス）を返す

applyなし
```
val menuFile = File("menu-file.txt")
menuFile.setReadable(true)
menuFile.setWritable(true)
menuFile.setExecutable(true)
```
applyあり
```
val menuFile = File("menu-file.txt").apply {
    setReadable(true)
    setWritable(true)
    setExecutable(true)
}
```
同じレシーバを設定するために実行する全部の関数コールから、そのレシーバの変数名を省略できる（this）<br>
-> applyは自分が呼び出されたレシーバをラムダの中の関数コールのスコープにする（相対スコープ/ relative scope/ implicitly called）
    
#### let
変数を自分に渡されたラムダのスコープにする
letなし
```
val num = (1..100).random()
val numSquared = num * num
```
letあり
```
val num = (1..100).random().let { it * it }
```
null + letでおなじみ
->letはレシーバをラムダに渡す（applyは渡さない）
->letはラムダの結果を返すがapplyはレシーバを返す

#### run
レシーバを返さずにラムダの結果を返す
ここではbooleanを返す（c.f. apply）

```
val menuFileContainsHoge = File("menu-file.txt").run {
    readText().contains("Hoge") 
}
```
レシーバに対して関数リファレンスを使うこともできる
```
fun nameIsLong(name: String) = name.length >= 20
"Madrigal".run(::nameIsLong) // false
```
関数をネストするより見やすくなることもある

#### with
runと振る舞いは同じだが、引数を第一パラメータとして受け取る
```
val nameIsLong = with("hogehogefugafugapiyopiyo") {
    length >= 20
}
```
#### also
letと同じくレシーバをラムダに渡すが、ラムダの結果でなくレシーバを返す
```
var fileContents: List<String>
File("file.txt").also {
    fileContents = it.readLine()
}
```
#### takeIf
条件を定義するラムダ式（断言：predicate）を評価する<br>
条件が真ならレシーバを、偽ならnullを返す
```
val fileContents = File("myfile.txt").takeIf {
    it.canRead() && it.canWrite()
}?.readText()
```
ifと異なりインスタンスに対して直接呼び出せるので、一時的変数への代入が不要になることがある<br>
<->takeUnless：条件が偽のときに元の値を返すがあまり使わない方がいい（パッとわかりにくい）

#### 参考
[たろうさんによるチートシート](https://qiita.com/ngsw_taro/items/d29e3080d9fc8a38691e)

