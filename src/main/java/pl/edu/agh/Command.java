package pl.edu.agh;

/**
 * Created by Krzysztof on 16.06.2017.
 */
public interface Command {
    String getKey();

//    default boolean canExecute(String input) {
//        return getKey().equals(input);
//    }

    boolean execute();
}
