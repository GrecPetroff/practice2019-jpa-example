package com.vivat.practice.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Detective {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "level")
    private LevelType level;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "detective")
    private Set<Investigation> investigations = new HashSet<>();

    public Detective() {

    }

    public Detective(String name, String lastName, LevelType level) {
        this.name = name;
        this.lastName = lastName;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LevelType getLevel() {
        return level;
    }

    public void setLevel(LevelType level) {
        this.level = level;
    }

    public Set<Investigation> getInvestigations() {
        return investigations;
    }

    public void setInvestigations(Set<Investigation> investigations) {
        this.investigations = investigations;
    }

    // To make connection between detective and investigation
    public void addInvestigation(Investigation investigation) {
        this.investigations.add(investigation);
        investigation.setDetective(this);
    }

    @Override
    public String toString() {
        return "Detective{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastName='" + lastName + '\'' +
            ", level=" + level +
            ", investigations=" + investigations +
            '}';
    }
}
