package pl.edu.agh;

import config.LocalMemoryDataManger;

/**
 * Created by Krzysztof on 16.06.2017.
 */
public class Menu {
    private MenuItem[] menu;

    public Menu(LocalMemoryDataManger manager) {

        menu = new MenuItem[]{
                new MenuItem("Wyczyść wszystkie liczniki", new ClearCountersCommand(manager))
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
