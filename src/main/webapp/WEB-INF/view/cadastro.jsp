<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro</title>
</head>
<body>

	<c:import url="header.jsp"></c:import>

	<section>

		<c:url var="urlcad" value="/cadastro" />
		<form:form action="${urlcad}" method="post" commandName="pessoa">

			<div>
				<form:input path="login" placeholder="Login" type="text"/>
				<form:errors path="login"/>
			</div>

			<div>
				<form:input path="senha" placeholder="Senha" type="password"/>
				<form:errors path="senha"/>
			</div>

			<div>
				<form:input path="cpf" placeholder="Cpf" type="text"/>
				<form:errors path="cpf"/>
			</div>

			<input type="Submit" value="Cadastrar">
		</form:form>
	</section>

</body>
</html>