package practice.selenium.page_factory.po;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import practice.selenium.page_factory.bo.LoginBO;
import practice.selenium.parallel_run.BrowserFactory;

import java.util.Date;


public class LoginPO extends HomePO{

    private WebDriver driver = BrowserFactory.getDriver();
    private WebElement element;

    public boolean Login(String login,String pass){
        element = driver.findElement(By.name("email"));
        element.clear();
        element.sendKeys(login);

        element = driver.findElement(By.name("pass"));
        element.clear();
        element.sendKeys(pass);

        element = driver.findElement(By.name("login"));
        element.click();

        element = waitForMeVisible( 8000,"//input[@type=\'search\']");
        return element.isDisplayed();
    }
    @Override
    public boolean isLogin() {
        driver.get("https://www.facebook.com");
        return driver.findElement(By.name("email")).isDisplayed();
    }

    public boolean AddUser(String login,String pass, String user){
        driver.get("https://www.facebook.com");

        element = driver.findElement(By.name("email"));
        element.clear();
        element.sendKeys(login);

        element = driver.findElement(By.name("pass"));
        element.clear();
        element.sendKeys(pass);

        element = driver.findElement(By.name("login"));
        element.click();

        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.facebook.com/" + user );

        System.out.println(driver.getCurrentUrl());
        element = waitForMeVisible( 8000,"//div[@role=\'button\' and @aria-label=\'Add Friend\']");
        element.click();

        element = waitForMeVisible( 8000,"//div[@role=\'button\' and @aria-label=\'Cancel Request\']");
        return element.isDisplayed();
    }

    public boolean AddGroup(String login,String pass, String group){
        driver.get("https://www.facebook.com");

        element = driver.findElement(By.name("email"));
        element.clear();
        element.sendKeys(login);

        element = driver.findElement(By.name("pass"));
        element.clear();
        element.sendKeys(pass);

        element = driver.findElement(By.name("login"));
        element.click();

        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.facebook.com/groups/" + group );

        element = waitForMeVisible( 8000,"//div[@role=\'button\' and @aria-label=\'Join group\']");
        element.click();

        element = waitForMeVisible( 8000,"//div[@role=\'button\' and @aria-label=\'Joined\']");
        return element.isDisplayed();
    }

    public boolean sendTest(String login,String pass, String massager, String text){
        driver.get("https://www.facebook.com");

        element = driver.findElement(By.name("email"));
        element.clear();
        element.sendKeys(login);

        element = driver.findElement(By.name("pass"));
        element.clear();
        element.sendKeys(pass);

        element = driver.findElement(By.name("login"));
        element.click();

        element = waitForMeVisible( 8000,"//a[@role='link' and @href='/messages/t/" + massager + "/']");
        element.click();

        element = waitForMeVisible( 8000,"//div[@role='textbox' and @aria-label='Message']");
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
        element = waitForMeVisible( 8000,"//div[normalize-space()=\'" + text + "\']");
        return element.isDisplayed();
    }

    public boolean postTest(String login,String pass, String user, String text){
        driver.get("https://www.facebook.com");
        element = driver.findElement(By.name("email"));
        element.clear();
        element.sendKeys(login);
        element = driver.findElement(By.name("pass"));
        element.clear();
        element.sendKeys(pass);
        element = driver.findElement(By.name("login"));
        element.click();

        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.facebook.com/" + user );

        System.out.println(driver.getCurrentUrl());

        element = waitForMeVisible( 8000,"//*[@aria-label=\"Write a comment\"]");
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
        element = waitForMeVisible( 8000,"//div[normalize-space()=\'" + text + "\']");
        return element.isDisplayed();
    }





    public WebElement waitForMeVisible(int timeout_ms, String xpath){
        long start=new Date().getTime();
        long ping_time=500;
        while (new Date().getTime()<(start+timeout_ms)){
            try{
                return driver.findElement(By.xpath(xpath));}
            catch (Exception ignored){
                System.out.println("ping element");
            }
            try {
                Thread.sleep(ping_time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
