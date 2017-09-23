<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
Bem vindo ao nosso gerenciador de empresas!<br/>

<c:if test="${not empty usuarioLogado}"  >
	Usuario logado ${usuarioLogado.email}
</c:if>
<br />
<a href="/gerenciador/executa?tarefa=BuscaEmpresa">listagem</a>
<br />
<form action="executa" method="POST" >
	<input type="hidden" name="tarefa" value="NovaEmpresa" />
	Nome <input type="text" name="nome"><br/>
	<input type="submit" value="criar"/>
</form>
<form action="executa" method="POST">
	<input type="hidden" name="tarefa" value="Login" />
	Email:
	<input type="email" name="email"/>
	Senha:
	<input type="password" name="senha" />
	<input type="submit" value="login" />
</form>
<form action="executa" method="POST">
	<input type="hidden" name="tarefa" value="Logout" />
	<input type="submit" value="logout" />
</form>
</body>
</html>