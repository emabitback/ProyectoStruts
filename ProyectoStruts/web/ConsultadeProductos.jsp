

<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@page import="utilerias.ConectionFactory" %>

<%@page import="java.io.*, java.util.*, java.net.*, java.sql.*" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Consulta General</title>
    </head>
    <body>
        
         <jsp:include page="header.jsp"/> 
        <style>
            table{
                width: 700px;
            }
        </style>
        
        
        <h1>Listado de usuarios</h1>
        
        <table>
            <tr>
                <td><strong>Codigo De Barras</strong></td>
                <td><strong>Producto</strong></td>
                <td><strong>Descripcion</strong></td>
                <td><strong>Cantidad</strong></td>
                <td><strong>Precio</strong></td>
            </tr>
            <%
            Connection con = null;
            PreparedStatement ps = null;
            String query = "select *  from productos";
            
            try{
                con = ConectionFactory.getConnection();
                ps = con.prepareStatement(query);
                Statement inst = con.createStatement();
                ResultSet rs = inst.executeQuery(query);
                
                //hace copia de los campos trim de tipo cadena
                while(rs.next()){
                    String id = rs.getString(1).trim();
                    String nombre = rs.getString(2).trim();
                    String carrera = rs.getString(3).trim();
                    String semestre = rs.getString(4).trim();
                    String precio =rs.getString(5).trim();
                
            
            %>
            
            <tr>
                <td><%= id%></td>
                <td><%= nombre%></td>
                <td><%= carrera%></td>
                <td><%= semestre%></td>
                <td><%= precio%></td>
            </tr>
            <%
            }
            %>   
        </table>
            <%
                con.close();
                inst.close();
            }
            catch(Exception ex){
                out.println("Problemas en: "+ex.getMessage());
            }
            %>
    </body>
</html>
