package practice.selenium.page_factory.bo;

import org.openqa.selenium.WebDriver;
import practice.hibernate.model.Student;
import practice.selenium.page_factory.po.LoginPO;

import static practice.hibernate.HibernateTest.getStudent;

public class LoginBO {
    WebDriver driver;

    public boolean TestLogin(Integer studentId){
        LoginPO loginPO = new LoginPO();
        Student student = getStudent(studentId);
        return loginPO.isLogin()
                &&
                loginPO.Login(student.getMyEmail(),student.getMyPassword());
    }
    public boolean TestUser(Integer studentId, String user){
        LoginPO loginPO = new LoginPO();
        Student student = getStudent(studentId);
        return loginPO.AddUser(student.getMyEmail(),student.getMyPassword(), user);
    }
    public boolean TestGroup(Integer studentId, String group){
        LoginPO loginPO = new LoginPO();
        Student student = getStudent(studentId);
        return loginPO.AddGroup(student.getMyEmail(),student.getMyPassword(), group);
    }
    public boolean TestSend(Integer studentId, String massager, String text){
        LoginPO loginPO = new LoginPO();
        Student student = getStudent(studentId);
        return loginPO.sendTest(student.getMyEmail(),student.getMyPassword(), massager, text);
    }
    public boolean TestPost(Integer studentId, String user, String text){
        LoginPO loginPO = new LoginPO();
        Student student = getStudent(studentId);
        return loginPO.postTest(student.getMyEmail(),student.getMyPassword(), user, text);
    }

}
