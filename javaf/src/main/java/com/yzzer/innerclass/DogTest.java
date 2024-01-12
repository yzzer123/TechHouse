package com.yzzer.innerclass;

public class DogTest {
    public static void main(String[] args) {
        Person.Dog dog = new Person.Dog();

        Person person = new Person();
        Person.Dragon dragon = person.new Dragon();

        Object obj = new Object() {
        };

        Object obj2 = new Object() {
        };

        System.out.println(obj.getClass());
        System.out.println(obj2.getClass());
        System.out.println(obj.getClass().getSuperclass());
    }
}
