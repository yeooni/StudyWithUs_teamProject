package st.project.studyWithUs.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import st.project.studyWithUs.domain.PointInfo;
import st.project.studyWithUs.domain.RefundUserAccount;

import javax.persistence.LockModeType;
import javax.transaction.Transactional;

@Repository
@Transactional
public interface PointInfoRepository extends JpaRepository<PointInfo, Long>{

    @Lock(LockModeType.PESSIMISTIC_FORCE_INCREMENT)
    PointInfo findBypID(Long pID);

    @Modifying
    @Query ("update PointInfo pi  set pi.balance = :p where pi.pID = :pId")
    void update(@Param("p") Long point, @Param("pId") Long pId );



}
