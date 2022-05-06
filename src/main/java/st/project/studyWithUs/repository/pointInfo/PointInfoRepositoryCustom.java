package st.project.studyWithUs.repository.pointInfo;

import org.springframework.stereotype.Repository;
import st.project.studyWithUs.domain.RefundUserAccount;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface PointInfoRepositoryCustom {

    void update(Long point, Long aId );
    void addRefundUserAccount(RefundUserAccount refundUserAccount);

}
