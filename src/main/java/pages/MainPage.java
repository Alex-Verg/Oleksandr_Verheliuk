package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class MainPage extends Page {

    private WebElement adminButton;

    public MainPage(WebDriver driver){
        super(driver);
        this.adminButton = driver.findElement(By.xpath("//a[@href  = '/web/index.php/admin/viewAdminModule']"));
    }

    public void goToJobTitles(){
        clickButton(adminButton);

        WebElement jobButton = driver.findElement(By.xpath("//span[text()  = 'Job ']"));
        clickButton(jobButton);

        WebElement jobTitlesButton = driver.findElement(By.xpath("//a[text()  = 'Job Titles']"));
        clickButton(jobTitlesButton);

        WebElement addButton = driver.findElement(By.xpath("//button[@class  = 'oxd-button oxd-button--medium oxd-button--secondary']"));
        clickButton(addButton);
    }

    public boolean isLogined(){
        try {
            WebElement loginedUserName = driver.findElement(By.className("oxd-userdropdown-name"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
