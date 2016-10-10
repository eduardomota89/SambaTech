package com.sambatech.Login;

import org.junit.Test;
import com.sambatech.util.Util;

public class Login extends Util {

	@Test
	public void successLogin() {

		propertyChrome();
		confChrome();
		preencheLogin("avaliacao_qa_samba@sambatech.com.br", "12345678");
		verificaTexto("navbar-client-name", "Avaliação QA");
		fechar();
	}

	@Test
	public void alterarSenha() {

		propertyChrome();
		confChrome();
		preencheLogin("", "");
		verificaTexto("password_incorrect", "Email ou senha incorretos. Saiba Mais");
		fechar();
	}

	@Test
	public void senhaInvalido() {

		propertyChrome();
		confChrome();
		preencheLogin("avaliacao_qa_samba@sambatech.com.br", "1234567");
		verificaTexto("password_incorrect", "Email ou senha incorretos. Saiba Mais");
		fechar();
	}

	@Test
	public void emailInvalido() {

		propertyChrome();
		confChrome();
		preencheLogin("eduardomota.sais@gmail.com", "12345678");
		verificaTexto("password_incorrect", "Email ou senha incorretos. Saiba Mais");
		fechar();
	}
}
