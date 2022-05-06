package st.project.studyWithUs.service;


import st.project.studyWithUs.domain.UserTeam;

public interface StudyingService {
    void save(UserTeam ut);
    UserTeam findUserTeam(Long uID, Long tID);
}
