package res;

public enum DisplayStrings {
    ASK_NUMBER_OF_PLAYER("何人でプレイしますか？\n"),

    GAME_START("<Dosh スタート>"),

    RULE_SUMMARY("<ルール概要>\n" +
            "・プレーヤーは2人以上です。\n" +
            "・各プレーヤーは30枚のチップを持っています。\n" +
            "・2個のダイスを順に降っていき、チップをボードに置いたり撮ったり（①～③）して進みます。\n" +
            "・プレーヤーの誰かの所持チップがなくなった時点でゲーム終了です。\n" +
            "・所持チップが最も多いプレーヤーの優勝です。"),

    RULE_DETAIL("<ルール詳細>\n" +
            "①2,7,12以外の目の場合、ボートの出た目の数字の上に、出た目の枚数を、チップがあれば取り、なければ置きます。\n" +
            "②7の目の場合、ボート外に7枚チップを置きます。牢獄と呼びます。\n" +
            "③2,12の目の場合、ボードと牢獄のチップを総取りします。もう一度ダイスを振ります。\n" +
            "③-1 ゾロ目以外の場合、ボートの出た目の数字の上に、出た目の枚数を置きます。\n" +
            "③-2 ゾロ目の場合、ボートの全ての数字の上に、数字の枚数のチップを置きます。"),

    BOARD_TOP_AND_BOTTOM_LINE("+-----+-----+-----+  +-----+"),
    BOARD_THIRD_LINE("+-----+-----+-----+  |     |");

    private final String text;

    DisplayStrings(final String text) {
        this.text = text;
    }

    public String getString() {
        return this.text;
    }
}
