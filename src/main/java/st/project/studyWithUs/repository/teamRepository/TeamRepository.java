package st.project.studyWithUs.repository.teamRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import st.project.studyWithUs.domain.Team;


@Repository
public interface TeamRepository extends JpaRepository<Team, Long>, TeamRepositoryCustom {


    Team findBytID(Long tId);
}
