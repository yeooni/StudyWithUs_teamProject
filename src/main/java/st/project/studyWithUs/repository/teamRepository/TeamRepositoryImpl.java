package st.project.studyWithUs.repository.teamRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import st.project.studyWithUs.domain.Team;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class TeamRepositoryImpl implements TeamRepositoryCustom{

    private final EntityManager em;

    public List<Team> findMyTeam(Long uId){
        return em.createQuery("select t from Team t, UserTeam ut where t.tID = ut.team.tID and ut.user.uID=:uId")
                .setParameter("uId", uId)
                .getResultList();

    }
}
