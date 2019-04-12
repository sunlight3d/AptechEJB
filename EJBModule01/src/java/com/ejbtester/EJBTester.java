/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ejbtester;
import java.util.*;
import com.stateless.LibrarySessionBeanRemote;
import javax.naming.*;

/**
 *
 * @author Nguyen Duc Hoang
 */
public class EJBTester {
    private InitialContext context;
    private Properties props;
    //constructor
    public EJBTester() {
        props = new Properties();
        try {
            context = new InitialContext(props);
        } catch(NamingException ex) {
            System.out.println("Error creating context");
        }                
    }
    public static void main(String[] args) {
        EJBTester ejbTester = new EJBTester();
        ejbTester.testStatelessEJB();
    }
    public void testStatelessEJB() {
        try {
            LibrarySessionBeanRemote librarySessionBeanRemote = (LibrarySessionBeanRemote)context.lookup("LibrarySessionBean/remote");
            librarySessionBeanRemote.addBook("Java book");
            librarySessionBeanRemote.addBook("C# book");
            List<String> foundBooks = librarySessionBeanRemote.getBooks();
            for(String eachBook: foundBooks) {
                System.out.println("eachBook = "+eachBook);
            }
        } catch(Exception e) {
            System.out.println("Error = "+e);
        }
        
    }
}
