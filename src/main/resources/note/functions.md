### 標準関数
ラムダで指定された処理を実行する代表的な関数をメモ
#### apply
- 設定用の関数：ラムダを実行したらレシーバ（型のインスタンス）を返す
    
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
- 変数を自分に渡されたラムダのスコープにする
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
- レシーバを返さない
    