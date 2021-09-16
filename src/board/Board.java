package board;

import display.DisplayMessageManager;

import java.util.HashMap;
import java.util.Map;

import static util.DoshConst.*;

public class Board {
    private DisplayMessageManager displayMessageManager;
    // Map を使って、どのますにチップが置かれているかを管理する方針でとりあえず進めてみる
    private Map<Integer, Boolean> isSetTip = new HashMap<>();
    public final int Int_IF_ALL_TIP_Set_ON_BOARD;


    // map の初期状態では、チップが置かれていないので全て false
    {
        BoardStateInitialized();
        Int_IF_ALL_TIP_Set_ON_BOARD = getNumberOfAllTipOnBoard();
    }


    public Board(DisplayMessageManager displayMessageManager) {
        this.displayMessageManager = displayMessageManager;
    }


    // ボードの出力担当
    public void showBoard() {
        // 最初の列を出力する
        displayMessageManager.showFirstAndLastLineOnBoard();
        // 2列目を作る
        String secondLine = createSecondLineOnBoard();
        displayMessageManager.showSecondLineOnBoard(secondLine);

        // 3列目を表示する
        displayMessageManager.showThirdAndFiveLine();

        // 4列目を作る
        String forthLine = createForthLineOnBoard();
        displayMessageManager.showForthLineOnBoard(forthLine);

        // 5列目を表示する
        displayMessageManager.showThirdAndFiveLine();

        // 6列目を表示する
        String sixLine = createSixLineOnBoard();
        displayMessageManager.showSixLine(sixLine);

        // 最後の列を出力する
        displayMessageManager.showFirstAndLastLineOnBoard();
    }


    // ロジックから呼ぶ。ボードにチップをセットする。(== ボード上の数字を入れ替える事ができる)こと。ここが難しそう。。どうやって、置き換えを表現するか。。
    public void setTipOnBoard(int diceSumNumber) {
        // map の key: diceSumNumber の value を true に変更する。
        isSetTip.put(diceSumNumber, true);
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
        // Map のなかで value が true になっている key を全て足す。
        int allTipOnBoard = 0;
        for (Map.Entry<Integer, Boolean> entry : isSetTip.entrySet()) {
            if (entry.getValue()) {
                allTipOnBoard += entry.getKey();
            }
        }
        // ボードの状態を初期化する
        BoardStateInitialized();
        return allTipOnBoard;
    }


    // ボード上の数字の上にチップが載っているかどうか確認できる。ロジックからこのメソッドを呼んで、Map に検索をかけて結果を取得する。
    public Boolean canFetchTip(int diceSumNumber) {
        return isSetTip.get(diceSumNumber);
    }

    // ボード上の全てのますの上にチップを載せる
    public void setAllTipOnBoard() {
        setFullTipOnBoard();
    }



    // map の key の値を全て合計して返却する
    private int getNumberOfAllTipOnBoard () {
        int allTipOnBoard = 0;
        for (Map.Entry<Integer, Boolean> entry : isSetTip.entrySet()) {
            if (!entry.getValue()) {
                allTipOnBoard += entry.getKey();
            }
        }
        return allTipOnBoard;
    }

    private void BoardStateInitialized() {
        isSetTip.put(Board_3, false);
        isSetTip.put(Board_4, false);
        isSetTip.put(Board_5, false);
        isSetTip.put(Board_6, false);
        isSetTip.put(Board_7, false);
        isSetTip.put(Board_8, false);
        isSetTip.put(Board_9, false);
        isSetTip.put(Board_10, false);
        isSetTip.put(Board_11, false);
    }

    private void setFullTipOnBoard() {
        isSetTip.put(Board_3, true);
        isSetTip.put(Board_4, true);
        isSetTip.put(Board_5, true);
        isSetTip.put(Board_6, true);
        isSetTip.put(Board_7, true);
        isSetTip.put(Board_8, true);
        isSetTip.put(Board_9, true);
        isSetTip.put(Board_10, true);
        isSetTip.put(Board_11, true);
    }


    private String createSecondLineOnBoard() {
        String threeOnBoardState = getThreeState();
        String fourOnBoardState = getFourState();
        String fiveOnBoardState = getFiveState();
        String secondLine = "|  " + threeOnBoardState + "  |  " + fourOnBoardState + "  |  " + fiveOnBoardState + "  |  |     |";
        return secondLine;
    }

    private String getThreeState() {
        boolean isSetThree = isSetTip.get(Board_3);
        if (isSetThree) {
            return setThreeTip;
        } else {
            return notSetThreeTip;
        }
    }

    private String getFourState() {
        boolean isSetFour = isSetTip.get(Board_4);
        if (isSetFour) {
            return setFourTip;
        } else {
            return notSetFourTip;
        }
    }

    private String getFiveState() {
        boolean isSetFive = isSetTip.get(Board_5);
        if (isSetFive) {
            return setFiveTip;
        } else {
            return notSetFiveTip;
        }
    }


    private String createForthLineOnBoard() {
        String sixOnBoardState = getSixState();
        String eightOnBoardState = getEightState();
        String sevenOnBoardState = getSevenState();
        String secondLine = "|  " + sixOnBoardState + "  |     |  " + eightOnBoardState + "  |  |  " +  sevenOnBoardState + "  |";
        return secondLine;
    }

    private String getSixState() {
        boolean isSetSix = isSetTip.get(Board_6);
        if (isSetSix) {
            return setSixTip;
        } else {
            return notSetSixTip;
        }
    }

    private String getSevenState() {
        boolean isSetSeven = isSetTip.get(Board_7);
        if (isSetSeven) {
            return setSevenTip;
        } else {
            return notSetSevenTip;
        }
    }

    private String getEightState() {
        boolean isSetEight = isSetTip.get(Board_8);
        if (isSetEight) {
            return setEightTip;
        } else {
            return notSetEightTip;
        }
    }




    private String createSixLineOnBoard() {
        String nineOnBoardState = getNineState();
        String tenOnBoardState = getTenState();
        String elevenOnBoardState = getElevenState();
        String sixLine = "|  " + nineOnBoardState + "  |  " + tenOnBoardState + " |  " + elevenOnBoardState + " |  |     |";
        return sixLine;
    }

    private String getNineState() {
        boolean isSetNine = isSetTip.get(Board_9);
        if (isSetNine) {
            return setNineTip;
        } else {
            return notSetNineTip;
        }
    }

    private String getTenState() {
        boolean isSetTen = isSetTip.get(Board_10);
        if (isSetTen) {
            return setTenTip;
        } else {
            return notSetTenTip;
        }
    }

    private String getElevenState() {
        boolean isSetSeven = isSetTip.get(Board_11);
        if (isSetSeven) {
            return setElevenTip;
        } else {
            return notSetElevenTip;
        }
    }
}
