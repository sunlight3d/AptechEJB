<%@page import="javax.naming.InitialContext"%>
<%@page import="ejb.ListBooksRemote"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%!
    private static ListBooksRemote listBooksRemote;
    public void jspInit() {
        try {
            InitialContext initialContext = new InitialContext();
            listBooksRemote = (ListBooksRemote)initialContext.lookup("EJBStateful/ListBooks");
        } catch(Exception e) {
            
        }
    }
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
    </body>
</html>
