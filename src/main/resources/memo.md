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
- 無名関数（anonymous function）
    ```
    
    ```
    - 例えば、count()などは
    ドット構文で呼び出す（dot syntax）
    
    
    
    