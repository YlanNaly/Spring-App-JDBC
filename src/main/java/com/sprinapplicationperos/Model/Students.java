package com.sprinapplicationperos.Model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Students {
    @Column (name = "name")
    private String name;
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(
            name="Groups_id"
    )
    private Groups groups;
}
