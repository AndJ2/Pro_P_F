package spring.Pro_P_F.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Posting {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long p_seq;

    @ManyToOne
    @JoinColumn(name = "m_id")
    private Member member;

    private String p_title;
    private String p_content;
    private int p_like;
    private String p_img;
    private int p_view;

    @LastModifiedDate
    private LocalDate p_date;
    // 스크랩 컬럼, 테이블 추가 필요

}
