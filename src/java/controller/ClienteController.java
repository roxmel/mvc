/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import entity.Clientes;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;
import model.ClienteModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
        


/**
 *
 * @author rockxy
 */

@Controller
@RequestMapping (value = "/cliente")
public class ClienteController{
    
    
   @RequestMapping(value = "/all", method = RequestMethod.GET)
   public String getall(Model m){
       ClienteModel model= new ClienteModel();
       //model.getAll(); //verificar este punto
       m.addAttribute("lst",model.getAll());
       return "blista";
 }   
   
//separado
 @RequestMapping(value = "/remove", method = RequestMethod.GET)
  public String remove(@RequestParam(value="carnet") BigDecimal carnet){
       
      ClienteModel model= new ClienteModel();
       //Get employee based objects id
       Clientes e=model.getCli(carnet);
       model.remove(e);
      return "redirect:all.htm";
 
 }

  
  
  
  //@RequestParam: recogemos los parámetros
 @RequestMapping(value = "/edit", method = RequestMethod.GET)
 public String edit(@RequestParam(value="carnet") BigDecimal carnet, Model m){
       //recogemos la petición @RequestParam
       // Model m: Para devolver el modelo
    ClienteModel model= new ClienteModel();
       //Get cliente based objects carnet
       //Clientes e=model.getCli(carnet);
       //m.addAttribute("cli",e); //Devolvemos un modelo a la capa vista (.jsp normalmente)
       m.addAttribute("cli",model.getCli(carnet));
    return "edit";//Retornamos al browser edit.jsp
 }  
 
  
     
     @RequestMapping(value = "/update", method = RequestMethod.POST) //Enviar informacion.
     public String update(@ModelAttribute(value="cliente") Clientes e){
       ClienteModel model= new ClienteModel(); //Creamos el objeto
       //Get employee based objects id
       model.edit(e);//Aqui editamos el objeto en la base de datos.
       return "redirect:all.htm";
 } 
  
     
       @RequestMapping(value = "/redirectCreate", method = RequestMethod.GET)
       public String redirectCreate(){
       return "create";
  
    }
     
       @RequestMapping(value = "/create", method = RequestMethod.POST)
       public String create(@ModelAttribute(value="cliente") Clientes e){
       
       ClienteModel model= new ClienteModel();
       //Get employee based objects id
       model.create(e);
       return "redirect:all.htm";
    }
    
       
    
    @RequestMapping(value = "/buscar", method = RequestMethod.GET) //buscar es igual al edit
     public String buscar(@RequestParam(value="carnet") BigDecimal carnet, Model m){
       
    ClienteModel model= new ClienteModel();
       //Get employee based objects id
       Clientes e=model.getCli(carnet);
       m.addAttribute("cli",e);
       return "edit"; 
 }  
     
  
     
     
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    //para indicar que el resultado del método lo vuelque en el cuerpo de la respuesta.
    public @ResponseBody
    String login(@RequestParam("name") String username, @RequestParam("pwd") String password, Model m) throws SQLException {
        String user = "ninguno"; //verificar esta parte
        String pass = "ninguno";
        Integer resultado=0;
        ClienteModel model=new ClienteModel();
        resultado=model.getUsuario(username, password);
        if (resultado==1) {
            return "true";
        } else {
            return "false";
        }
    }
     
       
 }
       


       
  