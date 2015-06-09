<%-- 
    Document   : create
    Created on : 05-13-2015, 08:32:36 PM
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
       <f:form action="create.htm" modelAttribute="cliente">
                  <input type="hidden" name="carnet" value="${cli.carnet}"/>
             Name: <input type="text" name="nombre" value="${cli.nombre}"/>
            apellidos: <input type="text" name="apellidos" value="${cli.apellidos}"/>
            dui: <input type="text" name="dui" value="${cli.dui}"/>            
            <input type="submit" value="Insert"/>
        </f:form>
    </body>
</html>
