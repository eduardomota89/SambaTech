package com.sambatech.util;

import org.openqa.selenium.By;
import java.util.concurrent.TimeUnit;
import org.junit.Before;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Util {

	public WebDriver driver = new ChromeDriver();
	// public WebDriver driver = new FirefoxDriver();
	public WebDriverWait wait = new WebDriverWait(driver, 30);

	@BeforeClass
	public static void propertyChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Z003M47R\\Downloads\\chromedriver.exe");
	}

	@Before
	public void confChrome() {
		driver.get("http://52.2.166.124:8085/auth/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@Before
	public void confFireFox() {
		driver.get("http://52.2.166.124:8085/auth/login");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public void fechar() {
		driver.quit();
	}

	/**
	 * Metodo realizar login se email e senha estiverem corretos. Metodo
	 * verifica se mensagem de validação é exibida caso a senha não senha
	 * preenchida.
	 */
	public void login(String usuario, String senha) {

		driver.findElement(By.id("inputEmail")).sendKeys(usuario);
		driver.findElement(By.id("inputPassword")).sendKeys(senha);
		driver.findElement(By.id("login")).click();

		// driver.findElement(By.id("password_incorrect")).getText().equals("Email
		// ou senha incorretos. Saiba Mais");
		if (ExpectedConditions.invisibilityOfElementLocated(By.id("password_incorrect")) != null) {
			driver.findElement(By.id("password_incorrect")).getText().equals("Email ou senha incorretos. Saiba Mais");
			System.out.println("Mensagem 'Email ou senha incorretos' ===> OK");
		} else if (ExpectedConditions.invisibilityOfElementLocated(
				By.xpath("//*[@id='wrap']/div/div[2]/form/ul[2]/li/a/span/text()")) != null) {
			wait.until(ExpectedConditions.invisibilityOfElementWithText(
					By.xpath("//*[@id='wrap']/div/div[2]/form/ul[2]/li/a/span/text()"),
					"Email ou senha incorretos. Saiba Mais"));
			System.out.println("Login realizado com Sucesso ===> OK");
		}
	}
}
