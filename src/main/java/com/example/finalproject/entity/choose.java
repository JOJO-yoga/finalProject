package com.example.finalproject.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(schema = "public",name="choose")
public class choose implements Comparable<choose>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="cid")
    private int cid;

    @Column(name="figure")
    private int figure;
    @Column(name="position")
    private int position;
    @Column(name="gid")
    private int gid;
    @Column(name="nid")
    private int nid;

    @Override
    public int compareTo(choose o) {
        return this.position-o.getPosition();
    }
}
