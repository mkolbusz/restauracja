package pl.edu.agh;

import config.BucketManager;
import config.RaportManager;

/**
 * Created by Krzysztof on 16.06.2017.
 */
public class Menu {
    private MenuItem[] menu;
    private BucketManager bucketManager;
    private RaportManager raportManager;

    public Menu(BucketManager bucketManager, RaportManager raportManager) {
        this.bucketManager = bucketManager;
        this.raportManager = raportManager;

        menu = new MenuItem[]{
                new MenuItem("Wyczyść wszystkie liczniki", new ClearCountersCommand(raportManager))
        };

    }

    public MenuItem[] getMenu() {
        return menu;
    }

    public Command getCommand(String input) {
        for (MenuItem menuItem : menu) {
            if (menuItem.getCommand().canExecute(input)) {
                return menuItem.getCommand();
            }
        }

        throw new IllegalArgumentException("No command fallback configured!");

    }

}
