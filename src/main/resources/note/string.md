### 文字列操作
- substring
    ```
    public fun String.substring(range: IntRange): String = substring(range.start, range.endInclusive + 1)
    ```
- split
    ```
    public fun CharSequence.split(vararg delimiters: Char, ignoreCase: Boolean = false, limit: Int = 0): List<String>
    ```
    分解（destructuring）もサポートしている（`List`,`Map`,`pair`で使える）
    ```
    val (type, name, price) = menuData.split(',')
    ```
- replace
    - 引数から新しい文字列を作成する；Kotlinの文字列の特性が原因
        - var/val どちらで定義しても文字列はimmutableになる（Javaも同じ）
        - varの値も置換しているように見えて裏側で別インスタンスを生成している
- 等値性
    - 構造の等値性（文字と順序の一致）...`==`
    - 参照の等値性（同一インスタンス）...`===`
- Unicode
    - 文字列は文字（Char型）のシーケンス、Charは[Unicode文字](https://unicode.org)
    - `\u`はUnicode文字のエスケープシーケンス
    

### 豆知識
- `index[x]`の`x`の正式名称はインデックスアクセス演算子（indexed access operator）
- Javaでの等値性
    - 構造...`equals`
    - 参照...`==`