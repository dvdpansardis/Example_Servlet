package br.com.alura.gerenciador.web;

import java.util.Arrays;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;

public class Cookies {

	private Cookie[] cookies;

	public Cookies(Cookie[] cookies) {
		this.cookies = cookies;
	}

	public Cookie buscaUsuarioLogado() {
		return Arrays.asList(cookies).stream().filter(c -> c.getName().equals("usuario.logado")).collect(Collectors.toList()).get(0);
	}

}
