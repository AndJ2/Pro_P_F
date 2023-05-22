package spring.Pro_P_F.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    private String m_id;

    private String m_pwd;

    private String m_name;

    @Column(unique = true)
    private String m_phone;

    private String m_email;

    private String m_git;

    public String getM_id() {
        return m_id;
    }

    public void setM_id(String m_id) {
        this.m_id = m_id;
    }

    public String getM_pwd() {
        return m_pwd;
    }

    public void setM_pwd(String m_pwd) {
        this.m_pwd = m_pwd;
    }

    public String getM_name() {
        return m_name;
    }

    public void setM_name(String m_name) {
        this.m_name = m_name;
    }

    public String getM_phone() {
        return m_phone;
    }

    public void setM_phone(String m_phone) {
        this.m_phone = m_phone;
    }

    public String getM_email() {
        return m_email;
    }

    public void setM_email(String m_email) {
        this.m_email = m_email;
    }

    public String getM_git() {
        return m_git;
    }

    public void setM_git(String m_git) {
        this.m_git = m_git;
    }
}
