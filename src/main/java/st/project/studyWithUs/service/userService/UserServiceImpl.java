package st.project.studyWithUs.service.userService;



import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import st.project.studyWithUs.domain.User;
import st.project.studyWithUs.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    @Override
    public User find(Long uid) {
        return userRepository.findByuID(uid);
    }

    @Override
    public void updatePoint(Long point, Long uId) {
        Long p = find(uId).getPoint();
        p+=point;
        userRepository.updatePoint(p, uId);
    }

    @Override
    public boolean checkPoint(Long point, Long uId) {
        if(point <= find(uId).getPoint()){
            updatePoint(-point, uId);
            return true;
        }
        else return false;
    }

    @Override
    public User login(String id, String pw) {
       return userRepository.loginCheck(id, pw);
    }

    @Override
    public User getNameEmail(String nickname, String email) {
        return userRepository.kakaoLoginCheck(nickname, email);

    }

}
