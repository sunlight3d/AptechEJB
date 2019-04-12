/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stateless;

import java.util.*;
import javax.ejb.Stateless;
@Stateless
public class LibrarySessionBean implements LibrarySessionBeanRemote {
    public LibrarySessionBean() {
        books = new ArrayList<String>();
    }
    private List<String> books;
    public void addBook(String bookName) {
        books.add(bookName);
    }
    public List<String> getBooks(){
        return books;
    }
}
