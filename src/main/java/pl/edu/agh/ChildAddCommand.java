package pl.edu.agh; /**
 * Created by damian on 16/06/2017.
 */

import config.BucketManager;
import config.Type;
import pl.edu.agh.Command;

import java.util.Date;

public class ChildAddCommand implements Command {

    BucketManager bucketManager;

    public ChildAddCommand(BucketManager bucketManager) {
        this.bucketManager = bucketManager;
    }

    public boolean canExecute(String input) {
        return input!=null && input.equalsIgnoreCase("c");
    }

    public boolean execute() {
        bucketManager.add(new Date(), Type.CHILD);
        return true;
    }
}
