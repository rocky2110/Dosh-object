package board;

import display.DisplayMessageManager;

import java.util.HashMap;
import java.util.Map;

import static util.DoshConst.*;

public class Board {
    private DisplayMessageManager displayMessageManager;
    private Map<Integer, Boolean> isSetTip = new HashMap<>();
    private int jailCount = 0;
    public final int Int_IF_ALL_TIP_Set_ON_BOARD;


    {
        BoardStateInitialized();
        Int_IF_ALL_TIP_Set_ON_BOARD = getNumberOfAllTipOnBoard();
    }


    public Board(DisplayMessageManager displayMessageManager) {
        this.displayMessageManager = displayMessageManager;
    }


    public void showBoard() {
        displayMessageManager.showFirstAndLastLineOnBoard();
        String secondLine = createSecondLineOnBoard();
        displayMessageManager.showSecondLineOnBoard(secondLine);
        displayMessageManager.showThirdAndFiveLine();
        String forthLine = createForthLineOnBoard();
        displayMessageManager.showForthLineOnBoard(forthLine);
        displayMessageManager.showThirdAndFiveLine();
        String sixLine = createSixLineOnBoard();
        displayMessageManager.showSixLine(sixLine);
        displayMessageManager.showFirstAndLastLineOnBoard();
    }


    public void setTipOnBoard(int diceSumNumber) {
        if (diceSumNumber == 7) {
            jailCount += 1;
        }
        isSetTip.put(diceSumNumber, true);
    }

    public int getOrSetTipOnBoard(int diceSumNumber) {
        if (canFetchTip(diceSumNumber)) {
            isSetTip.put(diceSumNumber, false);
            return diceSumNumber;
        } else {
            isSetTip.put(diceSumNumber, true);
            return -1 * diceSumNumber;
        }
    }

    public int getAllTipOnBoard() {
        int allTipOnBoard = 0;
        for (Map.Entry<Integer, Boolean> entry : isSetTip.entrySet()) {
            if (entry.getValue()) {
                if (entry.getKey() == 7) {
                    allTipOnBoard += Board_7 * jailCount;
                } else {
                    allTipOnBoard += entry.getKey();
                }
            }
        }
        BoardStateInitialized();
        initializeJailCount();
        return allTipOnBoard;
    }

    private void initializeJailCount() {
        jailCount = 0;
    }


    public Boolean canFetchTip(int diceSumNumber) {
        return isSetTip.get(diceSumNumber);
    }

    public void setAllTipOnBoard() {
        setFullTipOnBoard();
    }


    private int getNumberOfAllTipOnBoard() {
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
        String secondLine = "|  " + sixOnBoardState + "  |     |  " + eightOnBoardState + "  |  |  " + sevenOnBoardState + "  |";
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
