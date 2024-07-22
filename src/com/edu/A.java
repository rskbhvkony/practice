package com.edu;

class A implements Cloneable{
    public int y;
    public B b;

    public A(){
        b = new B();
    }

    public static void main(String[] args) throws CloneNotSupportedException{
        A a = new A();
        A a2 = (A) a.clone();
        System.out.print(a.b == a2.b);
    }
}
