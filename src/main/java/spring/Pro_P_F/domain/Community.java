package spring.Pro_P_F.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Community {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long c_seq;

    @ManyToOne
    @JoinColumn(name = "m_id")
    private Member member;

    private String c_category;
    private String c_title;
    private String c_content;
    private int c_like;


    @LastModifiedDate
    private LocalDate c_date;


}
