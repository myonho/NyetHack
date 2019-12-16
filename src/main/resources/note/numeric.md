### 数値型
ほとんど豆知識、基本的にはIntかLong
Byte->Short->Int->Longで8->16->32->64
一番左が符号に使われるので残りの2の塁乗を足せば最小/最大値がわかる
- Byte
    - ファイルからデータストリームを読み込むとき、グラフィックスを処理するときに使われる（カラー画面のピクセルはRGBによる3byteが多い）
- Short
    - 32ビット命令をサポートしないCPUのネイティブコードとのやりとりに使うことがある
- 数値変換の安全策
    - `toxxOrNull`と組み合わせて使う
    ```
    val gold: Int = "5.91".toIntOrNull ?: 0
    ```
- Float, Double（Doubleの精度はfloatの倍）
    - 浮動小数点（floating point）は小数点をどこにでも置け（位置が浮動する）、その値は近似値（approximation）をとる
    - 精度の損失：Float,DoubleをIntに変換したとき丸め込まれてしまう値がある

### 豆知識
- モジュロ演算子（modulus operator）
    - `%`のこと...
     
     
