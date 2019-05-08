/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;
// import desarrollo.form.BajasForm;
// import desarrollo.form.UsuarioForm;

import devel.form.ConsultaForm;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.jms.ConnectionFactory;
import utilerias.ConectionFactory;

public class ProductosDAO {
    
    public void consultarProductos() throws Exception{
         Connection con = null;
         PreparedStatement ps = null;
         //int rows = 0;
         //se usa si coinciden los tipos de datos que se reciben
         String sql = "select * from productos";
         
         try{ 
                     con = ConectionFactory.getConnection();
                     ps = con.prepareStatement(sql);
                     Statement inst=con.createStatement();
                     ResultSet rs=inst.executeQuery(sql);
                     
                     if(rs.next()){
                         //return true;
                        String codigo = rs.getString(1).trim();
                        String nombre = rs.getString(2).trim();
                        String descripcion = rs.getString(3).trim();
                        int cantidad = Integer.parseInt(rs.getString(4).trim());
                        float costo = Float.parseFloat(rs.getString(5).trim());
                
                        // String codigo=rs.
                     }
                 }catch(Exception e){
                     System.out.println("error al insertar la informacion: "+e.getMessage());
                 }finally{
                     if(ps!=null && !ps.isClosed()){
                         ps.close();
                     }
                     ConectionFactory.closeConnection(con);
                 }
                 //return false;
    }
          
            
     public boolean verificaLogin(String usuario, String password) throws Exception{
         Connection con = null;
         PreparedStatement ps = null;
         //int rows = 0;
         //se usa si coinciden los tipos de datos que se reciben
         String sql = "select * from login where user='"+usuario+"'and pass='"+password+"'";
                 
                 try{ 
                     con = ConectionFactory.getConnection();
                     ps = con.prepareStatement(sql);
                     Statement inst=con.createStatement();
                     ResultSet rs=inst.executeQuery(sql);
                     
                     if(rs.next()){
                         return true;
                     }
                 }catch(Exception e){
                     System.out.println("error al insertar la informacion: "+e.getMessage());
                 }finally{
                     if(ps!=null && !ps.isClosed()){
                         ps.close();
                     }
                     ConectionFactory.closeConnection(con);
                 }
                 return false;
     }
    
    
}
