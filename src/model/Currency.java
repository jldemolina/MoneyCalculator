package model;

public class Currency {

    private final String simbol;
    private final String name;
    private final String code;

    public Currency(String simbol, String name, String code) {
        this.simbol = simbol;
        this.name = name;
        this.code = code;
    }

    public String getSimbol() {
        return simbol;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

}
