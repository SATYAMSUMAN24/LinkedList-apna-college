
/** A linked list node containing an integer value. */
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

/** Solution class for manipulating a linked list. */
public class solution3{
    Node head;

    /** Swaps nodes with values x and y in the linked list. */
    public void swapNodes(int x, int y) {
        if (x == y) {
            return;
        }

        Node prevX = null, currX = head;
        while (currX != null && currX.data != x) {
            prevX = currX;
            currX = currX.next;
        }

        Node prevY = null, currY = head;
        while (currY != null && currY.data != y) {
            prevY = currY;
            currY = currY.next;
        }

        if (currX == null || currY == null) {
            return;
        }

        if (prevX != null) {
            prevX.next = currY;
        } else {
            head = currY;
        }

        if (prevY != null) {
            prevY.next = currX;
        } else {
            head = currX;
        }

        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    /** Adds a new node with value new_data at the beginning of the list. */
    public void push(int new_data) {
        Node new_Node = new Node(new_data);
        new_Node.next = head;
        head = new_Node;
    }

    /** Prints the linked list as a string of space-separated integers. */
    public void printList() {
        Node tNode = head;
        while (tNode != null) {
            System.out.print(tNode.data + " ");
            tNode = tNode.next;
        }
        System.out.println();
    }

    /** Main method for testing the Solution class. */
    public static void main(String[] args) {
        solution3 list = new solution3();

        list.push(7);
        list.push(6);
        list.push(5);
        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        System.out.print("Linked list before: ");
        list.printList();

        list.swapNodes(4, 3);

        System.out.print("Linked list after: ");
        list.printList();
    }
}