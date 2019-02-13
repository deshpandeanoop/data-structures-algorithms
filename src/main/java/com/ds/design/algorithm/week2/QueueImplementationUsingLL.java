package com.ds.design.algorithm.week2;

public class QueueImplementationUsingLL {

	public static void main(String[] args) {
		QueueImplementationUsingLL queue = new QueueImplementationUsingLL();
		int a[] = { 1, 2, 3, 4, 5 };
		ListNode[] qE = queue.createQueue(a);
		ListNode head = qE[0];
		ListNode tail = qE[1];
		ListNode.print(head);
		head = queue.deQueue(head);
		ListNode.print(head);
		tail = queue.enQueue(tail, 6);
		ListNode.print(head);
	}

	private ListNode[] createQueue(int[] data) {
		ListNode head = null, tail = null;
		ListNode[] qE = new ListNode[2];
		head = tail = enQueue(tail, data[0]);
		for (int i = 1; i < data.length; i++) {
			tail = enQueue(tail, data[i]);
		}
		qE[0] = head;
		qE[1] = tail;
		return qE;
	}

	private ListNode enQueue(ListNode tail, int val) {
		ListNode newNode = new ListNode(val);
		if (tail == null) {
			tail = newNode;
			return tail;
		} else {
			tail.next = newNode;
			tail = newNode;
			return tail;
		}
	}

	private ListNode deQueue(ListNode head) {
		if (null == head) {
			System.out.println("Queue undeflow");
			return head;
		}
		return head.next;
	}
}
