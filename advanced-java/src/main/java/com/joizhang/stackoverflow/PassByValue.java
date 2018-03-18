package com.joizhang.stackoverflow;

/**
 * @author joizhang
 */
public class PassByValue {

    private static void foo(Dog aDog) {
        System.out.println("Max".equals(aDog.getName()));
        aDog = new Dog("Fifi");
        System.out.println("Fifi".equals(aDog.getName()));
    }

    private static void foo1(Dog aDog) {
        System.out.println("Max".equals(aDog.getName()));
        aDog.setName("Fifi");
        System.out.println("Fifi".equals(aDog.getName()));
    }

    public static void main(String[] args) {
        Dog aDog = new Dog("Max");
        foo(aDog);
        System.out.println("Max".equals(aDog.getName()));
        System.out.println("Fifi".equals(aDog.getName()));

        System.out.println();

        foo1(aDog);
        System.out.println("Max".equals(aDog.getName()));
        System.out.println("Fifi".equals(aDog.getName()));
    }


}

class Dog {

    private String name;

    Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}