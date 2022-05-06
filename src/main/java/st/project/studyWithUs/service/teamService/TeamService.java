package st.project.studyWithUs.service.teamService;


import org.springframework.stereotype.Service;
import st.project.studyWithUs.domain.Team;

import java.util.List;

@Service
public interface TeamService {

    List<Team> findMyTeam(Long uId);

    List<Team> findAll();

    void increaseData(Long tId, Long point);

    void decreaseCurrentCount(Long tId);

    Team findBytID(Long tId);
}
