package com.pluralsight;

public class Person implements Comparable<Person>{
    private String firstName, lastName;
    private int age;

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Person person) {
        //returns 1 == this object is greater, this
        //returns 0 == comparable objects are the same
        //returns -1 == this object is less, person

        if (this.lastName.compareTo(person.lastName) != 0) {
            return this.lastName.compareTo(person.lastName);
        } else if (this.firstName.compareTo(person.firstName) != 0) {
            return this.firstName.compareTo(person.firstName);
        }

        return Integer.compare(this.age, person.age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
