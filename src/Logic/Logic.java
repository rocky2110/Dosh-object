package Logic;

import board.Board;
import display.DisplayMessageManager;
import player.Player;
import util.DoshConst;
import util.PlayerUtil;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static util.DoshConst.*;

public class Logic {
    private DisplayMessageManager displayMessageManager = new DisplayMessageManager();
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    private ArrayList<Player> players = new ArrayList();
    private int gameRoundCounter = 1;

    public void execute() {
        displayMessageManager.showExplanation();
        displayMessageManager.beginDoshGame();
        Board board = new Board(displayMessageManager);
        board.showBoard();

        int numOfPlayer = inputNumberOfPlayer();

        for (int i = 0; i < numOfPlayer; i++) {
            String playerName = "";
            if (i == 0) {
                playerName = "自分";
            } else {
                playerName = "プレイヤー" + (i);
            }
            Player player = new Player(playerName);
            players.add(player);
        }
        boolean gameContinued = true;
        while (gameContinued) {
            displayMessageManager.showGameRound(gameRoundCounter);
            for (Player player : players) {
                displayMessageManager.showPlayerTurnStart(player.getPlayerName());
                int diceSumNum;
                if (player.getPlayerName().equals("自分")) {
                    if (cheating()) {
                        displayMessageManager.explainCheatingOptions();
                        switch (getCheatingOptionNumber()) {
                            case cheatingOption1:
                                displayMessageManager.showCheatingZorome();
                                diceSumNum = cheatingOption1DiceNum;
                                break;
                            case cheatingOption2:
                                displayMessageManager.showCheatingLowerSeven();
                                diceSumNum = getDiceNumLowerSeven();
                                break;

                            case cheatingOption3:
                                displayMessageManager.showCheatingUpperSeven();
                                diceSumNum = getDiceNumUpperSeven();
                                break;

                                // todo テストだお
                            case 7:
                                diceSumNum = 7;
                                break;
                            default:
                                displayMessageManager.confirmNotUseCheating();
                                diceSumNum = throwTwoDice();
                        }
                    } else {
                        diceSumNum = throwTwoDice();
                    }
                } else {
                    diceSumNum = throwTwoDice();
                }

                if (diceSumNum == Board_2 || diceSumNum == Board_12) {
                    displayMessageManager.showLuckyDiceNumber(diceSumNum);
                    int allTip = board.getAllTipOnBoard();
                    player.additionTip(allTip);
                    board.showBoard();
                    displayMessageManager.showWinPlayerTip(player.getPlayerName(), player.getTip());

                    int secondDiceSumNum = throwTwoDice();
                    if (secondDiceSumNum == Board_2 || secondDiceSumNum == Board_12) {
                        board.setAllTipOnBoard();
                        player.subtractionTip(board.Int_IF_ALL_TIP_Set_ON_BOARD);
                    } else {
                        board.setTipOnBoard(secondDiceSumNum);
                        player.subtractionTip(secondDiceSumNum);
                    }
                } else if (diceSumNum == Board_7) {
                    board.setTipOnBoard(diceSumNum);
                    player.subtractionTip(Board_7);
                } else {
                    int getOrSetNum = board.getOrSetTipOnBoard(diceSumNum);
                    player.additionTip(getOrSetNum);
                }

                board.showBoard();
                for (Player players : players) {
                    displayMessageManager.showPlayersTip(players.getPlayerName(), players.getTip());
                }
                if (player.getTip() <= 0) {
                    gameFinished(player.getPlayerName());
                    gameContinued = false;
                    break;
                }
                displayMessageManager.showTurnEnd(player.getPlayerName());
                displayMessageManager.showLeaveSpaces();
                pressEnter();
            }
            gameRoundCounter += 1;
        }
    }

    private int getDiceNumUpperSeven() {
        int firstDiceNumber = rand.nextInt(cheatingOption2DiceEyeMax_1) + 3;
        int secondDiceNumber = rand.nextInt(cheatingOption2DiceEyeMax_2) + 4;
        int sumDiceNumber = firstDiceNumber + secondDiceNumber;
        displayMessageManager.showDiceNumber(firstDiceNumber, secondDiceNumber, sumDiceNumber);
        return sumDiceNumber;
    }

    private int getDiceNumLowerSeven() {
        int firstDiceNumber = rand.nextInt(cheatingOption2DiceEyeMax_1) + 1;
        int secondDiceNumber = rand.nextInt(cheatingOption2DiceEyeMax_2) + 1;
        int sumDiceNumber = firstDiceNumber + secondDiceNumber;
        displayMessageManager.showDiceNumber(firstDiceNumber, secondDiceNumber, sumDiceNumber);
        return sumDiceNumber;
    }

    private int getCheatingOptionNumber() {
        displayMessageManager.askWhichCheatUse();
        return scanner.nextInt();
    }

    private boolean cheating() {
        displayMessageManager.askCheating();
        String cheating = scanner.next().toLowerCase();
        if (cheating.equals("y") || cheating.equals("yes")) {
            return true;
        } else {
            displayMessageManager.showNotUsingCheat();
            return false;
        }
    }

    private int inputNumberOfPlayer() {
        boolean validationNotClear = true;
        int numOfPlayer = 2;
        while (validationNotClear) {
            displayMessageManager.showInputNumOfPlayer();
            numOfPlayer = scanner.nextInt();
            if (validatePlayerNumber(numOfPlayer)) {
                validationNotClear = false;
            } else {
                displayMessageManager.showPlayerNumberCaution();
            }
        }
        return numOfPlayer;
    }

    private boolean validatePlayerNumber(int numOfPlayer) {
        return PlayerUtil.validatePlayerNumber(numOfPlayer);
    }

    private int throwTwoDice() {
        int firstDiceNumber = rand.nextInt(DoshConst.Dice_eye_max) + 1;
        int secondDiceNumber = rand.nextInt(DoshConst.Dice_eye_max) + 1;
        int sumDiceNumber = firstDiceNumber + secondDiceNumber;
        displayMessageManager.showDiceNumber(firstDiceNumber, secondDiceNumber, sumDiceNumber);
        return sumDiceNumber;
    }


    private void gameFinished(String playerName) {
        displayMessageManager.showGameFinished(playerName);
    }

    private void pressEnter() {
        displayMessageManager.pressEnter();
        scanner.nextLine();
    }
}