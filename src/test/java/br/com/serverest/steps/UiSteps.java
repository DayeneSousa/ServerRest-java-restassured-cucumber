package br.com.serverest.steps;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class UiSteps {
    private WebDriver driver;

    @Dado("que acesso a página de login do ServeRest")
    public void acessoAPaginaDeLogin() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new", "--no-sandbox", "--disable-dev-shm-usage");
        driver = new ChromeDriver(options);
        driver.get(System.getProperty("ui.url", "https://front.serverest.dev") + "/login");
    }

    @Entao("o formulário de login está disponível")
    public void formularioDeLoginDisponivel() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='email']"))).isDisplayed());
        assertTrue(wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid='senha']"))).isDisplayed());
        assertTrue(wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[data-testid='entrar']"))).isDisplayed());
    }

    @After
    public void fecharNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }
}
