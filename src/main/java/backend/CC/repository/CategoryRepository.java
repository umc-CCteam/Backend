package backend.CC.repository;

import backend.CC.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    public Category findByCategory1AndCategory2(String category1, String category2);
}
