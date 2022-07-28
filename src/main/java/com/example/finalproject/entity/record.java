package com.example.finalproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "public",name="record")
public class record {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rid")
    private int rid;

    @Column(name="level")
    private int level;
    @Column(name="lid")
    private int lid;
    @Column(name="uid")
    private int uid;
    @Column(name="answer")
    private String answer;
    @Column(name="question")
    private String question;
    @Column(name="correct")
    private int correct;
}
