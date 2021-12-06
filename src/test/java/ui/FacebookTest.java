package ui;

import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import practice.selenium.page_factory.bo.LoginBO;
import practice.selenium.parallel_run.BrowserFactory;


@Test
public class FacebookTest {
    @DataProvider(parallel = true)
    public static Object[][] browserDataProvider() {
        return new Object[][]{
//                {"edge"},
                {"chrome"}
        };
    }

    public void loginTest() {
        BrowserFactory.initDriver("chrome");
        LoginBO loginBO = new LoginBO();
        Assert.assertTrue(loginBO.TestLogin(1),"Failed!");

    }
    public void userTest() {
        BrowserFactory.initDriver("chrome");
        LoginBO loginBO = new LoginBO();
        Assert.assertTrue(loginBO.TestUser(1, "bakun.mykola"),"Failed!");

    }
    public void groupTest() {
        BrowserFactory.initDriver("chrome");
        LoginBO loginBO = new LoginBO();
        Assert.assertTrue(loginBO.TestGroup(1, "393403465087588"),"Failed!");

    }
    public void sendTest() {
        BrowserFactory.initDriver("chrome");
        LoginBO loginBO = new LoginBO();
        Assert.assertTrue(loginBO.TestSend(1, "100020006073172","ABOBA"),"Failed!");

    }
    @Severity(SeverityLevel.CRITICAL)
    public void likesTest() {
        BrowserFactory.initDriver("chrome");
        LoginBO loginBO = new LoginBO();
        Assert.assertTrue(loginBO.TestPost(1,"bakun.mykola", "Cool!"),"Failed!");
    }
}
