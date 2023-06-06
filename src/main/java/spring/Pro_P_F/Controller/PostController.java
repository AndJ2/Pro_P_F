package spring.Pro_P_F.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.Pro_P_F.Controller.Form.CommunityForm;
import spring.Pro_P_F.Controller.Form.PostForm;
import spring.Pro_P_F.domain.Community;
import spring.Pro_P_F.domain.Member;
import spring.Pro_P_F.domain.Posting;
import spring.Pro_P_F.service.MemberService;
import spring.Pro_P_F.service.PostingService;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
public class PostController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PostingService postingService;

    @GetMapping("/upload")
    public String upload(Model model) {
        model.addAttribute("postForm", new PostForm());

        return "my/upload";
    }

    @PostMapping("/upload")
    public String postForm(PostForm form, HttpSession session) {

        String mId = (String) session.getAttribute("m_id");
        System.out.println("mId = " + mId);

        Member member = memberService.findOne(mId);

        Posting posting = new Posting();

        posting.setMember(member);
        posting.setP_title(form.getTitle());
        posting.setP_content(form.getContent());
        posting.setP_date(LocalDate.now());

        postingService.save(posting);
        return "my/posting";
    }

    @GetMapping("/post")
    public String list(Model model) {
        List<Posting> postings = postingService.findAll();
        model.addAttribute("postings", postings);
        return "my/posting";
    }
}



