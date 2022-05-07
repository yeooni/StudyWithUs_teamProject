package st.project.studyWithUs.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import st.project.studyWithUs.domain.UserTeam;

public interface UserTeamRepository extends JpaRepository<UserTeam, Long> {


}
