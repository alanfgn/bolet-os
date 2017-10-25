<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>

	<c:import url="header.jsp"></c:import>
	<section>
		Terminar inscrição como usuário:
		<c:url var="urlusu" value="/usuario" />
		<form action="${urlusu}" method="post">

			<input name="email" type="email" placeholder="Email" required /> <input
				name="nome" type="text" placeholder="Nome" required /> <input
				type="submit" value="Terminar Inscrição">
		</form>
	</section>

</body>
</html>