<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>

        
       <form action="buscar.htm" method="GET"/>
            <center>
                <h1>Busqueda</h1>
                <ul>
                    <label for="name">CARNET:</label>
                    <input type="text" size="30"  name="carnet" id="carnet"  />
                    <input type="submit" value="buscar" /> 
                </ul>
                <a href="redirectCreate.htm"> INSERTAR UN NUEVO CLIENTE</a>
                </form>
        
        
        <table style="border-collapse: collapse" cellpadding="7px" border="1" >
            
            <tr>
                <th>CARNET</th>
                <th>NOMBRE</th>
                <th>APELLIDOS</th>
                <th>DUI</th> 
                <th>ACTIONS</th> 
            </tr>   
            
          <c:forEach items="${lst}" var="em">
            <tr>
              <td>${em.carnet}</td>
              <td>${em.nombre}</td>
              <td>${em.apellidos}</td>
              <td>${em.dui}</td> 
               <td> <a href="buscar.htm?carnet=${em.carnet}">Edit</a> │
                    <a href="remove.htm?carnet=${em.carnet}" onclick="return confirm('Are you sure?')">Remove</a>  
               </td>  
            </tr>
        </c:forEach> 
            
         </center>
   </table>
          
                 
    </body>
</html>