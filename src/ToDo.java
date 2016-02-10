import com.sun.javafx.scene.control.skin.IntegerFieldSkin;
import com.sun.javafx.scene.control.skin.TabPaneSkin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by alexanderhughes on 2/8/16.
 */
public class ToDo {

    public static HashMap<String, Account> accounts = new HashMap<>();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Account alice = new Account("Alice", "pass1");
        Account bob = new Account("Bob", "pass2");
        Account charlie = new Account("Charlie", "pass3");
        accounts.put("Charlie", charlie);
        accounts.put("Bob", bob);
        accounts.put("Alice", alice);

        while (true) {

            System.out.print("Please enter user name to login: ");
            String userName = scanner.nextLine();
            if (accounts.containsKey(userName)) {
                System.out.print("Please enter password: ");
                String userPass = scanner.nextLine();

                if (accounts.get(userName).password.equals(userPass)) {
                    while (true) {
                        System.out.println("1. Create to-do item");
                        System.out.println("2. Toggle to-do item");
                        System.out.println("3. List to-do items");
                        System.out.println("4. Logout");

                        String option = scanner.nextLine();

                        switch (option) {

                            case "1":
                                System.out.println("Enter your to-do item:");
                                String text = scanner.nextLine();

                                accounts.get(userName).items.add(new ToDoItem(text, false));
                                //ToDoItem item = new ToDoItem(text, false);
                                break;

                            case "2":
                                System.out.print("Enter the number of the item you want to toggle:");
                                int itemNum = Integer.valueOf(scanner.nextLine());
                                ToDoItem itemChoice = accounts.get(userName).items.get(itemNum - 1);
                                itemChoice.isDone = !itemChoice.isDone;
                                break;

                            case "3":
                                int i = 1;
                                for (ToDoItem item : accounts.get(userName).items) {
                                    String checkbox = "[ ] ";
                                    if (item.isDone) {
                                        checkbox = "[x] ";
                                    }
                                    System.out.printf("%s %d. %s\n", checkbox, i, item.text);
                                    i++;
                                }
                                break;
                            case "4":
                                System.out.printf("Goodbye %s\n", userName);
                                break;

                            default:
                                System.out.println("Invalid Option");

                        }
                        if (option.equals("4")) {
                            break;
                        }
                    }
                } else {
                    System.out.println("Invalid user name/password!!!");
                }
            }
            else {
                System.out.printf("An account for %s does not exist, would you like to create a new account? [y/n] ", userName);
                String yOrN = scanner.nextLine();
                switch (yOrN) {
                    case "y":
                        System.out.printf("Please enter a new password for %s: ", userName);
                        String userPass = scanner.nextLine();
                        accounts.put(new Account(userName,userPass).name, new Account(userName, userPass));
                        break;
                    case "n":
                        System.out.println("Goodbye");
                        break;
                }
            }
        }
    }
}
