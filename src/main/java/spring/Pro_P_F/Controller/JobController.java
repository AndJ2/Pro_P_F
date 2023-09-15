package spring.Pro_P_F.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import spring.Pro_P_F.Controller.Form.CommunityForm;
import spring.Pro_P_F.domain.Community;
import spring.Pro_P_F.domain.Company;
import spring.Pro_P_F.domain.Job;
import spring.Pro_P_F.domain.Member;
import spring.Pro_P_F.service.CompanyMemService;
import spring.Pro_P_F.service.JobService;

import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class JobController {

    @Autowired
    private JobService jobService;

    @Autowired
    private CompanyMemService companyMemService;

    // 공고 등록 페이지 로드
    @GetMapping("/em_add")
    public String employ_add(Model model, HttpSession session) {
        String mId = (String) session.getAttribute("m_id");
        System.out.println("mId = " + mId);


        model.addAttribute("job", new Job());
        return "company/employ_add";
    }

    // 커뮤니티 게시물 등록
    @PostMapping("/em_add")
    public String employ_add2(Job job1, HttpSession session) {
        try {
            String mId = (String) session.getAttribute("m_id");
            Company company = companyMemService.findMemByCyId(mId);

            Job job = new Job();

            job.setTitle(job1.getTitle());
            job.setStart_date(job1.getStart_date());
            job.setEnd_date(job1.getEnd_date());
            job.setPerson(job1.getPerson());
            job.setArea(job1.getArea());
            job.setContent(job1.getContent());
            job.setWork(job1.getWork());
            job.setEmploy(job1.getEmploy());
            job.setCompany(company);

            jobService.saveJob(job);

            return "redirect:/employ";
        } catch (Exception e) {
            // 예외 처리: 예외를 적절히 처리하고 에러 메시지를 로깅하거나 사용자에게 알림을 보낼 수 있음
            e.printStackTrace(); // 예외 정보를 콘솔에 출력
            // 사용자에게 적절한 에러 페이지 또는 메시지를 반환하거나 리다이렉션할 수 있음
            return "errorPage"; // 예시로 "errorPage"로 반환
        }
    }


}
