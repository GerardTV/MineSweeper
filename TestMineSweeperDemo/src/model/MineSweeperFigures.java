package src.model;

//No s'utilitza, he pensat que seria massa moguda
public enum MineSweeperFigures {
    MINE("*"),
    EMPTY(" "),
    UNKNOWN("?");
    public final String value;

    MineSweeperFigures(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
