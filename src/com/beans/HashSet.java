package com.beans;

class HashSet{
	public static void main(String[] args) {
		String s1="ab";
		String s2="a"+"b"; 
		String s3="a";
		String s4="b";
		String s5=s3+s4;
		System.out.println(s2.equals(s5));
		System.out.println(s2==s5);
	}
}
