package st.project.studyWithUs.repository.userRepository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import st.project.studyWithUs.domain.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepositoryCustom {


    @PersistenceContext
    private EntityManager em;

    @Override
    public User find(Long uid) {
        return em.find(User.class, uid);
    }

    @Override
    public void updatePoint(Long point, Long uId) {
        em.createQuery("update User u set u.point = :p where u.uID = :uid")
                .setParameter("p", point)
                .setParameter("uid", uId)
                .executeUpdate();
    }

    @Override
    public boolean checkPoint(Long point, Long uId) {
        if(point <=find(uId).getPoint()){
            updatePoint(-point, uId);
            return true;
        }
        return false;
    }
}
