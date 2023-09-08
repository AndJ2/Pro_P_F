package spring.Pro_P_F.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import spring.Pro_P_F.Controller.Form.CommunityForm;
import spring.Pro_P_F.domain.Community;
import spring.Pro_P_F.domain.Member;
import spring.Pro_P_F.domain.Posting;
import spring.Pro_P_F.service.CommunityService;
import spring.Pro_P_F.service.MemberService;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;

@Controller
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @Autowired
    private MemberService memberService;

    // 커뮤니티 게시물 등록 페이지 로드
    @GetMapping("/com_add")
    public String com_add(Model model, HttpSession session) {
        String mId = (String) session.getAttribute("m_id");
        System.out.println("mId = " + mId);

        model.addAttribute("communityForm", new CommunityForm());
        return "my/com_add";
    }

    // 커뮤니티 게시물 등록
    @PostMapping("/com_add")
    public String communityForm(CommunityForm form, HttpSession session) {


        String mId = (String) session.getAttribute("m_id");

        Member member = memberService.findOne(mId);

        Community community = new Community();

        community.setMember(member);
        community.setC_title(form.getTitle());
        community.setC_content(form.getContent());
        community.setC_category(form.getCategory());
        community.setC_date(LocalDate.now());

        communityService.save(community);
        return "redirect:/com";
    }

    // 커뮤니티 게시물 목록
    @GetMapping("/com")
    public String list(Model model) {
        List<Community> communities = communityService.findAllComm();
        model.addAttribute("communities", communities);
        return "my/community";
    }

    @GetMapping("/com_de")
    public String showComDetails(@RequestParam("id") Long comId, Model model) {
        List<Community> communities = communityService.findByid(comId);
        model.addAttribute("communities", communities);

        return "my/community_detail";
    }


//    @GetMapping("/post_de")
//    public String showPostDetails(@RequestParam("id") Long postId, Model model) {
//        List<Posting> postings = postingService.findByid(postId);
//        model.addAttribute("postings", postings);
//        return "my/posting_detail";
//    }



}
