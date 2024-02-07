package backend.CC.repository;

import backend.CC.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Member, Long> {
}
