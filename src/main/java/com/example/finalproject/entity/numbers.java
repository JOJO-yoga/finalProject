package com.example.finalproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "public",name="numbers")
public class numbers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="nid")
    private int nid;
    @Column(name="gid")
    private int gid;
    @Column(name="figure")
    private int figure;
    @Column(name="status")
    private int status;
}
