package practice.selenium.page_factory.bo;

import practice.hibernate.model.Student;
import practice.selenium.page_factory.po.LoginPO;

import static practice.hibernate.HibernateTest.getStudent;

public class LoginBO {

    public boolean TestLogin(Integer studentId){
        LoginPO loginPO = new LoginPO();
        Student student = getStudent(studentId);
        return loginPO.isLogin()
                &&
                loginPO.Login(student.getMyEmail(),student.getMyPassword());
    }
    public void TestUser(Integer studentId, String user){
        LoginPO loginPO = new LoginPO();
        Student student = getStudent(studentId);
        loginPO.AddUser(student.getMyEmail(),student.getMyPassword(), user);
    }
    public void TestGroup(Integer studentId, String group){
        LoginPO loginPO = new LoginPO();
        Student student = getStudent(studentId);
        loginPO.AddGroup(student.getMyEmail(),student.getMyPassword(), group);
    }
}
