## 覚えておきたい用語
- 名前付き変数（named arguments）
    - 関数呼び出し時に引数名をしてしてあげる方法、好きな順番で呼び出せる
- Nothing型
    - 例外をthrow、もしくは呼び出し側に戻らない（e.g. Todo）
    ```
    public inline fun TODO(): Nothing = throw NotImplementedError()
    ```
    
    Game.ktのmain(), print()はいずれもファイルレベルで定義された関数
    Game.ktのバイトコードをJavaのデコンパイルすると```public final class Game```の```static final```変数と扱われていることがわかる
    
- 実は表現豊かなKotlinだよ
    - 関数名に逆引用符をつけることができる
    ```
    fun 'users should be signed out when they click logout'(){
        // Do test
    }
    ```
    テストの関数名にするとわかりやすい！
    
- 名前付き関数（named function）
    ```
    fun hoge(arg: String): Hoge {}
    ```
- 無名関数（anonymous function）：ラムダ（lambda）
    - 例えば、count()などは標準ライブラリの関数
    ドット構文で呼び出す（dot syntax）...メンバ関数（メソッド）、拡張関数で使える
    - count()に無名関数：ラムダを渡せる
    ```
    "hogehogefugapiyo".count(it == 'o')
    // 3
    ```
    - 無名関数は他の関数に渡しやすい
        - sample: SimVillage.kt
    - 無名関数は関数型（function type）
    - 値として無名関数を格納でき、コードの中で関数を渡せる
    - 標準ライブラリに無名関数は多く使われているので公式ドキュメントを読む
    
    
    