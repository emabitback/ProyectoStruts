
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="login.css">
        
        <title> LOGIN </title>
    </head>
    <body>
        
        
        <div>
            <h2>Inicio de Sesion</h2> 
        <html:form method="post" action="">
            
            <p> Ingresa tu usuario </p> <html:text  property="userName"  /> <br> <br>
            <p>Ingresa tu contraseña</p> <html:password property="password"/> <br> <br> 
            <html:submit property="envioLog" value="Ingresar"/>
            
        </html:form>
            
        </div>   
            
            <%
                if(request.getParameter("envioLog") != null ){
                    out.print("<b> <span style='color:#FF0000'> Verifique su Usuario"
                            + "Y Password </span> </b>  ");
                }
            %>
    </body>
</html>
