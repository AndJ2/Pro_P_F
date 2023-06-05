package spring.Pro_P_F.Controller.Form;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.LastModifiedDate;
import spring.Pro_P_F.domain.Member;

import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter
public class PostForm {

    private String title;
    private String content;
    private LocalDate date;
}
