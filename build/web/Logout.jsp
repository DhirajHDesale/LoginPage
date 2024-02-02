<%-- 
    Document   : Logout
    Created on : 02-Feb-2024, 4:07:33 pm
    Author     : dhira
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
           out.println("<h1>Logout Successfully<h1>");
           HttpSession hs = request.getSession();
           hs.invalidate();
           
            %>
         <a href="Login.html">Login</a> &nbsp;&nbsp;
            <a href="Profile">Profile</a>&nbsp;&nbsp;
    </body>
</html>
