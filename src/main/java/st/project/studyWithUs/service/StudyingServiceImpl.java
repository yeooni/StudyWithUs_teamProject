package st.project.studyWithUs.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import st.project.studyWithUs.domain.UserTeam;
import st.project.studyWithUs.repository.StudyingRepository;

@Service
@RequiredArgsConstructor
public class StudyingServiceImpl implements StudyingService{

    private final StudyingRepository studyingRepository;

    @Override
    public void save(UserTeam ut) {
        studyingRepository.save(ut);
    }

    @Override
    public UserTeam findUserTeam(Long uID, Long tID) {
        return studyingRepository.findByuIDandtID(uID,tID);
    }


}
