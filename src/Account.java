import java.util.ArrayList;

/**
 * Created by alexanderhughes on 2/9/16.
 */
public class Account {
    public String name;
    public String password;
    public ArrayList<ToDoItem> items = new ArrayList<ToDoItem>();

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
