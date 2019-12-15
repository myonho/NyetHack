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
    
### その他の豆知識
- スマートキャスト
    - コンパイラがif式の中の条件を追跡してくれる
    ```
    if (hoge != null) { println(hoge.capitalize()) } else { println("hoge is null")}
    ```
    hogeがnullでない前提で`capitalize()`を呼び出せる