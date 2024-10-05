package kg.attractor.onlinelibrary.repository;

import kg.attractor.onlinelibrary.model.BookRequest;
import kg.attractor.onlinelibrary.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRequestRepository extends JpaRepository<BookRequest, Long> {
    List<BookRequest> findByUser(User user);
    List<BookRequest> findByUser_ReaderCardNumber(String readerCardNumber);
}
