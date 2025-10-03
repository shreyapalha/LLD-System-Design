package com.base.lru;

import java.util.HashMap;

public class LRUMain<K,V> {

    private int capacity;
    private HashMap<String,Node<K,V>> map;

    private DoublyLinkedList<K,V> dll;


    public LRUMain(int capacity){
        map=new HashMap<>();
        this.capacity=capacity;
        dll=new DoublyLinkedList<K,V>();
    }

    public synchronized void put(String key,String value){
        if(map.containsKey(key)){
            Node<K,V> node=map.get(key);
            node.val=value;
            dll.moveInFront(node);
            return;
        }
        if(capacity == map.size()){
            Node<K,V> last=dll.removeFromLast();
            if(last!=null)  map.remove(last.key);
        }
        Node<K,V> input=new Node<K,V>(key,value);
        map.put(key,input);
        dll.add(input);
    }

    public synchronized String get(String key){
        if(!map.containsKey(key)) return null;
        Node<K,V> cur=map.get(key);
        dll.remove(cur);
        dll.moveInFront(cur);
        return cur.val;
    }

    public synchronized void remove(String key){
        if(!map.containsKey(key)) return;
        Node<K,V> node=map.get(key);
        dll.remove(node);
        map.remove(node);
    }
}
