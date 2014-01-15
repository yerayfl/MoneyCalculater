package Control;

import UserInterface.MoneyDialog;
import UserInterface.MoneyViewer;
import UserInterface.CurrencyDialog;
import Model.Money;
import Model.Number;

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
        return 0.9;
    }

    private Number calculateAmount() {
        return (moneyDialog.getMoney().getAmount()).multiplicationNumber(getExchangeRate());
    }
}