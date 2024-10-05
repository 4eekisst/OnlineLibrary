package kg.attractor.onlinelibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor


public class BookRequestDto {
    private Long bookId;
    private String readerTicket;
    private LocalDate returnDate;
    private String status;
}
