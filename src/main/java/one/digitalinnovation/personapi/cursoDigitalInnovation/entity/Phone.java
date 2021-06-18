package one.digitalinnovation.personapi.cursoDigitalInnovation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import one.digitalinnovation.personapi.cursoDigitalInnovation.enums.PhoneType;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "TB_PHONE")
public class Phone implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PHONE")
    private Long id;

    @Column(nullable = false, name = "TYPE")
    @Enumerated(EnumType.STRING)
    private PhoneType type;

    @Column(nullable = false, name = "NUMBER")
    private String number;
}
