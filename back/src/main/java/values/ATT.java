package values;

public enum ATT {
    USING_CSS(""),
    USING_XPATH("//"),
    FIND_ALL("*"),
    FIND_INPUT("input"),
    WHERE_NAME("name"),
    WHERE_TEXT("text()"),
    EQUALS("="),
    CONTAINS("*=");

    private final String type;

    ATT(String type) {
        this.type = type;
    }

    public String get() {
        return type;
    }
}
