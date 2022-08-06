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

    public Students(String name, Groups groups) {
        this.name = name;
        this.groups = groups;
    }

    public Students(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(
            name="groups_id"
    )
    private Groups groups;

    public Long getId(Long id) {
        return id;
    }
}
