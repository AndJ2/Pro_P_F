package spring.Pro_P_F.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/main")
    public String main(Model model) {
        return "/index";
    }

    @GetMapping("/portfolio")
    public String port(Model model) {
        return "/portfolio";
    }

    @GetMapping("/company-mypage")
    public String company(Model model) {
        return "/company-mypage";
    }

    @GetMapping("/upload")
    public String upload(Model model) {
        return "/upload";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        return "/contact";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "/login";
    }
}
