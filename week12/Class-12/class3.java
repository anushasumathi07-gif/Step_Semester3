import java.util.*;

class Editor {
    String[] history;
    int top;

    Editor(int capacity) {
        history = new String[capacity];
        top = -1;
    }

    void type(String word) {
        if (top == history.length - 1) {
            System.out.println("rejected: history full");
            return;
        }

        history[++top] = word;
        display();
    }

    void undo() {
        if (top == -1) {
            System.out.println("rejected: nothing to undo");
            return;
        }

        history[top] = null;
        top--;
        display();
    }

    void display() {
        if (top == -1) {
            System.out.println("(empty)");
            return;
        }

        for (int i = 0; i <= top; i++) {
            System.out.print(history[i]);

            if (i < top) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}

public class class3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int capacity = Integer.parseInt(sc.nextLine());
        Editor editor = new Editor(capacity);

        String commands = sc.useDelimiter("\\A").next();

        String[] operations = commands.split("[;\\r\\n]+");

        for (String operation : operations) {
            operation = operation.trim();

            if (operation.startsWith("TYPE ")) {
                String word = operation.substring(5).trim();
                editor.type(word);
            } 
            else if (operation.equals("UNDO")) {
                editor.undo();
            }
        }
    }
}