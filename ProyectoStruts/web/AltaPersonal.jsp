<%-- 
    Document   : AltaPersonal
    Created on : 14/05/2019, 02:57:24 PM
    Author     : bitback
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilos-ema.css">
        <title>Alta de Personal</title>
    </head>
    <body>
             <jsp:include page="header.jsp"/>
        
        
        
           <div class="personal">
            <html:form method="post" action="/altaPersonalAction.do?dispatch=doRegistrarP">
                RFC :<html:text property="rfc" styleClass="input input-rfc f" maxlength="13"/> <br> <br>

                   Nombre Completo : <html:text property="nombre"styleClass="input input-nombre f"/> <br> <br>

                   E-mail : <html:text property="correo" styleClass="input input-contrasena f"/> <br> <br>

                   Contraseña : <html:password property="pass" styleClass="input f"/> 
                   &nbsp; &nbsp;  &nbsp; 

                 <!--  Foto : <input name="uploadedfile" type="file" />  <br> <br>
                    &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; 
                  !-->
                   Turno Laboral : <html:text property="turno" styleClass="input f"/> <br> <br>

                  <html:submit   property="envio" styleClass="button-personal">Registrar Personal</html:submit>
               </html:form>
           </div>      
    </body>
</html>
