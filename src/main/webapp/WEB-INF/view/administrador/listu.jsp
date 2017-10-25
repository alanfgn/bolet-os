<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista usuarios</title>
</head>
<body>

	<c:import url="../header.jsp"></c:import>
	<section>
		<c:forEach items="${lista}" var="usu">

			<div>
				<ul>
					<li>${usu.nome}</li>
					<li>${usu.cpf}</li>
					<li>${usu.email}</li>
				</ul>

				<a href='<c:url value="/boleto/${usu.id}" context="/bolet-os"/>'><button>Gerar
						Boleto</button></a>
			</div>

			<hr>
		</c:forEach>
	</section>
</body>
</html>