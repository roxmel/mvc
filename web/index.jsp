<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
<script src="//code.jquery.com/jquery-1.11.2.min.js"></script>
<script>
    jQuery(document).ready(function(){
        // código javascript y jQuery
	 $("#login").click(function(){	//copiamos su contenido 
		  username=$("#name").val(); //valor del input name
		  password=$("#word").val(); //valor del input word
		  $.ajax({
		   type: "POST",
                   //Indica la url de la que va a cargar datos el objeto ajax.
		   url: "./cliente/login.htm", // aqui va tu request mapping
                   //Se usa para especificar datos a mandar
		   data: "name="+username+"&pwd="+password, // le envias los dos parametros en este caso seran                                          // name y pwd
                   
            //Permite ejecutar código al ser exitoso un llamado. 
            //la función del éxito carga el HTML    
		   success: function(html){    // si se completo la peticion 
			if(html=='true')    {//si el valor devuelto es igual a la palabra "true"           
          //  $("#login").val("nuevo valor desplegado despuesde login") 
                       window.location="cliente/all.htm"; 
						}
			else    {
                       //En el atributo id="add_err", tendra este contenido    
			 $("#add_err").css('display', 'inline', 'important'); 
			//El método .html()  permite leer o cambiar el contenido de cualquier etiqueta
                         $("#add_err").html("Usuario o contraseña invalida");
                        }
		       } 
                     // este codigo es opcional es para la barrita de carga  
		  });
		return false;
	});
});
    
    
</script>

    </head>


<div class="loginform-in">
            <h1>User Login</h1>
            <div class="err" id="add_err"></div>
            <fieldset>
                <form action="./" method="post">
                    <ul>
                        <li> <label for="name">Username </label>
                            <input type="text" size="30"  name="name" id="name"  /></li>
                        <li> <label for="name">Password</label>
                            <input type="password" size="30"  name="word" id="word"  /></li>
                        <li> <label></label>
                            <input type="submit" id="login" name="login" value="Login" class="loginbutton" ></li>
                    </ul>
                </form>
            </fieldset>
        </div>

    </body>
</html>
