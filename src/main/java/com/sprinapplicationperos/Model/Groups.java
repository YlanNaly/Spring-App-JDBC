package com.sprinapplicationperos.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Groups {
    @Column(length = 3)
    private String name;

    public Groups(String name, LocalDate creation_Date) {
        this.name = name;
        this.creation_Date = creation_Date;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private LocalDate creation_Date;
}
