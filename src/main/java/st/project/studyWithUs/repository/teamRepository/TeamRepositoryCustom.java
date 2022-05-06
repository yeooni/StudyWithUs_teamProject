package st.project.studyWithUs.repository.teamRepository;


import st.project.studyWithUs.domain.Team;

import java.util.List;

public interface TeamRepositoryCustom {

    List<Team> findMyTeam(Long uId);
}
