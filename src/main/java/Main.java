import config.LocalMemoryDataManger;
import pl.edu.agh.Menu;

import java.util.Scanner;

/**
 * Created by mkolbusz on 16.06.17.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        LocalMemoryDataManger manager = new LocalMemoryDataManger();

        Menu menu = new Menu(manager, manager);

        while (true) {
            System.out.println("Enter smth");
            String input = scanner.nextLine();
            try {
                boolean execute = menu.getCommand(input).execute();
                if (!execute) {
                    break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Podano zly parametr");
            }

            System.out.println("Koniec petli");
        }
    }
}
