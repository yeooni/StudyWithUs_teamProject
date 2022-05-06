package st.project.studyWithUs.repository.pointInfo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;
import st.project.studyWithUs.domain.PointInfo;

import javax.persistence.LockModeType;

@Repository
public interface PointInfoRepository extends JpaRepository<PointInfo, Long>, PointInfoRepositoryCustom {

    @Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
    PointInfo findBypID(Long pID);



}
