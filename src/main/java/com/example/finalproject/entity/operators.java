package com.example.finalproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "public",name="operators")
public class operators  implements Comparable<operators> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="oid")
    private int oid;
    @Column(name= "position")
    private int position;
    @Column(name= "types")
    private String types;

    @Column(name="gid")
    private int gid;

    @Override
    public int compareTo(operators o) {
        return this.position-o.getPosition();
    }
}
