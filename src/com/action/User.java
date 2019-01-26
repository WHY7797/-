package com.action;


public class User implements Cloneable{
	int age;
	Goods goods;
	

	protected Object clone() throws CloneNotSupportedException {
		
		return super.clone();
	}
	

	public static void main(String[] args) throws CloneNotSupportedException {
		User u1=new User();
		u1.setAge(18);
		
		System.out.println(u1.hashCode());
		System.out.println(u1.age);
		
		User u2=(User)u1.clone();
		u1.setAge(12);
		System.out.println(u2.hashCode());
		System.out.println(u2.age);
		System.out.println(Integer.SIZE);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public Goods getGoods() {
		return goods;
	}
	
	public void setGoods(Goods goods) {
		this.goods = goods;
	}


	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
}