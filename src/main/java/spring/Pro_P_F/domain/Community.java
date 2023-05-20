package spring.Pro_P_F.domain;

import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Community {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long c_seq;

    @ManyToOne
    @JoinColumn(name = "m_id")
    private Member member;

    private String c_title;
    private int c_like;
    private String c_category;

    @LastModifiedDate
    private LocalDate c_date;
}
