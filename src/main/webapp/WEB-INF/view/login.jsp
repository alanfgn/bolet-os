<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>

	<c:import url="header.jsp"></c:import>
	
	<section>
		<c:url var="urllog" value="/logar" />
		<form:form action="${urllog}" method="post" commandName="pessoa">
			<div>
				<form:input path="login" type="text" placeholder="Login" />
			</div>
			<div>
				<form:input path="senha" type="password" ṕlaceholder="Senha" />
			</div>
			<input type="submit" value=logar>
		</form:form>
	</section>

</body>
</html>