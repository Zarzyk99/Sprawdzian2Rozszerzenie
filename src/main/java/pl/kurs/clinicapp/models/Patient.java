package pl.kurs.clinicapp.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Patient implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @Column
    private Integer id;
    private String lastName;
    private String firstName;
    private String pesel;
    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "patient")
    @JsonManagedReference
    @JsonIgnore
    private Set<Visit> visits;

    public Patient(Integer id, String lastName, String firstName) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
    }
}
