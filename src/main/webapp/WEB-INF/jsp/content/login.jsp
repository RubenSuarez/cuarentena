<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="box">
    <h5 align="center">Iniciar sesión</h5>
 
	<form:form method="POST" action="/login" modelAttribute="user">
      <div class="inputBox">
        <form:input type="text" path="email" name="email" 
        autocomplete="off" required="required">
        </form:input>
        <form:label path="email">Usuario</form:label>
      </div>
      
      
      
      <div class="inputBox">
        <form:input type="password" path="password" name="password" autocomplete="off" required="required"></form:input>
        <form:label path="password">Contraseña</form:label>
      </div>
      
      <input type="submit" name="ingresar" value="Registrarse">
    </form:form>
  </div>