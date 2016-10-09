package com.sambatech.Login;

import org.junit.Test;
import com.sambatech.util.Util;

public class Login extends Util {

	@Test
	public void main() {

		propertyChrome();
		confChrome();
		login("avaliacao_qa_samba@sambatech.com.br", "");
		// login("", "12345678");
		login("avaliacao_qa_samba", "123456789");
		login("avaliacao_qa_samba@sambatech.com.br", "12345678");
		fechar();
	}
}
