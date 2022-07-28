package com.example.finalproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "public",name="game")
public class game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="gid")
    private int gid;

    @Column(name= "restrain")
    private int restrain;
    @Column(name="level")
    private int level;
    @Column(name="current")
    private int current;
}
