package test01;

import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nguyen Duc Hoang
 */
public class Person implements Comparable {
    private String name, email;
    private Integer age;
    private String aliasName;
    public static Double baseSalary = 133.0;
    Person(String name, String email, Integer age) {
        
        this.name = name;
        this.email = email;
        this.age = age;
        System.out.println("This is a constructor");
    }
    {
        aliasName = "Anonymous";
        name = "";
        email = "";
        System.out.println("This is a Block");
    }
    @Override
    public int compareTo(Object o) {
        //so sanh tuoi
        Person otherPerson = (Person)o;
        if(otherPerson.name.length() == this.name.length()) {
            return 0;
        } else if(this.name.length() > otherPerson.name.length()) {
            return 1;//so duong la ok
        } else {
            return -1;//so am
        }
    }
    /*
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        Person otherPerson = (Person)obj;
        if(this.name.equals(otherPerson.name) 
                && this.email.equals(otherPerson.email)) {
            return true;
        }
        return true;
    }
    */
}
