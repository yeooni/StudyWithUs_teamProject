package st.project.studyWithUs.service.userTeamService;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import st.project.studyWithUs.domain.UserTeam;
import st.project.studyWithUs.repository.UserTeamRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTeamServiceImpl implements UserTeamService {


    private final UserTeamRepository userTeamRepository;

    @Override
    @Transactional
    public void save(UserTeam userStudyTeam) { userTeamRepository.save(userStudyTeam);
    }

    @Override
    public List<UserTeam> findAll() {
        return userTeamRepository.findAll();
    }

    @Override
    public void dropStudyTeam(Long tId, Long uId) {
        List<UserTeam> userTeam = userTeamRepository.findAll();
        for (UserTeam ut : userTeam) {
            if(ut.getTeam().getTID()==tId&&ut.getUser().getUID()==uId)userTeamRepository.deleteById(ut.getUtID());
        }
    }

}
