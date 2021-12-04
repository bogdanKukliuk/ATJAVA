package practice.selenium.page_factory.po;


import org.openqa.selenium.support.PageFactory;
import practice.selenium.parallel_run.BrowserFactory;

public abstract class BasicPO {

    public BasicPO() {
//        PageFactory.initElements(new CustomDecorator(BrowserFactory.getDriver()),this);
    }

    boolean isLogin(){ return true; };
    boolean isUserAdd(){ return true; };
    boolean isGroupAdd(){ return true; };
}
