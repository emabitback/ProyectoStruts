
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
                width: 70%;
                
            }
            .rfc{ width: 10%}
            .nombre{ width: 20%;}
            .turno{ width: 5%; }
            .email{ width: 10%; }
            .password{ width: 10%; }
            .foto{ width: 10%;}
            img{
                height: 200px;
                width: 300px;'
            }
            
        </style>
        
        
        <h1>Listado de usuarios</h1>
        
        <table border="1">
            <tr>
                <td class="rfc"><strong>RFC</strong></td>
                <td class="nombre"><strong>NOMBRE</strong></td> <br>
            <td class="turno"><strong>TURNO</strong></td>
            <td class="email"><strong>EMAIL</strong></td>
            <td class="password"><strong>pASWORD</strong></td>
            <td class="foto"><strong>FOTO</strong></td>
            </tr>
            
            
            <%
            Connection con = null;
            PreparedStatement ps = null;
            String per= "select * from personal";
            
            try{
                con = ConectionFactory.getConnection();
                ps = con.prepareStatement(per);
                Statement inst = con.createStatement();
                ResultSet rs = inst.executeQuery(per);
                
                //hace copia de los campos trim de tipo cadena
                while(rs.next()){
                    String rfc= rs.getString(1).trim();
                    String nombre = rs.getString(2).trim();
                    char turno = rs.getString(3).charAt(0);
                    String email = rs.getString(4).trim();
                    String p =rs.getString(5).trim();
                   String foto=rs.getString(6).trim();
                   String path="/home/bitback/NetBeansProjects/ProyectoStruts/ProyectoStruts/"+foto;
                
            
            %>
            
            <tr>
                <td class="rfc"><%= rfc%></td>
                <td class="nombre"><%= nombre%></td>
                <td class="turno"><%= turno%></td>
                <td class="email" ><%= email%></td>
                <td class="password"><%= p%></td>
                <td class="foto">
                    <img src="<%= path%>"/>
                </td>
            </tr>"
                    
                   
            <%
            }
            %>   
        </table>
            <%
                con.close();
                inst.close();
            }
            catch(Exception ex){
                out.println("Problemas en: "+ex.getMessage().toString());
            }
            %>