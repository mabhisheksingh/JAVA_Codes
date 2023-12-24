package design;

import java.util.HashMap;

public class LRUCache {


    private HashMap<Integer, Node> mapOfDoublyLinkedList;
    public Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    private int capacity;

    public Node addNode(int val,int key) {
        Node tempNode = new Node(val,key);
        Node headNext = head.next;
        tempNode.next = headNext;
        tempNode.prev = head;
        head.next = tempNode;
        headNext.prev = tempNode;
        return tempNode;
    }

    public void deleteNode(Node node) {
        Node tempPrev = node.prev;
        Node tempNext = node.next;
        tempPrev.next = tempNext;
        tempNext.prev = tempPrev;
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        head.prev = null;
        tail.prev = head;
        tail.next = null;
        this.mapOfDoublyLinkedList = new HashMap<>(capacity);
    }

    public int get(int key) {
        if (mapOfDoublyLinkedList.containsKey(key)) {
            Node temp = mapOfDoublyLinkedList.get(key);
            deleteNode(temp);
            mapOfDoublyLinkedList.put(key, addNode(temp.val, temp.key));
            System.out.println("Key:  " + key + " Val "+temp);
            return temp.val;
        }
        System.out.println("Not fined");
        return -1;
    }

    public void put(int key, int value) {
        if (mapOfDoublyLinkedList.size() == capacity && !(mapOfDoublyLinkedList.containsKey(key) ) ) {
            mapOfDoublyLinkedList.remove(tail.prev.key);
            deleteNode(tail.prev);
        }
        if( mapOfDoublyLinkedList.containsKey(key)){
            deleteNode( mapOfDoublyLinkedList.get(key) );
            mapOfDoublyLinkedList.remove( key );
        }
        mapOfDoublyLinkedList.put(key, addNode(value, key));
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        lRUCache.get(1);    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lRUCache.get(2);    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        lRUCache.get(3);    // return 3
        lRUCache.get(4);    // return 4
    }
}

//Doubly linked list
class Node {

    public Node prev;
    public Node next;
    public int val;
    public int key;

    public Node(int value,int key) {
        this.prev = null;
        this.next = null;
        this.val = value;
        this.key = key;
    }

}