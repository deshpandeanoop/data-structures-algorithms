package com.ds.design.algorithm.week1;

import java.util.Stack;

public class CoinChangeProblem {

	public static void main(String[] args) {
		int[] coins = {1,3,2};
		Stack<Integer> stack = new Stack<>();
		printCoins(coins, 0, 5, stack, 0);
}
	private static void printCoins(int coins[],int startIndex,int target,Stack<Integer> stack,int sum){
		if(sum==target){
			printStack(stack);
			return;
		}
		if(target<sum){
			return;
		}
		for(int i = startIndex; i<coins.length;i++){
			stack.push(coins[i]);
			printCoins(coins, startIndex, target, stack, sum+coins[i]);
			stack.pop();
		}
	}
	private static void printStack(Stack<Integer> stack){
		stack.forEach(item->System.out.print(item+"\t"));
		System.out.println();
	}
}
