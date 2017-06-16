package config;

import pl.edu.agh.Command;

import java.util.Date;

/**
 * Created by damian on 16/06/2017.
 */
public class AdultAddCommand implements Command {

    BucketManager bucketManager;

    public AdultAddCommand(BucketManager bucketManager) {
        this.bucketManager = bucketManager;
    }

    public boolean canExecute(String input) {
        return input!=null && input.equalsIgnoreCase("A");
    }

    public boolean execute() {
        bucketManager.add(new Date(), Type.ADULT);
        return true;
    }
}
