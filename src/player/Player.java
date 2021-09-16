package player;

public class Player {
    private int tip = 30;
    private String playerName;

    public Player(String name) {
        this.playerName = name;
    }

    public int getTip() {
        return tip;
    }

    public void subtractionTip (int diff) {
        tip -= diff;
    }

    public void additionTip (int diff) {
        tip += diff;
    }

    public String getPlayerName() {
        return playerName;
    }
}
