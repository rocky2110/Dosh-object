package display;

import res.DisplayStrings;

public class DisplayMessageManager {

    public void showExplanation() {
        System.out.println(DisplayStrings.RULE_SUMMARY.getString());
        System.out.println("");
        System.out.println(DisplayStrings.RULE_DETAIL.getString());
        System.out.println("");
    }

    public void showInputNumOfPlayer() {
        System.out.println(DisplayStrings.ASK_NUMBER_OF_PLAYER.getString());
    }


    public void showDiceNumber(int diceNumber, int secondDiceNumber, int firstDiceNumber) {
    }

    public void pressEnter() {
    }
}
