package com.base.lru;

public class DoublyLinkedList<K,V> {
    private Node<K,V> head;
    private Node<K,V> tail;

    public DoublyLinkedList(){
        this.head=new Node<K,V>(null,null);
        this.tail=new Node<K,V>(null,null);
        head.next=tail;
        tail.prev=head;
    }

    public void remove(Node<K,V> cur){
        Node<K,V> p=cur.prev;
        Node<K,V> n=cur.next;
        p.next=cur.next;
        n.prev=p;

    }

    public Node<K,V> removeFromLast(){
        if(tail.prev==head) return null;
        Node<K,V> p=tail.prev;
        p.prev.next=tail;
        tail.prev=p.prev;
        return p;
    }

    public void add(Node<K,V> cur){
        Node<K,V> n=head.next;
        head.next=cur;
        cur.next=n;
        cur.prev=head;
        n.prev=cur;
    }

    public void moveInFront(Node<K,V> cur){
        remove(cur);
        add(cur);
    }
}
