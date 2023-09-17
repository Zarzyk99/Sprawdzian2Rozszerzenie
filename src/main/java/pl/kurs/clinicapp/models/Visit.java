package pl.kurs.clinicapp.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Visit implements Serializable {
    static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private LocalDate visitDate;

    @ManyToOne()
    @JoinColumn(name = "patient_id")
    @JsonBackReference
    private Patient patient;

    @ManyToOne()
    @JoinColumn(name = "doctor_id")
    @JsonBackReference
    private Doctor doctor;

    public Visit(Integer id, LocalDate visitDate, Doctor doctor) {
        this.id = id;
        this.visitDate = visitDate;
        this.doctor = doctor;
    }

    public Visit(LocalDate visitDate, Patient patient, Doctor doctor) {
        this.visitDate = visitDate;
        this.patient = patient;
        this.doctor = doctor;
    }
}
