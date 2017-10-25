<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
</head>
<body>
	<c:import url="../header.jsp"></c:import>

	<section>
		<ul>
			<li><a href='<c:url value="administrador/usuarios"/>'><button>Lista
					Usuarios</button></a></li>
			<li><a href='<c:url value="administrador/pessoas"/>'><button>Lista
					Pessoas</button></a></li>
		</ul>
	</section>
	
</body>
</html>