package com.ds.design.algorithm.week1;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private final Map<Integer, ListNode> map = new HashMap<Integer,ListNode>();
	private final int capacity;
	private ListNode head;
	private ListNode tail;
	public static void main(String a[]){
		LRUCache cache = new LRUCache(2);
		cache.put(2, 6);
	//	cache.print();
		cache.put(1, 5);
	//	cache.print();
		cache.put(1, 2);
		cache.get(2);
	//	System.out.println(cache.get(2));
	}
	public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
    	ListNode n = map.get(key);
    	if(null== n){
    		return -1;
    	}
    	remove(n);
    	add(n.key,n.value);
    	return n.value;
    }
    
    public void put(int key, int value) {
    	if(map.containsKey(key)){
    		remove(map.get(key));
    	}
    	if(map.size() ==capacity){
    		remove(head);
    	}
    	add(key, value);
    }
    private void add(int key, int value){
    	ListNode n = new ListNode(key, value);
    	addToLL(n);
    	map.put(key, n);
    }
    private void remove(ListNode n){
    	removeFromLL(n);
    	map.remove(n.key);
    }
    private void addToLL(ListNode n){
    	if(head == null){
    		head=n;
    	}
    	else{
    		tail.next = n;
    		n.prev=tail;
    	}
    	tail=n;
    	tail.next=null;
    }
    private void removeFromLL(ListNode n){
    	if(n.prev != null && n.next!=null){
    		n.prev.next = n.next;
    		n.next.prev = n.prev;
    	}
    	else if(n==head){
    		head=head.next;
    		if(head!=null)
    			head.prev=null;
    	}
    	else {
    		tail=tail.prev;
    		if(tail.prev!=null)
    		tail.next=null;
    	}
    }
    private  class ListNode{
    	 private int key;
    	 private int value;
    	 private ListNode next;
    	 private ListNode prev;
    	 public ListNode(int key,int value){
    		 this.key = key;
    		 this.value = value;
    	 }
    	 }
}
