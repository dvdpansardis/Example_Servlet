
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<body>
	Busca por empresas:
	<ul>
		<c:forEach var="empresa" items="${empresas}">
			<li>${empresa.nome } : ${empresa.id }</li>
		</c:forEach>
	</ul>
	<br/>
	<a href="/gerenciador">voltar</a>
</body>
</html>