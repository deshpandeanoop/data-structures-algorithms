package com.ds.design.algorithm.week1;

public class ReverseWordsInString {

	public static void main(String[] args) {
		ReverseWordsInString r = new ReverseWordsInString();
		
		System.out.println(r.reverseWords("Deshpande Anoop"));
	}
	public String reverseWords(String s){
		if(null==s){
			return null;
		}
		StringBuffer sb = new StringBuffer();
		String[] tokens = s.trim().split(" ");
		for(int i=tokens.length-1;i>=0;i--){
			if(tokens[i].trim().length()>0){
				sb.append(tokens[i]);
				sb.append(" ");
			}
		}
		return sb.toString().substring(0,sb.toString().length()-1);
	}
}
