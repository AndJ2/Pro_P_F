package spring.Pro_P_F.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import spring.Pro_P_F.Controller.Form.CommunityForm;
import spring.Pro_P_F.Controller.Form.MemberForm;
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
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private PostingService postingService;

    @GetMapping("/join")
    public String join(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "home/join";
    }

    @PostMapping("/join")
    public String memberForm(MemberForm form) {
        Member member = new Member();

        member.setM_id(form.getM_id());
        member.setM_pwd(form.getM_pwd());
        member.setM_name(form.getM_name());
        member.setM_phone(form.getM_phone());
        member.setM_email(form.getM_email());
        member.setM_git(form.getM_git());

        memberService.join(member);
        return "home/login";
    }

    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "home/login";
    }

    @PostMapping("/login")
    public String loginId(MemberForm form, HttpSession session) {
        Member test = memberService.findOne(form.getM_id());
        if (test == null) {
            throw new IllegalArgumentException("존재하지 않는 id입니다");
        } else {
            String mId = form.getM_id();
            session.setAttribute("m_id", mId);

            return "redirect:/main";
        }
    }

    @GetMapping("/main")
    public String mainHome(HttpSession session, Model model) {
        String mId = (String) session.getAttribute("m_id");
        model.addAttribute("m_id", mId);
        System.out.println("이걸 지났다네~~" + mId);

        List<Posting> new_posting = postingService.new_posting();
        model.addAttribute("new_posting", new_posting);

        return "home/index";
    }

    @GetMapping("/comch")
    public String comch(Model model) {
        return "company/company_channel";
    }
}

