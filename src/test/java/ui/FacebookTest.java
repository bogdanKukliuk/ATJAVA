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
//                {"chrome"},
//                {"chrome"},
                {"edge"}
        };
    }

    public void loginTest() {
        BrowserFactory.initDriver("edge");
        LoginBO loginBO = new LoginBO();
        loginBO.TestLogin(1);

    }
    public void userTest() {
        BrowserFactory.initDriver("edge");
        LoginBO loginBO = new LoginBO();
        loginBO.TestUser(1, "elena.smyk.3");

    }
    public void groupTest() {
        BrowserFactory.initDriver("edge");
        LoginBO loginBO = new LoginBO();
        loginBO.TestGroup(1, "393403465087588");

    }
//    @Severity(SeverityLevel.CRITICAL)
//    public void followToGroupTest() {
//        BrowserFactory.initDriver("edge");
//        LoginBO loginBO = new LoginBO();
//        Assert.assertTrue(loginBO.followToGroup(5),"Follow Failed!");
//
//    }
//    @Severity(SeverityLevel.CRITICAL)
//    public void sendMassageTest() {
//        BrowserFactory.initDriver("edge");
//        LoginBO loginBO = new LoginBO();
//        Assert.assertTrue(loginBO.sendMassage(5,"Hi bro, I am Bot."),"Send Massage Failed!");
//
//    }
//    @Severity(SeverityLevel.CRITICAL)
//    public void likeAndCommentPostTest() {
//        BrowserFactory.initDriver("chrome");
//        LoginBO loginBO = new LoginBO();
//        Assert.assertTrue(loginBO.likeAndCommentPost(5,"CO_Grl8tthLNs3eHU8Py8pO1wraJYfs5_cBUos0","Cool!"),"Like Or Comment Post Failed!");
//    }
}
