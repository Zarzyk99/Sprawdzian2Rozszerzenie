package pl.kurs.clinicapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Doctor implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    private Integer id;
    private String lastName;
    private String firstName;
    private String speciality;
    private LocalDate birthDate;
    private String NIP;
    private String pesel;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "doctor")
    @JsonManagedReference
    @JsonIgnore
    private Set<Visit> visits;
}
