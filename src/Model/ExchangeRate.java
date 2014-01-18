package Model;

public class ExchangeRate {

    private final Currency from, to;
    private double rate;

    public ExchangeRate(Currency to, double rate) {
        this.from = new Currency("EUR");
        this.to = to;
        this.rate = rate;
    }

    public Currency getTo() {
        return to;
    }

    public double getRate() {
        return rate;
    }

    public void multirate(double rate2) {
        rate = rate * rate2;

    }
}
