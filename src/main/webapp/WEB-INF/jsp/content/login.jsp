<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<div class="container h-100">
	<div class="row justify-content-md-center ">
		<h5 align="center">Iniciar sesión</h5>
	</div>
	<div class="row justify-content-md-center">
		<form:form method="POST" action="/login" modelAttribute="user">
			<div class="form-group">
				<form:label path="email">Usuario</form:label>
				<form:input type="text" path="username" name="username"
					class="form-control" />
				<form:errors path="email" cssClass="text-danger" />
			</div>

			<div class="form-group">
				<form:label path="password">Contraseña</form:label>
				<form:input type="password" path="password" name="password"
					class="form-control" />
				<form:errors path="password" cssClass="text-danger" />
			</div>

			<input type="submit" name="ingresar" value="Ingresar"
				class="btn btn-primary mr-4">
			<a href="sign-up">Registrarse</a>
		</form:form>
	</div>
</div>
