package Control;

import Model.Currency;
import Model.ExchangeRate;
import UserInterface.MoneyDialog;
import UserInterface.MoneyViewer;
import UserInterface.CurrencyDialog;
import Model.Money;
import Model.Number;
import Persistence.ExchangeRateLoader;
import Persistence.FileExchangeRateLoader;

public class CalculateCommand extends Command {

    private final MoneyDialog moneyDialog;
    private final CurrencyDialog currencyDialog;
    private final MoneyViewer moneyViewer;

    public CalculateCommand(MoneyDialog moneyDialog, CurrencyDialog currencyDialog, MoneyViewer moneyViewer) {
        this.moneyDialog = moneyDialog;
        this.currencyDialog = currencyDialog;
        this.moneyViewer = moneyViewer;
    }

    @Override
    public void execute() {

        moneyViewer.show(new Money(calculateAmount(), currencyDialog.getCurrency()));

    }

    private double getExchangeRate() {
        String file = "C:\\Users\\Yeray\\Documents\\NetBeansProjects\\MoneyCalculator\\ExchangeRate.txt";
        if (moneyDialog.getMoney().getCurrency().equals(new Currency("EUR"))) {
            ExchangeRate change = new FileExchangeRateLoader(file).load(currencyDialog.getCurrency());
            return change.getRate();
        } else {
            ExchangeRate change = new FileExchangeRateLoader(file).load(currencyDialog.getCurrency());
            change.multirate(new FileExchangeRateLoader(file).load(moneyDialog.getMoney().getCurrency()).getRate());
            return change.getRate();
        }
    }

    private Number calculateAmount() {
        return (moneyDialog.getMoney().getAmount()).multiplicationNumber(getExchangeRate());
    }
}
