package spring.Pro_P_F.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    //고정 id값 받는 포스팅 디테일 파일
//    @GetMapping("/post_de")
//    public String Com_detail(Model model) {
//        List<Posting> postings = postingService.findByid(1L);
//        model.addAttribute("postings", postings);
//        return "my/posting_detail";
//    }

    @GetMapping("/post_de")
    public String showPostDetails(@RequestParam("id") Long postId, Model model) {
        List<Posting> postings = postingService.findByid(postId);
        model.addAttribute("postings", postings);
        // postId 변수를 이용하여 해당 게시물의 세부 내용을 처리하는 로직을 작성합니다.
        // ...
        return "my/posting_detail";
    }

}



