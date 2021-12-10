package practice.selenium.page_factory.po;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import practice.selenium.parallel_run.BrowserFactory;

import java.util.Date;


public class LoginPO{


    private WebDriver driver = BrowserFactory.getDriver();
    private WebElement element;
    private LoginFactory loginFactory = PageFactory.initElements(driver, LoginFactory.class);

    public boolean Login(String login,String pass){

        loginFactory.FullLogin(login,pass);

        element = waitForMeVisible( 8000,"//input[@type=\'search\']");
        return element.isDisplayed();
    }
//    @Override
    public boolean isLogin() {
        loginFactory.open();

        return driver.findElement(By.name("email")).isDisplayed();
    }

    public boolean AddUser(String login,String pass, String user){

        loginFactory.open();
        loginFactory.FullLogin(login,pass);

        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.facebook.com/" + user );

        System.out.println(driver.getCurrentUrl());
        element = waitForMeVisible( 8000,"//div[@role=\'button\' and @aria-label=\'Add Friend\']");
        element.click();

        element = waitForMeVisible( 8000,"//div[@role=\'button\' and @aria-label=\'Cancel Request\']");
        return element.isDisplayed();
    }

    public boolean AddGroup(String login,String pass, String group){
        loginFactory.open();
        loginFactory.FullLogin(login,pass);


        System.out.println(driver.getCurrentUrl());
        driver.navigate().to("https://www.facebook.com/groups/" + group );

        element = waitForMeVisible( 8000,"//div[@role=\'button\' and @aria-label=\'Join group\']");
        element.click();

        element = waitForMeVisible( 8000,"//div[@role=\'button\' and @aria-label=\'Joined\']");
        return element.isDisplayed();
    }

    public boolean sendTest(String login,String pass, String massager, String text){
        loginFactory.open();
        loginFactory.FullLogin(login,pass);

        element = waitForMeVisible( 8000,"//a[@role='link' and @href='/messages/t/" + massager + "/']");
        element.click();

        element = waitForMeVisible( 8000,"//div[@role='textbox' and @aria-label='Message']");
        element.sendKeys(text);
        element.sendKeys(Keys.ENTER);
        element = waitForMeVisible( 8000,"//div[normalize-space()=\'" + text + "\']");
        return element.isDisplayed();
    }

    public boolean postTest(String login,String pass, String user, String text){
        loginFactory.open();
        loginFactory.FullLogin(login,pass);

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
