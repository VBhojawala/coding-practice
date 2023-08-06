package linkedList;

import java.util.HashMap;
import java.util.Map;

public class LRUCache146 {

    private int capacity;
    private int size;
    Node head = new Node();
    Node tail = new Node();
    Map<Integer, Node> nodeMap = new HashMap<>();

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if(!nodeMap.containsKey(key)){
            return -1;
        }
        Node node = nodeMap.get(key);
        removeNode(node);
        addHead(node);
        return node.val;
    }

    public void put(int key, int value) {
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.val = value;
            removeNode(node);
            addHead(node);
        }else {
            Node node = new Node(key, value);
            addHead(node);
            nodeMap.put(key, node);
            size++;

            if (size > capacity){
                Node tailNode = removeTail();
                nodeMap.remove(tailNode.key);
                size--;
            }

        }

    }

    public void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void addHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    public Node removeTail(){
        Node node = tail.prev;
        removeNode(node);
        return node;
    }


}
