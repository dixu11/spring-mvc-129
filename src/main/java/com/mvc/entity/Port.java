package com.mvc.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "ports")
public class Port {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int lvl;

    public Port(int lvl) {
        this.lvl = lvl;
    }

    public Port() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Port port = (Port) o;
        return id == port.id && lvl == port.lvl;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lvl);
    }
}
