package Design;

import java.util.HashMap;

public class LRUCache {
    public static void main(String[] args) {
        
        LRU obj = new LRU(2);

        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println("Get 1: " + obj.get(1)); // Output: 1

        obj.put(3, 3);
        System.out.println("Get 2: " + obj.get(2));
        obj.put(4, 4); // Removes key 1
        System.out.println("Get 1: " + obj.get(1));
        System.out.println("Get 3: " + obj.get(3));
        System.out.println("Get 4: " + obj.get(4));
    }
}

class LRU {

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    HashMap<Integer, Node> map;
    Node head, tail;

    public LRU(int capacity) {
        this.capacity= capacity;
        map= new HashMap<>();
        head = new Node(0,0);
        tail= new Node(0,0);

        head.next=tail;
        tail.prev=head;

    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node= map.get(key);
            removeNode(node);
            addToFront(node);
            return node.value;
        }

        return -1;
    }

    public void put(int key, int value) {

        if(map.containsKey(key)){
            Node node= map.get(key);
            node.value=value;
            removeNode(node);
            addToFront(node);
        }else{

            Node newNode = new Node(key, value);
            addToFront(newNode);
            map.put(key, newNode);

            if(map.size()>capacity){
                Node lruNode= tail.prev;
                removeNode(lruNode);
                map.remove(lruNode.key);
            }
        }
    }

    public void removeNode(Node node){
        node.prev.next=node.next;
        node.next.prev= node.prev;
    }

    public void addToFront(Node node){

        node.next= head.next;
        head.next.prev= node;
        head.next=node;
        node.prev= head;

    }
}
