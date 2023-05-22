package spring.Pro_P_F.Controller.PageMove;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping("/")
    public String main(Model model) {
        return "home/index";
    }

    @GetMapping("/join")
    public String contact(Model model) {
        return "home/join";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "home/login";
    }

    @GetMapping("/wait2")
    public String wait2(Model model) {
        return "X/about";
    }

}
