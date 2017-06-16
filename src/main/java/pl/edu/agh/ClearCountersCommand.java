package pl.edu.agh;

import config.RaportManager;

/**
 * Created by Krzysztof on 16.06.2017.
 */
public class ClearCountersCommand implements Command {

    private RaportManager manager;

    public ClearCountersCommand(RaportManager manager) {
        this.manager = manager;
    }

    public boolean canExecute(String input) {
        return input.equals("0");
    }

    public boolean execute() {
        System.out.println("Bla");
        manager.clearAllBackets();
        return true;
    }
}
