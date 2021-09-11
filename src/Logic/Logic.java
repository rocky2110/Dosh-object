package Logic;

import display.DisplayMessageManager;
import player.Player;
import util.DoshConst;

import java.util.Random;
import java.util.Scanner;

public class Logic {
    private DisplayMessageManager displayMessageManager = new DisplayMessageManager();
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);

    public void execute() {
        // Dosh ゲーム要件。
        // ルールを説明する。
        displayMessageManager.showExplanation();

        // プレーヤーは 2人以上で、コンソールに数字を打ち込ませて人数を入力させるとゲームが開始する。
        int numOfPlayer = inputNumberOfPlayer();


        // プレーヤ1 がサイコロをふる。
        Player player = new Player("自分");
        int diceSumNum = throwTwoDice();
        if (diceSumNum == 2 || diceSumNum == 12) {
            // 2,12 の場合、ボートと牢獄のチップを総取りして、もう一度ダイスをふる。
//            player.additionTip();
            int secondDiceSumNum = throwTwoDice();
            if (secondDiceSumNum == 2 || secondDiceSumNum == 12) {
                // 2,12 の目以外の場合、ボードのでための数字の上に、出た目の枚数チップを置く。

                player.subtractionTip(secondDiceSumNum);
            } else {
                // 2,12 の目の場合、ボードの全ての数字の上に、数字の枚数チップを置く。現状 63 チップ置くことになる。

            }
        } else if (diceSumNum == 7) {
            // 7 の場合、ボート外に7枚チップをおく。ここを牢獄と呼ぶ。
            setTip();

        } else {
            // 2,7,12 以外の目の場合、ボート上にある出た目と同じ数字の上に、でための枚数のチップを置く。
            setTip();

            // プレーヤーの持ちチップ数は、出た目の数だけ減少する
            player.subtractionTip(diceSumNum);

        }

        // プレーヤーの持ちチップが 0 枚以下になったらゲーム終了
        if (player.getTip() <= 0) {
            gameFinished();
        }
        // エンターを押すと、プレーヤー2 が同じ動作をする。
        pressEnter();


        // 名刺を抽出する
        // Dosh, ルール、プレーヤー、開始、プレーヤー1,サイコロ、ボード、チップ、牢獄

        // パッケージ決定
        // プロジェクト: Dosh
        // ロジック: 開始、終了
        // その他クラス : player(プレイヤー), board(ボードを作成), DisplayMessage(CUI テキスト表示)

        // 動詞をメソッドにする
        // ルールを説明する showExplanation() --> DisplayMessage
        // コンソールに数字を打ち込ませて人数を決める inputNumberOfPlayer() --> ロジック
        // サイコロをふる throwDice() --> ロジック
        // チップを置く setTip() --> ロジック
        // ゲーム終了 gameFinished() --> ロジック
        // エンターを押す
    }

    private int inputNumberOfPlayer() {
        displayMessageManager.showInputNumOfPlayer();
        int numOfPlayer = scanner.nextInt();
        return numOfPlayer;
    }

    private int throwTwoDice() {
        int firstDiceNumber = rand.nextInt(DoshConst.Dice_eye_max) + 1;
        int secondDiceNumber = rand.nextInt(DoshConst.Dice_eye_max) + 1;
        int sumDiceNumber = firstDiceNumber + secondDiceNumber;
        displayMessageManager.showDiceNumber(firstDiceNumber, secondDiceNumber, sumDiceNumber);
        return sumDiceNumber;
    }

    private void setTip() {
    }

    private void gameFinished() {
    }

    private void pressEnter() {
        displayMessageManager.pressEnter();
        scanner.nextLine();
    }
}