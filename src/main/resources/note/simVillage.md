## 覚えておきたい用語
### 名前付き変数（named arguments）
関数呼び出し時に引数名をしてしてあげる方法、好きな順番で呼び出せる
### Nothing型
例外をthrow、もしくは呼び出し側に戻らない（e.g. Todo）
```
public inline fun TODO(): Nothing = throw NotImplementedError()
```

Game.ktのmain(), print()はいずれもファイルレベルで定義された関数
Game.ktのバイトコードをJavaのデコンパイルすると```public final class Game```の```static final```変数と扱われていることがわかる
    
### 実は表現豊かなKotlinだよ
関数名に逆引用符をつけることができる
```
fun 'users should be signed out when they click logout'(){
    // Do test
}
```
テストの関数名にするとわかりやすい！
    
### 名前付き関数（named function）
```
fun hoge(arg: String): Hoge {}
```
### 無名関数（anonymous function）：ラムダ（lambda）
例えば、count()などは標準ライブラリの関数<br>
ドット構文で呼び出す（dot syntax）...メンバ関数（メソッド）、拡張関数で使える<br>
count()に無名関数：ラムダを渡せる
```
"hogehogefugapiyo".count(it == 'o')
// 3
```
無名関数は他の関数に渡しやすい（sample: SimVillage.kt）<br>
無名関数は関数型（function type）<br>
値として無名関数を格納でき、コードの中で関数を渡せる<br>
標準ライブラリに無名関数は多く使われているので公式ドキュメントを読む<br>
ラムダ、簡潔に書くには
```
"hogehogefugapiyo".count it == 'o'
```
ラムダが最後の引数の時だけカッコを省略できる（参照：SimVillage.kt）
### inline 関数
ラムダはJVM上で1つのオブジェクトインスタンスとして表現される<br>
ラムダを利用できる全ての変数にメモリ割り当てを実行するのでコストがかかる<br>
ラムダを受け取る関数にinlineキーワードをつけると、ラムダのオブジェクトインスタンスで対象の関数を呼び出す代わりに呼び出しを行う場所自体に関数本体をコピペしてくれる<br>
ラムダを受け取るのが再帰関数の場合はinline化できない<br>

### 関数リファレンス（function reference）
名前付き関数を引数として渡せる形に変換してくれる<br>
```
::hoge
```
で関数hoge()のリファレンスを呼び出せる
    
### 高階関数（higher-order function）
他の関数を受け取るか、返す関数（sample: SimVillage2）<br>
関数型プログラミング（functional programming）-> 広範囲で高階関数使っていくスタイル<br>

### ラムダはクロージャ
無名関数を作成したスコープで定義された変数へのリファレンスをもつ（SimVillage2）

### ラムダ vs 無名内部クラス（anonymous inner class）
Java8だとオブジェクト指向プログラミングとラムダ式がサポートされているが、関数を関数のパラメータor変数として定義する能力がないが、無名内部クラスがある<br>
他のクラスの内部で定義される名前のないクラス（匿名クラス）<br>
1つのメソッド定義を実装する<br>
```
Greeting greeting = (playerName, numBuildings) -> {
    int currentYear = 2018;
    System.out.println("Adding" + numBuildings + "house");
    return "Welcome to SimVillage, " + playerName + "! (copyright " + currentYear + ")";
};
public interface Greeting {
    String greet(String playerName, int numBuildings);
}
greeting.greet("Guyal", 6)
```
Java8だとラムダが定義する関数を表現するのに、interfaceまたはclassの名前付き定義が必要<br>
interface定義なしで単純に関数を渡すことはできない<br>
#### Javaのコード
```
public interface Runnable {
    public abstract void run();
}
```
#### Kotlinのコード
```
fun runMyRunnable(runnable: () -> Unit) = { runnable() }
runMyRunnable{ println("hey now") }
```
暗黙のreturn、itキーワード、クロージャと組み合わせるとかなりシンプルに記述できる<br>
関数が[first-class citizen](https://en.wikipedia.org/wiki/First-class_citizen)に加えられている
