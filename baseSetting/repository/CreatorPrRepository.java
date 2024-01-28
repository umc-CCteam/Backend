package backend.CC.repository;

import backend.CC.domain.CreatorPR;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreatorPrRepository extends JpaRepository<CreatorPR, Long> {

}
