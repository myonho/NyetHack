### nullability
- null
    - varまたはvalに値が存在しないことを表す
    - default not null（nullをそもそも許容しないことでクラッシュを防ぐ）
    c.f. Javaだと
    ```
    String hoge = "hoge"
    hoge = null 
    ```
    上記は許されるが以下のような使い方をすると`NullPointerException`を投げる
    ```
    System.out.println(hoge + "is hoge, and hoge")
    ```
- エラーの種類
    - コンパイルエラー：コンパイル時（プログラムを機械語へ翻訳するとき）に検出されるエラー
    - 実行時エラー：コンパイルで検出されなかったけど実行してたら出てきたエラー（e.g. ぬるぽ）
- セーフコールとlet
    - セーフコール演算子（`?.` : safe call operator）
        - コンパイラはnullを見つけたら呼び出しをスキップする
        - letが呼び出された場合はletに渡されたラムダ内の全てが評価される（ラムダはクロージャ...letの場合、itが呼び出した変数へのリファレンスになる）
        - letはラムダの評価を変数に代入できる（暗黙）
- null破壊（非null表明演算子：non-null assertion operator/ double-bang operator）
    - `!!`でセーフ機能を破壊する
- エルヴィス演算子（`?:`： null合体演算子：null coalescing operator）
    - 左辺がnullなら右辺を実行する
    
### Exception
未処理例外でプログラムの実行は止まる（クラッシュする）のでthrowing(`throw`キーワードを使った例外の送出)で防ぐ
<br>例外が表現するのは対処しなければ復旧できない状態なので`try/catch`で対応する（システムを止めない）
- よく使う例外
    - IllegalStateException（違反状態例外）
        - あらかじめ違反と決めていた状態に達したという意味、ログを出力したりすると便利
- カスタム例外
    - 何かしらの例外を継承したクラスを作る
- 事前条件関数（precondition functions）：`Precondition.kt`参照
    - `checkNotNull(value: T?, lazyMessage: () -> Any)`：valueがnullならIllegalStateException
    - `require(value: Boolean, lazyMessage: () -> Any)`：valueがfalseならIllegalArgumentException
    - `requireNotNull(value: T?)`：valueがnullならIllegalArgumentException、でなければ値
    - `error(message: Any)`：nullならmessage付きIllegalArgumentException、でなければ値
    - `assert(value: Boolean)`：valueがfalseでassertionコンパイラフラグが立っていればAssertionError
        - c.f.[kotlin/assert](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/assert.html)

### その他の豆知識
- スマートキャスト
    - コンパイラがif式の中の条件を追跡してくれる
    ```
    if (hoge != null) { println(hoge.capitalize()) } else { println("hoge is null")}
    ```
    hogeがnullでない前提で`capitalize()`を呼び出せる
- そもそもnullって要るの
    - Javaや同類言語では初期値にnullを使うことが多い
    - Kotlinを使うときは、nullセーフやlet、エルヴィス演算子を使ってスッキリ書きつつ実行時エラーを潰そうな...
- チェック例外、チェックされない例外
    - Kotlinの例外は全てunchecked exception
    - チェック例外はコンパイラが検出するエラーだが無視されるように書くことが多い（例外の飲み込み：swallowing）
    - チェック例外に付随する問題の方が多いから不採用...
- null許容の仕組み
    - 逆コンパイルしてJavaのコードを見ると`@NotNull`でマークされている
    - `Intrinsics.checkParameterIsNotNull()`でさらに保護されている
    