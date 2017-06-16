package pl.edu.agh;

/**
 * Created by Krzysztof on 16.06.2017.
 */
public interface Command {

    boolean canExecute(String input);

    boolean execute();
}
