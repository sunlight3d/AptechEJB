/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;
import java.util.*;
import javax.ejb.Stateful;

@Stateful
public class ListBooks implements ListBooksRemote{
    private List<String> books = new ArrayList<String>();

    @Override
    public void addBook(String bookName) {
        books.add(bookName);
    }

    @Override
    public void removeBook(String bookName) {
        books.remove(bookName);
    }

    @Override
    public List<String> getBooks() {
        return books;
    }
    
}

