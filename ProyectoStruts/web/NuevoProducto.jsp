<%-- 
    Document   : NuevoProdcuto
    Created on : 12/05/2019, 11:01:44 PM
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
        <title>JSP Page</title>
    </head>
    <body>
         <jsp:include page="header.jsp"/> 
     
        
        <div class="container">
            <html:form method="post" action="/productoAction.do?dispatch=doRegistra">
                Codigo de Barras <html:text property="codigo_barras" styleClass="input input-cb"/> <br> <br>
               Nombre de Producto <html:text property="nombre_producto"styleClass="input"/> <br> <br>
               Descripcion : <br> <html:text property="descripcion" styleClass="input input-des"/> <br> <br>
               Cantidad: <html:text property="cantidad" styleClass="input input-cant"/> 
               &nbsp; &nbsp;  &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
               Precio : <html:text property="precio" styleClass="input input-precio"/> <br> <br> <br>

              <html:submit   property="envio" styleClass="button">Agregar</html:submit>
           </html:form>
             
        </div>   
         <%
                if(request.getParameter("envio") != null ){
                    out.print("<b> <span style='color:#FF0000'> Verifique su Usuario"
                            + "Y Password </span> </b>  ");
                }
            %>
        
        
    </body>
</html>
