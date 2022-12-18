package lara.pers.ProjectM2.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.Table;


import java.util.Set;

import jakarta.persistence.Column;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="MedicalSpeciality")
public class MedicalSpeciality {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name ="info", nullable = false)
    private String info;

    @Column(name = "Schedule")
    private String schedule;

    // agrega aqui join con tabla de doctores
   
    
    @OneToMany
    @JoinColumn(name = "Speciality")
    Set<Doctors> doctors ;
}
