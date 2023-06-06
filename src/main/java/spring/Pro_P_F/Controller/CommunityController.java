package spring.Pro_P_F.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.Pro_P_F.Controller.Form.CommunityForm;
import spring.Pro_P_F.domain.Community;
import spring.Pro_P_F.domain.Member;
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

    @GetMapping("/com_add")
    public String com_add(Model model, HttpSession session) {
        String mId = (String) session.getAttribute("m_id");
        System.out.println("이걸 지났다네~~" + mId);

        model.addAttribute("communityForm", new CommunityForm());
        return "my/com_add";
    }
    
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

    @GetMapping("/com")
    public String list(Model model) {
        List<Community> communities = communityService.findAllComm();
        model.addAttribute("communities", communities);
        return "my/community";
    }
    
}
