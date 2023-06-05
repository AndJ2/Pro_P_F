package spring.Pro_P_F.Controller.PageMove;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/wait2")
    public String wait2(Model model) {
        return "X/about";
    }

}
