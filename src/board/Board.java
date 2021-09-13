package board;

import display.DisplayMessageManager;

import java.util.HashMap;
import java.util.Map;

public class Board {
    private DisplayMessageManager displayMessageManager;
    // Map を使って、どのますにチップが置かれているかを管理する方針でとりあえず進めてみる
    private Map<Integer, Boolean> isSetTip = new HashMap<>();

    // 以下の様にして、数字と丸の囲まれた数字を切り替えてボード上に表示できるのか試してみよう
    private final String notSetThreeTip = "3";
    private final String setThreeTip = "③";

    // map の初期状態では、チップが置かれていないので全て false
    {
        isSetTip.put(3, false);
        isSetTip.put(4, false);
        isSetTip.put(5, false);
        isSetTip.put(6, false);
        isSetTip.put(7, false);
        isSetTip.put(8, false);
        isSetTip.put(9, false);
        isSetTip.put(10, false);
        isSetTip.put(11, false);
    }


    public Board(DisplayMessageManager displayMessageManager) {
        this.displayMessageManager = displayMessageManager;
    }

    // ボードの役割
    // ボードを出力すること。ここで、どのようにボードを表現するか。。
    public void showBoard() {
        displayMessageManager.showInitializeBoard();
    }


    // ロジックから呼ぶ。ボードにチップをセットする。(== ボード上の数字を入れ替える事ができる)こと。ここが難しそう。。どうやって、置き換えを表現するか。。
    public void setTipOnBoard(int diceSumNumber) {
    }

    // ロジックから呼ぶ。ボードからチップをゲット or セットする
    public int getOrSetTipOnBoard(int diceSumNumber) {
        if (canFetchTip(diceSumNumber)) {
            // true なら、チップがすでに置いてあって取る事が可能なので、map の状態を false に書き換えてdiceSumNumber を返却する
            isSetTip.put(diceSumNumber, false);
            return diceSumNumber;
        } else {
            // false なら、チップが置かれていないので、map の状態を true に書き換えて -1 * diceSumNumber を返却する
            isSetTip.put(diceSumNumber, true);
            return -1 * diceSumNumber;
        }
    }

    public int getAllTipOnBoard() {
        // ボードの状態を初期化する
        InitializeBoard();
        // map を検索かけて、true になっているマス目(== map の key)を全て足し合わせて返却する
        return 0;
    }


    // ボードの状態を初期化できること(== 総取りが起こった時、map の value を全て false に変更する)
    public void InitializeBoard() {
    }

    // ボード上の数字の上にチップが載っているかどうか確認できる。ロジックからこのメソッドを呼んで、Map に検索をかけて結果を取得する。
    public Boolean canFetchTip(int diceSumNumber) {
        return isSetTip.get(diceSumNumber);
    }

    // ボード上の全てのますの上にチップを載せる
    public void setAllTipOnBoard() {

    }

    // map の key の値を全て合計して返却する
    public int getNumberOfAllTipOnBoard () {
        return 0;
    }
}
