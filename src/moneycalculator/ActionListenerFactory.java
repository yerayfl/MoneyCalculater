package moneycalculator;


import java.awt.event.ActionListener;


public interface ActionListenerFactory {
    public ActionListener createActionListener(String action);
}

