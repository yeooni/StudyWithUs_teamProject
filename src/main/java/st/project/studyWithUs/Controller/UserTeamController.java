package st.project.studyWithUs.Controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import st.project.studyWithUs.service.teamService.TeamService;
import st.project.studyWithUs.service.userTeamService.UserTeamService;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserTeamController {


    private final UserTeamService userStudyTeamService;
    private final TeamService teamService;

    @ResponseBody
    @GetMapping("/dropStudyTeam")
    public boolean dropTeam(@RequestParam Long tId){
        userStudyTeamService.dropStudyTeam(tId, 1L);
        teamService.decreaseCurrentCount(tId);
        return true;
    }
}
