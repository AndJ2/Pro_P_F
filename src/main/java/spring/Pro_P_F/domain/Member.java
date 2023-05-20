package spring.Pro_P_F.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Member {

    @Id
    private String id;

    private String m_pwd;

    private String m_name;

    @Column(unique = true)
    private String m_phone;

    @Column(unique = true)
    private String m_email;

    @Column(unique = true)
    private String m_git;
}
