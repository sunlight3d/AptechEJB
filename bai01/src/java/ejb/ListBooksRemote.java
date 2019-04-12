/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;
import java.util.*;
//stateful
public interface ListBooksRemote {
    void addBook(String bookName);
    void removeBook(String bookName);
    List<String> getBooks();
}
