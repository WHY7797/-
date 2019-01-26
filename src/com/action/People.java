package com.action;

public class People implements Cloneable {

    private String name = "ilt";
    private Hand hand = new Hand();

    public Hand getHand() {
        return hand;
    }

    public void setHand(Hand hand) {
        this.hand = hand;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // TODO Auto-generated method stub
        People p2 = (People) super.clone();
        p2.setHand((Hand) hand.clone());
        return p2;
    }
    public static void main(String[] args) throws CloneNotSupportedException {
        People p1 = new People();
        People p2 = (People) p1.clone();
        System.out.println("第一个对象的hash值:" + p1.hashCode());
        System.out.println("第二个对象的hash值:" + p2.hashCode());
        System.out.println("分割线-----------");
        System.out.println("p1中的hand对象的hash值:" + p1.getHand().hashCode());
        System.out.println("p2中的hand对象的hash值:" + p2.getHand().hashCode());
    }
}

class Hand implements Cloneable {

    @Override
    protected Object clone() throws CloneNotSupportedException {
       
        return super.clone();
    }
}

