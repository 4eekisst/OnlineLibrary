package kg.attractor.onlinelibrary.repository;

import kg.attractor.onlinelibrary.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
