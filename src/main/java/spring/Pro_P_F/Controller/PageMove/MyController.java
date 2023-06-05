package spring.Pro_P_F.Controller.PageMove;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.Pro_P_F.Controller.Form.MemberForm;
import spring.Pro_P_F.domain.Member;
import spring.Pro_P_F.service.MemberService;

@Controller
public class MyController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/scrap")
    public String Scrap(Model model) {
        return "my/scrap";
    }

    @GetMapping("/post")
    public String Posting(Model model) {
        return "my/posting";
    }

    @GetMapping("/com_de")
    public String Com_detail(Model model) {
        return "my/community_detail";
    }

    @GetMapping("/pofo")
    public String port(Model model) {
        return "my/my_mypage";
    }



    // test 회원가입 성공 코드
    @PostMapping("/test")
    public String testForm(MemberForm form) {
        Member member = new Member();
        member.setM_id(form.getM_id());
        member.setM_pwd(form.getM_pwd());
        member.setM_phone(form.getM_phone());
        member.setM_name(form.getM_name());
        member.setM_git(form.getM_git());
        member.setM_email(form.getM_email());

        memberService.join(member);
        return "redirect:/";
    }


    @GetMapping("/test")
    public String test(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "X/services";
    }
}
