<%-- 
    Document   : frm
    Created on : 16/07/2019, 00:37:10
    Author     : Yasmin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <jsp:useBean id="user" class="Negocio.UserDTO"/>
        <jsp:setProperty name="user" property="*"/>
        <p> <jsp:getProperty name="user" property="ValidateLogon"/> </p>
    </body>
</html>
