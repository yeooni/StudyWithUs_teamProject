package st.project.studyWithUs.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import st.project.studyWithUs.domain.UserTeam;
import st.project.studyWithUs.service.StudyingService;

@Controller
@RequiredArgsConstructor
public class StudyingController {

    private final StudyingService studyingService;

    @GetMapping("/studying")
    public String studying(){
        return "studying";
    }

    @PostMapping("/updateExist")
    @ResponseBody
    public void updateExist(@RequestParam("data") boolean data) {

        Long uID = 1l;
        Long tID = 1l;

        UserTeam ut = studyingService.findUserTeam(uID, tID);
        ut.setExist(data);
        studyingService.save(ut);
    }

}
