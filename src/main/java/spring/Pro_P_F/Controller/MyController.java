package spring.Pro_P_F.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyController {

    @GetMapping("/com")
    public String Com(Model model) {
        return "my/community";
    }

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

    @GetMapping("/com_add")
    public String pd(Model model) {
        return "my/com_add";
    }

    @GetMapping("/pofo")
    public String port(Model model) {
        return "my/my_mypage";
    }

    @GetMapping("/upload")
    public String upload(Model model) {
        return "my/upload";
    }
}
