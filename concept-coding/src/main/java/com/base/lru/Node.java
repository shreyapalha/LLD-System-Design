package com.base.lru;

public class Node<K,V> {
    public String key;
    public String val;
    public Node<K,V> prev;
    public Node<K,V> next;

    public Node(String key,String val,Node<K,V> prev,Node<K,V> next){
        this.key=key;
        this.val=val;
        this.next=next;
        this.prev=prev;

    }

    public Node(String key,String val){
        this.key=key;
        this.val=val;
        this.next=null;
        this.prev=null;
    }
}
