
import java.util.*;

class Tab {
    String name;
    Tab prev;
    Tab next;

    Tab(String name) {
        this.name = name;
    }
}

public class assignment4 {

    Tab head = null;
    Tab current = null;

    void open(String name) {
        Tab newTab = new Tab(name);

        if (current == null) {
            head = newTab;
            current = newTab;
            return;
        }

        newTab.prev = current;
        newTab.next = current.next;

        if (current.next != null) {
            current.next.prev = newTab;
        }

        current.next = newTab;
        current = newTab;
    }

    void close() {
        if (current == null) {
            System.out.println("No tabs to close");
            return;
        }

        Tab temp = current;

        if (temp.prev != null) {
            temp.prev.next = temp.next;
        } else {
            head = temp.next;
        }

        if (temp.next != null) {
            temp.next.prev = temp.prev;
            current = temp.next;
        } else {
            current = temp.prev;
        }

        temp.prev = null;
        temp.next = null;
    }

    void back() {
        if (current == null || current.prev == null) {
            System.out.println("BACK: already at first tab");
            return;
        }

        current = current.prev;
        System.out.print("BACK: ");
        display();
    }

    void forward() {
        if (current == null || current.next == null) {
            System.out.println("FORWARD: already at last tab");
            return;
        }

        current = current.next;
        System.out.print("FORWARD: ");
        display();
    }

    void display() {
        Tab temp = head;

        while (temp != null) {
            if (temp == current) {
                System.out.print("[" + temp.name + "]");
            } else {
                System.out.print(temp.name);
            }

            if (temp.next != null) {
                System.out.print(" <-> ");
            }

            temp = temp.next;
        }

        System.out.println();
    }

    void printBackward() {
        Tab temp = head;

        if (temp == null) {
            System.out.println("Backward: (empty)");
            return;
        }

        while (temp.next != null) {
            temp = temp.next;
        }

        System.out.print("Backward: ");

        while (temp != null) {
            System.out.print(temp.name);

            if (temp.prev != null) {
                System.out.print(" <-> ");
            }

            temp = temp.prev;
        }

        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        assignment4 browser = new assignment4();

        String input = sc.useDelimiter("\\A").next();
        String[] commands = input.split("[,\\r\\n]+");

        for (String command : commands) {
            command = command.trim();

            if (command.isEmpty()) {
                continue;
            }

            if (command.startsWith("OPEN ")) {
                String name = command.substring(5).trim();
                browser.open(name);
                System.out.print("OPEN " + name + ": ");
                browser.display();
            }
            else if (command.equals("BACK")) {
                browser.back();
            }
            else if (command.equals("FORWARD")) {
                browser.forward();
            }
            else if (command.equals("CLOSE")) {
                if (browser.current != null) {
                    String name = browser.current.name;
                    browser.close();
                    System.out.print("CLOSE " + name + ": ");
                    browser.display();
                } else {
                    System.out.println("No tabs to close");
                }
            }
            else if (command.equals("PRINT BACKWARD")) {
                browser.printBackward();
            }
        }
    }
}
