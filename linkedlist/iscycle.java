// detect a loop / cycle in a ll

public class iscycle{
    static class Node{
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }
    static Node head; // decleare head as static
    public static boolean isCycle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next; // +1
            fast = fast.next.next; //+2
            if(slow == fast) {
                return true; // cycle
            }
        }
        return false; // no cycle
    }
    public static void main(String[] args) {
        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;

        System.out.println(isCycle(head));
    }
}