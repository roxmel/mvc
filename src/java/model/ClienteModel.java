/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
import entity.*;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.*;
import org.hibernate.*;


/**
 *
 * @author rockxy
 */

//Hibernate é um framework para o mapeamento objeto-relacional
public class ClienteModel {
    
     public List<Clientes> getAll(){
       
       //Un ArrayList lst que es nuestro objeto con la lista de Personas
       List<Clientes> lst= new ArrayList<Clientes>(); 
       Session s=HibernateUtil.getSessionFactory() .getCurrentSession();
       //getCurrentSession(), Nos retorna una sesión que ya existe en el thread actual.
       //getSessionFactory() se encarga de decir al sistema, donde se encuentran todos los ficheros de mapeo de Hibernate
        try {
            s.beginTransaction();
            lst=s.createCriteria(Clientes.class).list(); //Devuelve todos los objetos de la clase Clientes
            //La Session es una fábrica de instancias de Criteria.
            s.getTransaction().commit();
            
        } catch (Exception e) {
            e.printStackTrace(); //No se quiere manejar la excepción
        }
        return lst;        
}
     
        //Creating create,remove,edit function
    
    public void create(Clientes e){
      Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        try {
             s.beginTransaction(); //Inicia una transaccion
             s.save(e);
             s.getTransaction().commit();
            
        } catch (Exception ex) {
           ex.printStackTrace();
           s.getTransaction().rollback();
        }
    
    
}  
    
    
     public void remove(Clientes e){
      Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        try {
             s.beginTransaction();
             s.delete(e);
            s.getTransaction().commit();
            
        } catch (Exception ex) {
           ex.printStackTrace();
           s.getTransaction().rollback();
        }
    
    
} 
     
     
      public void edit(Clientes e){
      Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        try {
             s.beginTransaction();
             s.update(e);
            s.getTransaction().commit();
            
        } catch (Exception ex) {
           ex.printStackTrace();
           s.getTransaction().rollback();
        }
        
     }
      
      

      
       public Clientes getCli(BigDecimal carnet) {
           
        Session s=HibernateUtil.getSessionFactory().getCurrentSession();
        Clientes e=new Clientes();
        try {
             s.beginTransaction();
             e=(Clientes)s.get(Clientes.class, carnet); //esq llama a la función s que recibe como parametros la clase y el caarnet         
             s.getTransaction().commit();
            
        } catch (Exception ex) {
           ex.printStackTrace();
           s.getTransaction().rollback();
        }
       return e;
    }
           
            
            
            
         public Integer getUsuario(String usuario,String contraseña) throws SQLException {
        
        Integer resultado = 0;
        Session sesion = HibernateUtil.getSessionFactory().getCurrentSession();
        sesion.beginTransaction();
        final String sql = "SELECT login('" + usuario+"','" +contraseña+ "') FROM DUAL";
        //Su solicitud será crear una consulta SQL nativo de la sesión createSQLQuery(sql)
        sesion.getSessionFactory().getCurrentSession().createSQLQuery(sql).uniqueResult();
        final BigDecimal nr = (BigDecimal) sesion.getSessionFactory().getCurrentSession().createSQLQuery(sql).uniqueResult();
        //una consulta únicamente retornará unicamente un resultado uniqueResult()
        return nr.intValue();

        //       return resultado;
    }
  }

            
            
