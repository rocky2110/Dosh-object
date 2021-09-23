package util;

public class PlayerUtil {

    public static int minPlayerNumber = 2;
    public static int maxPlayerNumber = 5;

    public static boolean validatePlayerNumber(int playerNum) {
        if (minPlayerNumber <= playerNum && playerNum <= maxPlayerNumber) {
            return true;
        }
        return false;
    }
}
