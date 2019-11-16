package pl.sda.intermediate.PlayLists;

public enum PlayMode {
    RANDOM("LOSOWO"),
    SEQUENTIAL("KOLEJNO"),
    LOOP("PETLA");

    private String pMName;

    PlayMode(String str) {
        this.pMName = str;
    }
}
