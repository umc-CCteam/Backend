package backend.CC.repository;

import backend.CC.domain.Profile;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ProfileRepository {

    private final EntityManager em;

    //저장
    public void save(Profile profile) {
        em.persist(profile);
    }

    // 조회
    public Profile findOne(Long id) {
        return em.find(Profile.class, id);
    }

}
