package st.project.studyWithUs.Controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import st.project.studyWithUs.domain.PointInfo;
import st.project.studyWithUs.domain.RefundUserAccount;
import st.project.studyWithUs.service.pointInfo.PointInfoService;
import st.project.studyWithUs.service.refundUserAccountService.RefundUserAccountService;
import st.project.studyWithUs.service.userService.UserService;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class AdministratorController {



    private final PointInfoService pointInfoService;
    private final RefundUserAccountService refundUserAccountService;
    private final UserService userService;

    @GetMapping("/adminPage")
    public String myPage(Model model){

        PointInfo pointInfo = pointInfoService.find(1L);
        List<RefundUserAccount> refundUserAccountList = refundUserAccountService.findRefundAccount();
        model.addAttribute("administrator", pointInfo);
        model.addAttribute("refundsList", refundUserAccountList);

        return "adminPage";
    }

    @GetMapping("/refunds")
    public String refunds(){
        return "refunds";
    }


    @PostMapping("/refunds")
    @ResponseBody
    public String refundsCheck(@RequestParam String name,
                               @RequestParam String account,
                               @RequestParam String bank,
                               @RequestParam Long point){

        //계좌번호 존재하는지 일치여부


        //환급받은 포인트 만큼 자신의 포인트 삭감
        if(userService.checkPoint(point, 1L)==false){
            return "포인트가 부족합니다.";
        }
        //관리자 페이지에서 환급 리스트 모아놓기

        RefundUserAccount refundUserAccount = new RefundUserAccount();
        refundUserAccount.setBankName(bank);
        refundUserAccount.setPoint(point);
        refundUserAccount.setUserName(name);
        refundUserAccount.setAccount(account);
        refundUserAccount.setUser(userService.find(1L));


        pointInfoService.addRefundUserAccount(refundUserAccount);


        return "환급요청이 완료되었습니다.";
    }

}
