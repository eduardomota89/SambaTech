package com.sambatech.Login;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.sambatech.util.Util;

public class Login extends Util {

	@Test
	public void main() {

		propertyChrome();
		confChrome();
		
		preencheLogin("avaliacao_qa_samba@sambatech.com.br", "");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password_incorrect")));
		verificaTexto("password_incorrect", "Email ou senha incorretos. Saiba Mais");

		preencheLogin("", "12345678");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password_incorrect")));
		verificaTexto("password_incorrect", "Email ou senha incorretos. Saiba Mais");

		preencheLogin("avaliacao_qa_samba@sambatech.com.br", "123456789");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password_incorrect")));
		verificaTexto("password_incorrect", "Email ou senha incorretos. Saiba Mais");

		preencheLogin("avaliacao_qa_samba@sambatech.com.br", "12345678");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("navbar-client-name")));
		verificaTexto("navbar-client-name", "Avaliação QA");
		fechar();
	}
}
