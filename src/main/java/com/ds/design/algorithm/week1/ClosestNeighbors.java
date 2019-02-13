package com.ds.design.algorithm.week1;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class ClosestNeighbors {

	public static void main(String[] args) {
		ClosestNeighbors cl = new ClosestNeighbors();
		//int k=4;
		int target = 3;
		int [] a ={1,2,3,4,5};
		List<Integer> list = cl.getNeighbors(a, target);
		list.forEach(item->System.out.println(item));
	}
	private List<Integer> getNeighbors(int[] a, int target){
		List<Integer> list = new ArrayList<Integer>();
		Map<Integer,Integer> map = new TreeMap<Integer,Integer>();
		int start =0,end = a.length-1,mid;
		while(start<=end){
			mid = start + ((end-start)>>1);
			addNeighbor(a, map, target, mid);
			if(target>a[mid]){
				start = mid+1;
			}
			else if (target<a[mid]){
				end = mid-1;
			}
			else{
				addNeighbor(a, map, target, mid);
				break;
			}
		}
		list.addAll(map.values());
		return list;
	}
	private void addNeighbor(int[] a,Map<Integer, Integer> map, int target, int mid){
		int diff = (int) Math.abs(a[mid]-target);
		if(map.containsKey(diff)){
			if(map.get(diff)<a[mid]){
				return;
			}
		}
		map.put(diff, a[mid]);
	}
}
