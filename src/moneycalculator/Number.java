package moneycalculator;

public class Number {

    private double numerator, denominator;

    public Number(double numerator, double denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        numberSimplify();
    }

    public Number(double number) {
        buildnumber(number);

    }
    public Number(long number){
        numerator = number;
        denominator = 1;
    }
    public Number(int number){
        numerator = number;
        denominator = 1;
    }

    private Number buildnumber(double number) {
        double count = 0;
        double diez = 10;


        while ((number - ((int) number)) != 0) {
            number = number * 10;
            count++;
        }

        return new Number(number, Math.pow(diez, count));


    }

    private void numberSimplify() {
        int prime = 2;
        while ((prime >= numerator) || (prime >= denominator)) {
            if (((numerator % prime) == 0) && (denominator % prime) == 0) {
                numerator = numerator / prime;
                denominator = denominator / prime;
            } else {
                prime = getNextPrime(prime);
            }
        }
    }

    public double getNumerator() {
        return numerator;
    }

    public double getDenominator() {
        return denominator;
    }

    private int getNextPrime(int prime) {
        while (true) {
            prime++;
            if (isprime(prime)) {
                return prime;
            }
        }
    }

    private boolean isprime(int prime) {
        for (int i = 2; i < prime; i++) {
            if ((prime % i)==0) {
                return false;
            }
        }
        return true;
    }
    @Override
    public String toString(){
        Double result = numerator/denominator;
        return result.toString();
    }
    public Number multiplicationNumber(double product){
        return new Number ((numerator*product),denominator);    
    }
}
