package backend.CC.repository;

import backend.CC.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AuthRepository extends JpaRepository<Member, Long> {
    @Query("SELECT m FROM Member m WHERE m.email = :email AND m.passWord = :password")
    Member findMemberByEmailAnAndPassWord(String email, String password);

}
