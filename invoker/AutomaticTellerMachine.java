package invoker;

import command.Command;
import java.util.ArrayList;

public class AutomaticTellerMachine {

    private ArrayList<Command> history;

    public AutomaticTellerMachine() {
        history = new ArrayList<Command>();
    }

    public void executeCommand(Command command) {
        command.execute();
        history.add(command);
    }

    public void undoLastCommand() {
        if (history.size() == 0) {
            System.out.println("There are no operations to undo");
            return;
        }
        int lastIndex = history.size() - 1;
        Command last = history.get(lastIndex);
        last.undo();
        history.remove(lastIndex);
    }
}