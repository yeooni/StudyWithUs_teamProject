package st.project.studyWithUs.repository.userRepository;

import st.project.studyWithUs.domain.User;

public interface UserRepositoryCustom {


    public User find(Long uid);
    public void updatePoint(Long point, Long uId);
    public boolean checkPoint(Long point, Long uId);
}
