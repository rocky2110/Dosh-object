package Logic;

import board.Board;
import display.DisplayMessageManager;
import player.Player;
import util.DoshConst;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Logic {
    private DisplayMessageManager displayMessageManager = new DisplayMessageManager();
    Random rand = new Random();
    Scanner scanner = new Scanner(System.in);
    // 複数プレーヤーがいるため可変長配列を使う
    private ArrayList<Player> players = new ArrayList();

    public void execute() {
        // Dosh ゲーム要件。

        // ルールを説明する。
        displayMessageManager.showExplanation();

        // ゲーム開始
        displayMessageManager.beginDoshGame();

        // ボードのインスタンスを作る
        Board board = new Board(displayMessageManager);
        // 初期状態のボードを表示する
        board.showBoard();

        // プレーヤーは 2人以上で、コンソールに数字を打ち込ませて人数を入力させるとゲームが開始する。
        int numOfPlayer = inputNumberOfPlayer();

        // プレーヤーのインスタンスを作成する
        for (int i = 0; i < numOfPlayer; i++) {
            String playerName = "";
            if (i == 0) {
                playerName = "自分";
            } else {
                playerName = "プレイヤー" + (i + 1);
            }
            Player player = new Player(playerName);
            players.add(player);
        }

        // プレーヤ1 がサイコロをふる。
        // 強制的にチップを置くか、ボードのマス目にチップがあるかどうかで置くか置かないか、プレーヤーの手元のチップが増えるか、減るかが決まる。
        boolean gameContinued = true;
        while (gameContinued) {
            for (Player player: players) {
                displayMessageManager.showPlayerTurnStart(player.getPlayerName());
                int diceSumNum = throwTwoDice();
                if (diceSumNum == 2 || diceSumNum == 12) {
                    // ok
                    // オリジナル感出してみて、ラッキーナンバーみたいな表示にしてみる。
                    displayMessageManager.showLuckyDiceNumber(diceSumNum);
                    board.showBoard();
                    // 2,12 の場合、ボートと牢獄のチップを総取りして、もう一度ダイスをふる。
                    int allTip = board.getAllTipOnBoard();
                    // プレーヤーのチップに加える
                    player.additionTip(allTip);


                    int secondDiceSumNum = throwTwoDice();
                    if (secondDiceSumNum == 2 || secondDiceSumNum == 12) {
                        // ok
                        // 2,12 の目の場合、ボードの全ての数字の上に、数字の枚数チップを置く。
                        board.setAllTipOnBoard();
                        player.subtractionTip(board.Int_IF_ALL_TIP_Set_ON_BOARD);


                    } else {
                        // 2,12 の目以外の場合、ボードのでための数字の上に、出た目の枚数チップを置く。
                        board.setTipOnBoard(secondDiceSumNum);
                        player.subtractionTip(secondDiceSumNum);

                    }
                } else if (diceSumNum == 7) {
                    // 7 の場合、ボート外に7枚チップをおく。ここを牢獄と呼ぶ。
                    board.setTipOnBoard(diceSumNum);
                    // todo あれ、7の場合、すでにチップがあったらどうするんだ。。これルールを聞いておこう。
                    player.subtractionTip(7);

                } else {
                    // 2,7,12 以外の目の場合、ボート上にある出た目と同じ数字の上に、チップが無ければでための枚数のチップを置く。あればチップをもらう。
                    int getOrSetNum = board.getOrSetTipOnBoard(diceSumNum);

                    // プレーヤーの持ちチップ数は、出た目の数だけ増減する
                    player.additionTip(getOrSetNum);
                }

                board.showBoard();
                for (Player players : players) {
                    displayMessageManager.showPlayersTip(players.getPlayerName(),players.getTip());
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
        }
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


    private void gameFinished(String playerName) {
        displayMessageManager.showGameFinished(playerName);
    }

    private void pressEnter() {
        displayMessageManager.pressEnter();
        scanner.nextLine();
    }
}