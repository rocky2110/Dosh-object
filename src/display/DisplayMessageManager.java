package display;

import res.DisplayStrings;

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
}
