<%-- 
    Document   : Agenda
    Created on : 8 de nov. de 2025, 18:58:06
    Author     : belmo
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <%-- necessário para fazer iteração --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agenda</title>
        <link rel="stylesheet" href="minhasDiv2.css"> 
    </head>
    <body>
        <div id =  "div1">
            AGENDA
        </div>
        <div class = "container">
            
            <div class="div3">
                <c:forEach var="c" items="${contatos}">
                    ${c.nome}  -  ${c.tel}  -  ${c.id} <br>
                </c:forEach>
            </div>
            
            <div class="div4">
                <div id = "div5">
                    <FORM action ="Agenda" method ="POST">
                        <br> 
                        <input type ="text" name="nome" maxlenght="50" placeholder="NOME"><!-- comment -->
                        <input type="text" name="tel" maxlength="15" placeholder="TELEFONE"><!-- comment -->
                        <button type="submit">ENVIAR</button>           
                    </FORM>
                </div>

                <div id="div6"></div>
            </div>
            
        </div>
        
    </body>
</html>
