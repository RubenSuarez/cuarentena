<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div class="box">
    <h5 align="center">Registro de usuario</h5>
<%--     <form:form role="form" method="POST"> --%>
	<form:form method="POST" action="/addUser" modelAttribute="user">
      <div class="inputBox">
        <form:input type="text" path="surname" name="surname" autocomplete="off" required="required"></form:input>
        <form:label path="surname">Apellido</form:label>
      </div>
      
      <div class="inputBox">
        <form:input type="text" path="name" name="name" autocomplete="off" required="required"></form:input>
        <form:label path="name">Nombre</form:label>
      </div>
      <div class="inputBox">
        <form:input type="text" path="email" name="email" autocomplete="off" required="required"></form:input>
        <form:label path="email">Email</form:label>
      </div>
      <div class="inputBox">
        <form:input type="password" path="password" name="password" autocomplete="off" required="required"></form:input>
        <form:label path="password">Contraseña</form:label>
      </div>
      <div class="inputBox">
        <form:input type="password" path="repeatPassword" name="repeatPassword" autocomplete="off" required="required"></form:input>
        <form:label path="repeatPassword">Repetir contraseña</form:label>
      </div>
      <input type="submit" name="login" value="Registrarse">
    </form:form>
  </div>