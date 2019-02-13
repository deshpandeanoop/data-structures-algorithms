package com.ds.design.algorithm.week1;

public class LinkedListSort {
	public static void main(String[] args) {
		LinkedListSort l = new LinkedListSort();
		int []a = {1,0,0,1,2,2,0};
		LinkedList list = new LinkedList(a);
		list.print(l.sortList(list.getHead()));
	}
	private Node sortList(Node h){
		 Node h1=null,h2=null,h3=null,t1=null,t2=null,t3=null;
		while(h!=null){
			if(h.d==0){
				Node[] n1 = append(h1, t1, 0);
				h1 = n1[0];
				t1 = n1[1];
			}
			else if(h.d==1){
				Node[] n1 = append(h2, t2, 1);
				h2 = n1[0];
				t2 = n1[1];
			}
			else if(h.d==2){
				Node[] n1 = append(h3, t3, 2);
				h3 = n1[0];
				t3 = n1[1];
			}
			h = h.n;
		}
		t2.n=h3;
		t1.n=h2;
		return h1;
	}
	private Node[] append(Node h,Node t, int x){
		Node n = new Node(x);
		if(null == h){
			h=n;
		}
		else{
			t.n=n;
		}
		t=n;
		Node[] nodes = {h,t};
		return nodes;
	}
}
