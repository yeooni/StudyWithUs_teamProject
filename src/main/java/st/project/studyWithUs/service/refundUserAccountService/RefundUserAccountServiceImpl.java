package st.project.studyWithUs.service.refundUserAccountService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import st.project.studyWithUs.domain.RefundUserAccount;
import st.project.studyWithUs.repository.refundAccountRepository.RefundAccountRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class RefundUserAccountServiceImpl implements RefundUserAccountService {

    private final RefundAccountRepository refundAccountRepository;

    @Override
    public List<RefundUserAccount> findRefundAccount() {
        return refundAccountRepository.findAll();
    }
}
