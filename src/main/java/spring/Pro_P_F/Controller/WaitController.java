package spring.Pro_P_F.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WaitController {

    @GetMapping("/community")
    public String Com(Model model) {
        return "mymade/community";
    }

    @GetMapping("/scrap")
    public String Scrap(Model model) {
        return "mymade/scrap";
    }

    @GetMapping("/employ")
    public String Employ(Model model) {
        return "mymade/employ";
    }

    @GetMapping("/posting")
    public String Posting(Model model) {
        return "mymade/posting";
    }

    @GetMapping("/com_detail")
    public String Com_detail(Model model) {
        return "mymade/community_detail";
    }

    @GetMapping("/employ_detail")
    public String Employ_detail(Model model) {
        return "mymade/employ_detail";
    }

    @GetMapping("/pd")
    public String pd(Model model) {
        return "mymade/com_add";
    }
}
