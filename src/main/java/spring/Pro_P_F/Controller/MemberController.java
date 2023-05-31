package spring.Pro_P_F.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.Pro_P_F.Controller.Form.CommunityForm;
import spring.Pro_P_F.Controller.Form.MemberForm;
import spring.Pro_P_F.domain.Community;
import spring.Pro_P_F.domain.Member;
import spring.Pro_P_F.service.MemberService;

import java.time.LocalDate;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

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
}
