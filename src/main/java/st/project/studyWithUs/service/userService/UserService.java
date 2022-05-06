package st.project.studyWithUs.service.userService;
import org.springframework.stereotype.Service;
import st.project.studyWithUs.domain.User;


@Service
public interface UserService {

    User find(Long uid); //유저 찾기

    void updatePoint(Long point, Long uId); //포인트 업데이트

    boolean checkPoint(Long point, Long uId); // 포인트 삭감 여부

}
