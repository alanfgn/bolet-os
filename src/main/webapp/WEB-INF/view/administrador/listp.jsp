<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista Pessoas</title>
</head>
<body>

	<c:import url="../header.jsp"></c:import>

	<section>
		<c:forEach items="${lista}" var="pess">

			<div>
				${pess.cpf} <a
					href='<c:url value="/administrador/pessoas/${pess.id}" />'><button>Transformar
						em adm</button></a>
			</div>

			<hr>
		</c:forEach>
	</section>

</body>
</html>