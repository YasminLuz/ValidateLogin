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
    
        <jsp:useBean id="user" class="Negocio.UserDTO" scope="page"/>
        <jsp:setProperty name="user" property="*"/>
        <p> <jsp:getProperty name="user" property="validate"/> </p>
    
</html>
