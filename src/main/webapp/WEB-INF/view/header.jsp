<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<header>
	<a href='<c:url value="/" />'><b>Bolet'os</b></a>
	<nav>
		<ul>
			<c:choose>
				<c:when test="${sessionScope.conta.id == null}">
					<li><a href='<c:url value="/cadastro" />'>
							<button>Cadastre-se</button>
					</a></li>
					<li><a href='<c:url value="/login" />'>
							<button>Login</button>
					</a></li>
				</c:when>
				<c:when test="${sessionScope.conta.id != null}">
					<li><a href='<c:url value="/home" />'>
							<button>Home</button>
					</a></li>
					<li><a href='<c:url value="/sair" />'>
							<button>Sair</button>
					</a></li>
				</c:when>
			</c:choose>

		</ul>
	</nav>
	<div>
		<span>${msg}</span>
	</div>
</header>