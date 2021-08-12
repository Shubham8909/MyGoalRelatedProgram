package com.shubham.learning;

import java.util.HashMap;
import java.util.Map;

public class LRUCache
{
  
    public  int count, cap;
    public  Map<Integer, Node> map;
    
    public Node head,tail;
    
    LRUCache(int cap1)
    {
        cap=cap1;
        count=0;
        head = new Node(0,0);
        tail = new Node(0,0);
        map= new HashMap<>();
        head.next=tail;
        tail.prev=head;
    }
    
     void add(Node node){
        node.prev=head;
        node.next=head.next;
        head.next.prev=node;
        head.next=node;
    }
    
     void remove(Node node){
        node.prev.next= node.next;
        node.next.prev= node.prev;
    }
    
     void update(Node node){
        remove(node);
        add(node);
    }
    
 

    // This method works in O(1)
    public  int get(int key)
    {
        Node n= map.get(key);
        if(n==null) return -1;
        update(n);
        return n.value;
    }

    // This method works in O(1)
    public  void set(int key, int value)
    {
        Node n=map.get(key);
        if(n==null){
             n=new Node(key,value);
            add(n);
            map.put(key,n);
            count++;
        }else{
            n.value=value;
            update(n);
        }
        
        if(count>cap){
            Node deleteN= tail.prev;
            remove(deleteN);
            map.remove(deleteN.key);
            count--;
        }
    }
}


  class Node{
    public  int key;
    public int value;
    public Node prev;
    public Node next;
    
    public Node(int key,int value){
        this.key=key;
        this.value=value;
    }
    
  }
  
  
  
  
