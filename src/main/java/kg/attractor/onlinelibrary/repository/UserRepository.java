package kg.attractor.onlinelibrary.repository;

import kg.attractor.onlinelibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
