package com.sau.advprog.assignment3;

public class Test2
{
    static int a;
    public static void main(String[] args)
    {
        Rectangle box1 = new Rectangle(10,10);
        Rectangle box2 = new Rectangle(box1);
        Rectangle box3 = new Rectangle(10);
        Rectangle box4 = box1;

        box1 = null;

        System.out.println("box(l,w) = (" + box2.length + "," + box2.width + ")");
        System.out.println("box(l,w) = (" + box3.length + "," + box3.width + ")");
        System.out.println("box(l,w) = (" + box4.length + "," + box4.width + ")");

        box2 = null;

        System.out.println("\n");

        a = 0;
        System.out.println("a = " + a);
        int a;
        a = 100;
        System.out.println("a = " + a);
        System.out.println("a = " + Test2.a);
    }
}
