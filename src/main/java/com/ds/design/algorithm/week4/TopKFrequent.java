package com.ds.design.algorithm.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

	public static void main(String[] args) {
		Map<Integer,Integer> map = new HashMap<>();
		int a[] = {1,2,3};
		int k = 3;
		map.put(a[0], 1);
		for(int i=1;i<a.length;i++){
			if(map.containsKey(a[i])){
				map.put(a[i], map.get(a[i])+1);
			}
			else if(map.size() < k){
				map.put(a[i], 1);
			}
			else{
				Iterator<Integer> iterator = map.keySet().iterator();
				while(iterator.hasNext()){
					int key = iterator.next();
					if(map.get(key) == 1){
						iterator.remove();
					}
					else{
						map.put(key, map.get(key)-1);
					}
				}
			}
		}
		List<Integer> result = new ArrayList<>();	
		map.forEach((key,value)->{
			int count = 0;
			for(int i =0 ;i<a.length ; i++){
				if(map.containsKey(a[i])){
					count ++;
				}
			}
			if(count > a.length/k){
				result.add(key);
			}
		});
	}
	
}
