package kg.attractor.onlinelibrary.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class BookDto {
    @NotBlank(message = "Название книги не может быть пустым")
    private String title;

    @NotBlank(message = "Автор книги не может быть пустым")
    private String author;

    @NotNull(message = "Категория книги обязательна")
    private Long categoryId;

    private MultipartFile image;

    private String status;
}
