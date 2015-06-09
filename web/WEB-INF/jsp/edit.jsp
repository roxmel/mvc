<%-- 
    Document   : edit
    Created on : 05-13-2015, 08:07:35 PM
    Author     : rockxy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="f" uri= "http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<center>
        <h1>Edicion</h1>
        <f:form action="update.htm" modelAttribute="cliente">
                  <input type="hidden" name="carnet" value="${cli.carnet}"/>
            Name: <input type="text" name="nombre" value="${cli.nombre}"/>
            apellidos: <input type="text" name="apellidos" value="${cli.apellidos}"/>
            dui: <input type="text" name="dui" value="${cli.dui}"/>
            <input type="submit" value="Save"/>     
            <a href="remove.htm?carnet=${cli.carnet}" onclick="return confirm('Are you sure?')"><input type="button" value="Remove"</a> 
        </f:form>
         
    <center>        
    </body>
</html>
