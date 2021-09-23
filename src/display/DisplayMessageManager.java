package display;

import res.DisplayStrings;
import util.PlayerUtil;

public class DisplayMessageManager {


    public void beginDoshGame() {
        System.out.println(DisplayStrings.GAME_START.getString());
    }

    public void showExplanation() {
        System.out.println(DisplayStrings.RULE_SUMMARY.getString());
        System.out.println("");
        System.out.println(DisplayStrings.RULE_DETAIL.getString());
        System.out.println("");
    }

    public void showInputNumOfPlayer() {
        System.out.println(DisplayStrings.ASK_NUMBER_OF_PLAYER.getString());
    }


    public void showDiceNumber(int diceNumber, int secondDiceNumber, int sumDiceNumber) {
        System.out.println(diceNumber + "と" + secondDiceNumber + "の目が出ました");
        System.out.println("合計" + sumDiceNumber + "です。");

    }

    public void pressEnter() {
    }

    public void showFirstAndLastLineOnBoard() {
        System.out.println(DisplayStrings.BOARD_TOP_AND_BOTTOM_LINE.getString());
    }


    public void showSecondLineOnBoard(String secondLine) {
        System.out.println(secondLine);
    }

    public void showThirdAndFiveLine() {
        System.out.println(DisplayStrings.BOARD_THIRD_LINE.getString());
    }

    public void showForthLineOnBoard(String forthLine) {
        System.out.println(forthLine);
    }

    public void showSixLine(String sixLine) {
        System.out.println(sixLine);
    }

    public void showLuckyDiceNumber(int diceSumNum) {
        System.out.println("おめでとうございます! " + diceSumNum + "が出ました。 総取りです");
    }

    public void showGameFinished(String playerName) {
        System.out.println(playerName + "の持ちチップス数が 0 以下になりました。このプレイヤーの敗北です。ゲームを終了します");
    }

    public void showTurnEnd(String playerName) {
        System.out.println(playerName + "のターンは終了しました");
    }

    public void showPlayersTip(String playerName, int tip) {
        System.out.println(playerName + " の持ちチップ数: " + tip);
    }

    public void showWinPlayerTip(String playerName, int tip) {
        System.out.println("総取りの結果、プレーヤーネーム" + playerName + " の持ちチップ数は, " + tip + "に増加しました");
    }

    public void showPlayerTurnStart(String playerName) {
        System.out.println(playerName + "のターン開始");
    }

    public void showLeaveSpaces() {
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    public void showGameRound(int gameRoundCounter) {
        System.out.println("<" + gameRoundCounter + "周目>");
    }

    public void showPlayerNumberCaution() {
        System.out.println(
                "プログラム実行時に追えなくなるため、プレーヤー人数は"
                        + PlayerUtil.minPlayerNumber
                        + "人以上、"
                        + PlayerUtil.maxPlayerNumber
                        + "人以下に設定してください。");
    }

    public void askCheating() {
        System.out.println("いかさましますか？ y or n");
    }

    public void explainCheatingOptions() {
        System.out.println("いかさまには3つオプションがあります。");
        System.out.println("1. ゾロ目(1,1)を出します");
        System.out.println("2. 7以下の目を出します");
        System.out.println("3. 7以上の目を出します");
    }

    public void showNotUsingCheat() {
        System.out.println("今回のターンではいかさまを使用しません");
    }

    public void askWhichCheatUse() {
        System.out.println("どのいかさまを使うか、対応する数字を入力してください");
    }

    public void confirmNotUseCheating() {
        System.out.println("今回はいかさまを使えませんでした。いかさまの説明を読んで、対応する番号 1 or 2 or 3 から数字を1つ選択して入力してください");
    }

    public void showCheatingZorome() {
        System.out.println("ゾロ目を出しました");
    }

    public void showCheatingLowerSeven() {
        System.out.println("7以下の目を出しました");
    }

    public void showCheatingUpperSeven() {
        System.out.println("7以上の目を出しました");
    }
}
