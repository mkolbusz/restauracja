package pl.edu.agh;

/**
 * Created by Krzysztof on 16.06.2017.
 */
public class MenuItem {

    private String name;
    private Command command;

    public MenuItem(String name, Command command) {
        this.name = name;
        this.command = command;
    }

    public String getName() {
        return name;
    }

    public Command getCommand() {
        return command;
    }
}
