package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page{

    private WebElement usernameField;
    private WebElement passwordField;
    private WebElement loginButton;
    private WebElement login;
    private WebElement password;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.usernameField = driver.findElement(By.name("username"));
        this.passwordField = driver.findElement(By.name("password"));
        this.loginButton = driver.findElement(By.xpath("//button[@type = 'submit']"));
        this.login = driver.findElement(new By.ByXPath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[1]"));
        this.password = driver.findElement(new By.ByXPath("/html/body/div/div[1]/div/div[1]/div/div[2]/div[2]/div/div/p[2]"));
    }

    public void fillUsername(String username) {
        fillField(usernameField, username);
    }

    public void fillPassword(String password) {
        fillField(passwordField, password);
    }

    public void login(){
        String username = getText(this.login);
        String password = getText(this.password);
        username = username.substring(username.lastIndexOf(":") + 2);
        password = password.substring(password.lastIndexOf(":") + 2);
        fillUsername(username);
        fillPassword(password);
        clickButton(loginButton);
    }
}
