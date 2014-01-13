package moneycalculator;


public class Currency {


    private final String code;
    
    public Currency(String code) {
        this.code = code;
    }


    public String getCode() {
        return code;
    }


    @Override
    public String toString() {
        return code;
    }
    
}

