package practice.selenium.page_factory.po;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import practice.selenium.parallel_run.BrowserFactory;

public class HomePO extends BasicPO{

    @Override
    public boolean isLogin() {
        return BrowserFactory.getDriver().findElement(By.xpath("//a[href=\'/me/\']")).isDisplayed();
    }


    @Override
    public boolean isUserAdd() {
        return BrowserFactory.getDriver().findElement(By.xpath("//a[href=\'/me/\']")).isDisplayed();
    }
    @Override
    public boolean isGroupAdd() {
        return BrowserFactory.getDriver().findElement(By.xpath("//a[href=\'/me/\']")).isDisplayed();
    }
}
