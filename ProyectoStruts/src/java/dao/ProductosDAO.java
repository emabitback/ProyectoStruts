
package dao;
// import desarrollo.form.BajasForm;
// import desarrollo.form.UsuarioForm;

import devel.form.AltaPersonalForm;
import devel.form.ConsultaForm;
import devel.form.ProductoForm;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.jms.ConnectionFactory;
import utilerias.ConectionFactory;

public class ProductosDAO {
    
    
    public void insertaProducto(ProductoForm form) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        
        String sql = "insert into productos Values(?,?,?,?,?)";
        
        try{
            con = ConectionFactory.getConnection();
            ps = con.prepareStatement(sql);
            
            ps.setString(1, form.getCodigo_barras());
            ps.setString(2, form.getNombre_producto());
            ps.setString(3, form.getDescripcion());
            ps.setInt(4, form.getCantidad());
            ps.setDouble(5, form.getPrecio());
            
            int rows = ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Error en insertar usuario:"+e.getMessage());
        }finally{
            if(ps!=null && !ps.isClosed()){
                ps.close();
            }
            ConectionFactory.closeConnection(con);
        }
    }
    
    public void insertaPersonal(AltaPersonalForm form) throws Exception{
        Connection con = null;
        PreparedStatement ps = null;
        
        String sql = "insert into personal(rfc,nombre,turno,correo,pass) Values(?,?,?,?,?)";
        
        try{
            con = ConectionFactory.getConnection();
            ps = con.prepareStatement(sql);
           
            
            ps.setString(1, form.getRfc());
            ps.setString(2, form.getNombre());
            ps.setString(3, form.getTurno());
            ps.setString(4, form.getCorreo());
            ps.setString(5, form.getPass());
           // ps.setString(5, form.getFoto());
            
            int rows = ps.executeUpdate();
        }catch (Exception e){
            System.out.println("Error en Dar de Alta el Personal: "+e.getMessage());
        }finally{
            if(ps!=null && !ps.isClosed()){
                ps.close();
            }
            ConectionFactory.closeConnection(con);
        }
    }
    
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
