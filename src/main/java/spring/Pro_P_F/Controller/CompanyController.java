package spring.Pro_P_F.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompanyController {
    @GetMapping("/employ")
    public String Employ(Model model) {
        return "company/employ";
    }

    @GetMapping("/em_de")
    public String Employ_detail(Model model) {
        return "company/employ_detail";
    }

    @GetMapping("/company_my")
    public String company(Model model) {
        return "company/company-mypage";
    }
}
