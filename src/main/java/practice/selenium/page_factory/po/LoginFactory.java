package practice.selenium.page_factory.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

//signUpPage
public class LoginFactory {
    WebDriver driver;
    private WebElement element;

    public LoginFactory(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get("https://www.facebook.com");
    }

    public void FullLogin(String login, String pass){
        element = driver.findElement(By.name("email"));
        element.clear();
        element.sendKeys(login);

        element = driver.findElement(By.name("pass"));
        element.clear();
        element.sendKeys(pass);

        element = driver.findElement(By.name("login"));
        element.click();
    }
}
