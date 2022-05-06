package st.project.studyWithUs.Controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import st.project.studyWithUs.domain.Team;
import st.project.studyWithUs.domain.User;
import st.project.studyWithUs.domain.UserTeam;
import st.project.studyWithUs.service.pointInfo.PointInfoService;
import st.project.studyWithUs.service.teamService.TeamService;
import st.project.studyWithUs.service.userService.UserService;
import st.project.studyWithUs.service.userTeamService.UserTeamService;
import st.project.studyWithUs.vo.TeamVO;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final PointInfoService pointInfoService;
    private final UserTeamService userTeamService;
    private final TeamService teamService;

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/myPage")
    public String myPage(Model model){
        User user = userService.find(1L);
        model.addAttribute("loginUser", user);
        return "myPage";

    }

    @GetMapping("/chargePoint")
    public String chargePoint(){
        return "chargePoint";
    }


    @ResponseBody
    @GetMapping("/deposit")
    public void deposit(Long point){
        userService.updatePoint(point, 1L);
        pointInfoService.deposit(point, 1L );
    }


    //포인트 충전 로직
    @ResponseBody
    @GetMapping("/studyDeposit")
    public boolean studyDeposit( @RequestParam Long tId , @RequestParam Long point){


        if(userService.checkPoint(point, 1L)==true){ //현재 유저가 들고있는 포인트로 참여할 수 있다면,
            teamService.increaseData(tId, point); //팀의 현재 인원 및 보증금 올리기.

            UserTeam userTeam = new UserTeam();
            userTeam.setTeam(teamService.findBytID(tId));
            userTeam.setUser(userService.find(1L));
            userTeamService.save(userTeam);
            return true;
        }
        return false;
    }

    @ResponseBody
    @GetMapping("/findMyTeams")
    public List<TeamVO> findMyTeams(){

        List <Team> myTeams =  teamService.findMyTeam(1L);
        List<TeamVO> teamVO =  new ArrayList<>();
        for(Team t : myTeams){
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
        return teamVO;
    }
}
