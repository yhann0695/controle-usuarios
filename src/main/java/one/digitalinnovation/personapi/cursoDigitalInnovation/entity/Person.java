package one.digitalinnovation.personapi.cursoDigitalInnovation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "FIRSTNAME")
    private String firstName;

    @Column(nullable = false, name = "LASTNAME")
    private String lastName;

    @Column(nullable = false, unique = true, name = "CPF")
    private String cpf;

    @Column(name = "BIRTHDATE")
    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;
}
