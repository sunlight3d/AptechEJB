/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test01;

import java.util.Hashtable;


/**
 *
 * @author Nguyen Duc Hoang
 */
public class Test01 {

    public static void main(String[] args) {
        // TODO code application logic here
        Person p1 = new Person("Hoang", "hoang@gmail.com", 30);
        Person p2 = new Person("Hoang", "hoang@gmail.com", 20);
        System.out.println("Base salary = "+p1.baseSalary);
        System.out.println("Base salary = "+p2.baseSalary);
        /*
        Person p2 = new Person("Hoang", "hoang@gmail.com", 20);
        Person p3 = p1;
        Person p4 = new Person("Hoang4", "hoang4@gmail.com", 40);
        if(p1.equals(p2)) {
            System.out.println("P1 equal p2");
        } else {
            System.out.println("P1 NOT equal p2");
        }
        if (p1.equals(p3)) {
            System.out.println("P1 equal p3");
        }
        if(p4.compareTo(p1) > 0) {
            System.out.println("p1 > p4");
        } else {
            System.out.println("p1 < p4");     

        }
        
        String x = new String("str 11");
        //Map
        Hashtable map = new Hashtable<String, Object>();
        map.put("name", "Hoang");
        map.put("age", 20);
        map.put("isLoggedIn", true);
        
        System.out.println("Name is "+map.get("name"));
        Hashtable points = new Hashtable<Double, Double>();
        points.put(1.2, 2.3);
        points.put(3.2, 3.3);
        points.put(6.2, 5.3);
        System.out.println("p is "+points.get(3.2));
        */
    }
    
}
