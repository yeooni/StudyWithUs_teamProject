package st.project.studyWithUs.repository.pointInfo;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import st.project.studyWithUs.domain.RefundUserAccount;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;


@Repository
@RequiredArgsConstructor

public class PointInfoRepositoryImpl implements PointInfoRepositoryCustom {

    private final EntityManager em;

    @Transactional
    public void update(Long point, Long pId ) {
        em.createQuery("update PointInfo pi  set pi.balance = :p where pi.pID = :pId")
                .setParameter("p", point)
                .setParameter("pId", pId)
                .executeUpdate();
    }

    public void addRefundUserAccount(RefundUserAccount refundUserAccount){
        em.persist(refundUserAccount);
    }


}
