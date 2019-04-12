/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stateless;
import java.util.*;
import javax.ejb.Remote;

@Remote
public interface LibrarySessionBeanRemote {
    void addBook(String bookName);
    List<String> getBooks();
}
