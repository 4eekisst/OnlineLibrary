package kg.attractor.onlinelibrary.repository;

import kg.attractor.onlinelibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

}
