package kg.attractor.onlinelibrary.repository;

import kg.attractor.onlinelibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByReaderCardNumber(String readerCardNumber);
}
