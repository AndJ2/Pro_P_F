package spring.Pro_P_F.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.Pro_P_F.Controller.Form.PostForm;
import spring.Pro_P_F.domain.Member;
import spring.Pro_P_F.domain.Posting;
import spring.Pro_P_F.service.MemberService;
import spring.Pro_P_F.service.PostingService;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
public class PostingController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PostingService postingService;

    // 포스팅 등록 페이지 로드
    @GetMapping("/upload")
    public String upload(Model model) {
        model.addAttribute("postForm", new PostForm());

        return "my/upload";
    }

    // 포스팅 업로드
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
        return "redirect:/post";
    }

    // 포스팅 목록 페이지
    @GetMapping("/post")
    public String list(Model model) {
        List<Posting> postings = postingService.findAll();
        model.addAttribute("postings", postings);
        return "my/posting";
    }

    // 클릭한 포스팅 상세페이지 로드
    @GetMapping("/post_de")
    public String showPostDetails(@RequestParam("id") Long postId, Model model) {
        List<Posting> postings = postingService.findByid(postId);
        model.addAttribute("postings", postings);
        return "my/posting_detail";
    }

    // 클릭한 포스팅 아이디 마이페이지 로드
    @GetMapping("/profile")
    public String userProfile(@RequestParam("memberId") String memberId, Model model) {
        // 여기에서 사용자의 프로필 정보를 가져와서 모델에 추가하는 로직을 구현합니다.
        // 예를 들어, 사용자 정보를 데이터베이스에서 조회하고 모델에 추가합니다.
        model.addAttribute("memberId", memberId);
        System.out.println("이걸 지났다네~~" + memberId);

        List<Posting> postings = postingService.findBym_id(memberId);
        model.addAttribute("postings", postings);
        return "my/mypage_other"; // 사용자 프로필 페이지로 이동하는 뷰 이름을 반환합니다.
    }

    @GetMapping("/series_add")
    public String add_series(){
        return "my/series_add";
    }

}



