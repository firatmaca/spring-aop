package com.teamfighttactics.teamfighttactics.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String name;
    private String type;

    @OneToMany(mappedBy = "hero" ,cascade = CascadeType.ALL , orphanRemoval = true)
    List<Review> reviews = new ArrayList<Review>();
}
