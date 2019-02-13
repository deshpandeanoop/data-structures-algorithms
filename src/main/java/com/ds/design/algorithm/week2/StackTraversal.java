package com.ds.design.algorithm.week2;

public class StackTraversal {
	public static void main(String a[]) {
		StackTraversal stack = new StackTraversal();
		ListNode head = null;
		int data[] = { 1, 2, 3, 4, 5 };
		head = stack.createStack(data, head);
		stack.printStack(head);
		System.out.println("Element pos from top of the stack : "+stack.findElement(head, 2));
		stack.printStack(head);
	}

	private ListNode createStack(int[] data, ListNode head) {
		for (Integer i : data) {
			head = push(head, i);
		}
		return head;
	}

	// Returns position of the element with value key, from top of the stack
	private int findElement(ListNode head, int key) {
		ListNode tempStack = null;
		int pos = 1;
		boolean flag = false;
		while (head != null) {
			if (head.val == key) {
				flag = true;
				break;
			}
			tempStack = push(tempStack, head.val);
			head = pop(head);
			pos++;
		}
		while (tempStack != null) {
			head = push(head, tempStack.val);
			tempStack = tempStack.next;
		}
		if(flag)
			return pos;
		else
			return -1;
	}

	private ListNode push(ListNode head, int val) {
		ListNode newNode = new ListNode(val);
		newNode.next = head;
		head = newNode;
		return head;
	}

	private ListNode pop(ListNode head) {
		if (head == null) {
			System.out.println("Stack has been underflowed");
			return null;
		}
		head = head.next;
		return head;
	}

	@SuppressWarnings("unused")
	private int peek(ListNode head) {
		if (null == head) {
			System.out.println("Stack is empty");
			return -1;
		}
		return head.val;
	}

	private class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	private void printStack(ListNode head) {
		while (head != null) {
			System.out.print(head.val + "\t");
			head = head.next;
		}
		System.out.println();
	}
}
