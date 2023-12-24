package design;
//Copy and paste code from leetcode
import java.util.HashMap;

class Node1 {
    int key;
    int val;
    Node1 next;
    Node1 prev;
    int freq = 1;

    Node1(int k, int v) {
        key = k;
        val = v;
    }
}

class DoublyLinkedList {
    Node1 head;
    Node1 tail;

    DoublyLinkedList() {
        head = new Node1(-1, -1);
        tail = new Node1(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    void addNode1(Node1 v) {
        Node1 next = head.next;
        head.next = v;
        v.prev = head;
        head.next = v;
        v.next = next;
        next.prev = v;
    }

    Node1 removeNode1() {
        Node1 Node1 = tail.prev;
        Node1.prev.next = tail;
        tail.prev = Node1.prev;
        return Node1;
    }

    Node1 removeNode1(Node1 v) {
        Node1 prev = v.prev;
        Node1 next = v.next;
        prev.next = next;
        next.prev = prev;
        return v;
    }

    boolean isEmpty() {
        if (head.next == tail)
            return true;
        return false;
    }
}

class LFUCache {
    HashMap<Integer, DoublyLinkedList> freqList = new HashMap<Integer, DoublyLinkedList>();
    HashMap<Integer, Node1> lfuCache = new HashMap<Integer, Node1>();
    int capacity;
    int minFreq;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 1;
    }

    public int get(int key) {
        if (lfuCache.get(key) == null)
            return -1;
        Node1 v = lfuCache.get(key);
        freqList.get(v.freq).removeNode1(v);
        if (freqList.get(v.freq).isEmpty()) {
            if (minFreq == v.freq) {
                minFreq = v.freq + 1;
            }
        }
        v.freq += 1;
        if (freqList.get(v.freq) == null) {
            DoublyLinkedList d = new DoublyLinkedList();
            d.addNode1(v);
            freqList.put(v.freq, d);
        } else {
            freqList.get(v.freq).addNode1(v);
        }
        return v.val;
    }

    public void put(int key, int value) {
        if (capacity == 0)
            return;
        if (lfuCache.get(key) != null) {
            Node1 v = lfuCache.get(key);
            freqList.get(v.freq).removeNode1(v);
            if (freqList.get(v.freq).isEmpty()) {
                if (minFreq == v.freq)
                    minFreq = v.freq + 1;
            }
            v.freq += 1;
            if (freqList.get(v.freq) == null) {
                DoublyLinkedList d = new DoublyLinkedList();
                d.addNode1(v);
                freqList.put(v.freq, d);
            } else {
                freqList.get(v.freq).addNode1(v);
            }
            v.val = value;
        } else {
            if (lfuCache.size() == capacity) {
                Node1 v = freqList.get(minFreq).removeNode1();
                lfuCache.remove(v.key);
            }
            Node1 newNode1 = new Node1(key, value);
            lfuCache.put(key, newNode1);
            if (freqList.get(1) != null) {
                freqList.get(1).addNode1(newNode1);
            } else {
                DoublyLinkedList d = new DoublyLinkedList();
                d.addNode1(newNode1);
                freqList.put(1, d);
            }
            minFreq = 1;
        }
    }
}