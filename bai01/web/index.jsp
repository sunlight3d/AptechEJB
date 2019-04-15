<%@page import="java.util.*"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="ejb.ListBooksRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
    private static ListBooksRemote listBooksRemote;
    public void jspInit() {
        try {
            InitialContext initialContext = new InitialContext();
            listBooksRemote = (ListBooksRemote)initialContext.lookup("java:global/bai01/ListBooks");
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
%>
<%
    if(request.getParameter("addBook") != null) {
        listBooksRemote.addBook(request.getParameter("bookName"));
    }
    if(request.getParameter("removeBook") != null) {
        listBooksRemote.removeBook(request.getParameter("bookName"));
    }
%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post">
            <input type="text" name="bookName"/>
            
            <input type="submit" value="addBook" name="addBook"/>
            <input type="submit" value="removeBook" name="removeBook"/>
            <%
                if(listBooksRemote !=null) {
                    List<String> books = listBooksRemote.getBooks();
                    for(String bookName: books) {
                        out.println("<h3>"+bookName+"<h3>");
                    }
                    out.println("<h3>Number of books: "+books.size()+"<h3>");
                    
                }
            %>
        </form>
    </body>
</html>
