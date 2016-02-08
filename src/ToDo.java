import com.sun.javafx.scene.control.skin.IntegerFieldSkin;
import com.sun.javafx.scene.control.skin.TabPaneSkin;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by alexanderhughes on 2/8/16.
 */
public class ToDo {

    public static void main(String[] args) {

        ArrayList<ToDoItem> items = new ArrayList<ToDoItem>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Create to-do item");
            System.out.println("2. Toggle to-do item");
            System.out.println("3. List to-do items");

            String option = scanner.nextLine();

            switch (option) {

                case "1":
                    System.out.println("Enter your to-do item:");
                    String text = scanner.nextLine();

                    items.add(new ToDoItem(text, false));
                    //ToDoItem item = new ToDoItem(text, false);
                    break;

                case "2":
                    System.out.print("Enter the number of the item you want to toggle:");
                    int itemNum = Integer.valueOf(scanner.nextLine());
                    ToDoItem itemChoice = items.get(itemNum - 1);
                    itemChoice.isDone = !itemChoice.isDone;
                    break;

                case "3":
                    int i = 1;
                    for (ToDoItem item : items) {
                        String checkbox = "[ ] ";
                        if (item.isDone) {
                            checkbox = "[x] ";
                        }
                        System.out.println(checkbox + i + ". " + item.text);
                        i++;
                    }
                    break;

                default:
                    System.out.println("Invalid Option");

            }
        }
    }
}
