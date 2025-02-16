package st.project.studyWithUs.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import st.project.studyWithUs.domain.User;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query ("select u from User u where u.userID = :id and u.password = :pw")
    User loginCheck(@Param("id") String id, @Param("pw") String pw);

    @Query ("select u from User u where u.userID like :nickName and u.email like :email")
    User kakaoLoginCheck(@Param("nickName") String nickname, @Param("email") String email);

    User findByuID(Long uId);

    @Modifying
    @Query ("update User u set u.point = :p where u.uID = :uid")
    void updatePoint(@Param("p") Long point, @Param("uid") Long uId);

}
