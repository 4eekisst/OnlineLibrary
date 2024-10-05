package kg.attractor.onlinelibrary.repository;

import kg.attractor.onlinelibrary.model.BookRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRequestRepository extends JpaRepository<BookRequest, Long> {

}
