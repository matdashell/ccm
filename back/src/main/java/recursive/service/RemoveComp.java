package recursive.service;

public class RemoveComp {

    public String removeFrom(String value) {
        return value.replace("<", "").replace(">", "");
    }
}
