package moneycalculator;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.PopupMenu;
import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JPanel;

public class ApplicationFrame extends JFrame {

    private MoneyDialog moneyDialog;
    private CurrencyDialog currencyDialog;
    private MoneyViewer moneyViewer;
    private ActionListenerFactory factory;

    public ApplicationFrame(ActionListenerFactory factory) throws HeadlessException {
        super("Money calculator");
        this.factory = factory;
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.createComponents();
        this.setVisible(true);
    }

    public MoneyDialog getMoneyDialog() {
        return moneyDialog;
    }

    public CurrencyDialog getCurrencyDialog() {
        return currencyDialog;
    }

    public MoneyViewer getMoneyViewer() {
        return moneyViewer;
    }

    private void createComponents() {
        this.add(createContentPanel());
        this.add(createToolbarPanel(), BorderLayout.SOUTH);
    }

    private JPanel createContentPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.add(createMoneyDialogPanel());
        panel.add(createCurrencyDialogPanel());
        panel.add(createMoneyViewerPanel());
        return panel;
    }

    private JPanel createToolbarPanel() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        panel.add(createCalculateButton());
        panel.add(createExitButton());
        return panel;
    }

    private JButton createCalculateButton() {
        JButton button = new JButton("Calculate");
        this.getRootPane().setDefaultButton(button);
        button.addActionListener(factory.createActionListener("calculate"));
        return button;
    }

    private JButton createExitButton() {
        JButton button = new JButton("Exit");
        button.addActionListener(factory.createActionListener("exit"));
        return button;
    }

    private JPanel createMoneyDialogPanel() {
        MoneyDialogPanel panel = new MoneyDialogPanel();
        this.moneyDialog = panel;
        return panel;
    }

    private JPanel createCurrencyDialogPanel() {
        CurrencyDialogPanel panel = new CurrencyDialogPanel("USD");
        this.currencyDialog = panel;
        return panel;
    }

    private JPanel createMoneyViewerPanel() {
        MoneyViewerPanel panel = new MoneyViewerPanel();
        this.moneyViewer = panel;
        return panel;
    }
}
