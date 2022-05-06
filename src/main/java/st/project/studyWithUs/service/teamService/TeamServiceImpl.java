package st.project.studyWithUs.service.teamService;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import st.project.studyWithUs.domain.Team;
import st.project.studyWithUs.repository.teamRepository.TeamRepository;

import javax.transaction.Transactional;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;


    @Override
    public List<Team> findMyTeam(Long uId) {
        return teamRepository.findMyTeam(uId);
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }


    @Override
    @Transactional
    public void increaseData(Long tId, Long point) {

        Team t = teamRepository.findBytID(tId);
        t.setCurrentCount(t.getCurrentCount()+1);
        t.setDepositPoint(t.getDepositPoint()+point);
        teamRepository.save(t);
    }

    @Override
    @Transactional
    public void decreaseCurrentCount(Long tId) {
        Team t = teamRepository.findBytID(tId);
        t.setCurrentCount(t.getCurrentCount()-1);
        teamRepository.save(t);
    }

    @Override
    public Team findBytID(Long tId) {
        return teamRepository.findBytID(tId);
    }
}
