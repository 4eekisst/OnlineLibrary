package kg.attractor.onlinelibrary.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")

public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "patronymic", nullable = false)
    private String patronymic;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "passport_number", nullable = false, unique = true)
    private String passportNumber;

    @Column(name = "reader_card_number", nullable = false, unique = true)
    private String readerCardNumber;

    @Column(name = "password", nullable = false)
    private String password;

    @ManyToOne
    @PrimaryKeyJoinColumn
    private Authority authority;;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<BookRequest> bookRequests;
}
