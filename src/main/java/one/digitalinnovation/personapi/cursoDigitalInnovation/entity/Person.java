package one.digitalinnovation.personapi.cursoDigitalInnovation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


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

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getCpf() {
        return cpf;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }
}
