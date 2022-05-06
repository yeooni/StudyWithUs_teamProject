package st.project.studyWithUs.Controller;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import st.project.studyWithUs.domain.Team;
import st.project.studyWithUs.domain.UserTeam;
import st.project.studyWithUs.service.teamService.TeamService;
import st.project.studyWithUs.service.userTeamService.UserTeamService;
import st.project.studyWithUs.vo.TeamVO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;
    private final UserTeamService userTeamService;

    @ResponseBody
    @GetMapping("/findAllTeams")
    public List<TeamVO> teams (){

        List<Team> teams = teamService.findAll();
        List<UserTeam> userStudyTeams = userTeamService.findAll();
        List<TeamVO> teamVO =  new ArrayList<>();

        for(Team t : teams){
            boolean check =true;
            for(UserTeam ut : userStudyTeams){
                if(ut.getTeam().getTID()==t.getTID()||t.getCurrentCount()==t.getHeadCount()){
                    //로그인 유저가 속해있거나, 스터디 인원이 꽉 차있으면.
                    check=false;
                    break;
                }
            }


            if(check==true){
                TeamVO tVO = new TeamVO();
                //   tVO.setTID(t.getTId());
                tVO.setTtID(t.getTID());
                tVO.setTeamName(t.getTeamName());
                tVO.setTeamDesc(t.getTeamDesc());
                tVO.setDepositPoint(t.getDepositPoint());
                tVO.setHeadCount(t.getHeadCount());
                tVO.setCurrentCount(t.getCurrentCount());
                teamVO.add(tVO);
            }
        }

        return teamVO;
    }


}
