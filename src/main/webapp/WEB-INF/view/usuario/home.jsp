<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

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
			<li><a href='<c:url value="/usuario/editar"/>'><button>Editar
						Cadastro</button></a></li>
			<li><a href='<c:url value="/boleto/${sessionScope.conta.id}"/>'><button>Gerar
						Boleto</button></a></li>
		</ul>
	</section>

</body>
</html>