<%-- 
    Document   : profile
    Created on : 02-Feb-2024, 3:08:31 pm
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
        <h1>Profile Page</h1>
        <%
            out.println("<p style='text-align:center;'><a href='Logout.jsp'>Logout<a></p>");
              out.println("<p style='text-align:center;'><a href='Login.html'>Login<a></p>");
            HttpSession hs = request.getSession();
           
           
            String id = (String) hs.getAttribute("id");
            String name = (String) hs.getAttribute("na");
            String email = (String) hs.getAttribute("em");
             String city = (String) hs.getAttribute("city");
              String dob = (String) hs.getAttribute("DOB");
            out.println("<h1>id: "+id+"</h1>");
               out.println("<h1>Name: "+name+"</h1>");
                  out.println("<h1>Email: "+email+"</h1>");
                  out.println("<h1>City: "+city+"</h1>");
                  out.println("<h1>DOB: "+dob+"</h1>");
            
            %>
    </body>
</html>
