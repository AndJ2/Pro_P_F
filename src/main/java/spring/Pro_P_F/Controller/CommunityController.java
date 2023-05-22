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
import spring.Pro_P_F.service.CommunityService;
import spring.Pro_P_F.service.MemberService;

import java.time.LocalDate;

@Controller
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @GetMapping("/com_add")
    public String test(Model model) {
        model.addAttribute("communityForm", new CommunityForm());
        return "my/com_add";
    }
    
    @PostMapping("/com_add")
    public String communityForm(CommunityForm form) {
        Community community = new Community();
        
        community.setC_title(form.getTitle());
        community.setC_content(form.getContent());
        community.setC_category(form.getCategory());
        community.setC_date(LocalDate.now());

        communityService.save(community);
        return "redirect:/";
    }
    
}
