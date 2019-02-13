package com.ds.design.algorithm.week1;

public class DeleteNodeFromLL {
	private Node head;
	public static void main(String[] args) {
		int a[] = {1,2};
		LinkedList l = new LinkedList(a);
		DeleteNodeFromLL d = new DeleteNodeFromLL();
		d.head = l.getHead();
		d.delete(d.head, 7);
		l.print(d.head);
	}
	private void delete(Node h,int pos){
		if(h==null || pos<1){
			return;
		}
		if(pos==1){
			head=head.n;
			return;
		}
		int c = 2;
		Node p=h;
		h=h.n;
		while(h!=null){
			if(c==pos){
				break;
			}
			c++;
			p=h;
			h=h.n;
		}
		if(h!=null){
			p.n = h.n;
		}
	}
}
