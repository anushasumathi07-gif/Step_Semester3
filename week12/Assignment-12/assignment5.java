
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

public class assignment5 {

    static Node partition(Node head, int passMark) {
        Node belowHead = null;
        Node belowTail = null;

        Node aboveHead = null;
        Node aboveTail = null;

        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = null;

            if (current.data < passMark) {
                if (belowHead == null) {
                    belowHead = current;
                    belowTail = current;
                } else {
                    belowTail.next = current;
                    belowTail = current;
                }
            } else {
                if (aboveHead == null) {
                    aboveHead = current;
                    aboveTail = current;
                } else {
                    aboveTail.next = current;
                    aboveTail = current;
                }
            }

            current = nextNode;
        }

        if (belowHead == null) {
            return aboveHead;
        }

        belowTail.next = aboveHead;

        return belowHead;
    }

    static void display(Node head) {
        while (head != null) {
            System.out.print(head.data + " -> ");
            head = head.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {
            Node newNode = new Node(sc.nextInt());

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        int passMark = sc.nextInt();

        head = partition(head, passMark);

        display(head);
    }
}
