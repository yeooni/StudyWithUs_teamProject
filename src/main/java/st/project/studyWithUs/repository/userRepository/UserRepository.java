package st.project.studyWithUs.repository.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import st.project.studyWithUs.domain.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

}
