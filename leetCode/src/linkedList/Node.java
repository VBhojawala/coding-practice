package linkedList;

public class Node {
    int val;
    int key;
    Node next;
    Node prev;
    Node random;
    Node() {}
    Node(int val) { this.val = val; }
    Node(int val, Node next) { this.val = val; this.next = next; }
    Node(int key, int val){
        this.key = key;
        this.val = val;

    }
}
