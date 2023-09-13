package spring.Pro_P_F.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter @Setter
public class Job {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long j_seq;

    private String title;
    private LocalDate start_date;
    private LocalDate end_date;
    private int person;
    private String target;
    private String area;
    private String content;

    // 모집직무
    @Enumerated(EnumType.STRING)
    private WorkType work;


    // 채용형태
    @Enumerated(EnumType.STRING)
    private EmployType employ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cy_id")
    private Company company;
}
