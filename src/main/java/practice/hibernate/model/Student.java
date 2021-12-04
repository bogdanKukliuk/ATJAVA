package practice.hibernate.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "student")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String myEmail;
    private String myPassword;

    public Integer getId(){ return id;}
    public void setMyEmail(String myEmail) {
        this.myEmail = myEmail;
    }
    public void setMyPassword(String myPassword) {
        this.myPassword = myPassword;
    }
    public String getMyEmail() {
        return myEmail;
    }
    public String getMyPassword() {
        return myPassword;
    }

    @Override
    public String toString() {
        return "Studert {" +
                "email='" + myEmail + "\'," +
                "password='" + myPassword + "\' }";
    }
}
