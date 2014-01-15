package Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class Application {

    public static void main(String[] args) {
        new Application().execute();
    }
    private HashMap<String, Command> commandMap;

    private void execute() {
        createCommands(createApplicationFrame());
    }

    private void createCommands(ApplicationFrame frame) {
        commandMap = new HashMap<>();
        commandMap.put("calculate", new CalculateCommand(
                frame.getMoneyDialog(),
                frame.getCurrencyDialog(),
                frame.getMoneyViewer()));
        commandMap.put("exit", new Command() {
            @Override
            public void execute() {
                System.exit(0);
            }
        });
    }

    private ApplicationFrame createApplicationFrame() {
        return new ApplicationFrame(new ActionListenerFactory() {
            @Override
            public ActionListener createActionListener(final String action) {
                return new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        Command command = commandMap.get(action);
                        if (command == null) {
                            return;
                        }
                        command.execute();
                    }
                };
            }
        });


    }
}
