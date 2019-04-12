<%@page import="javax.naming.InitialContext"%>
<%@page import="ejb.ListBooksRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
    private static ListBooksRemote listBooksRemote;
    public void jspInit() {
        try {
            InitialContext initialContext = new InitialContext();
            listBooksRemote = (ListBooksRemote)initialContext.lookup("java:global/EJBStateful/ListBooks");
        } catch(Exception e) {
            System.out.println("error = ");
        }
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
        </form>
    </body>
</html>
