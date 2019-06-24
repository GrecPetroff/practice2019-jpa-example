package com.vivat.practice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Investigation {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "victims_amount")
    private long victimsAmount;

    @ManyToOne
    @JoinColumn(name = "detective_id")
    private Detective detective;

    public Investigation() {

    }

    public Investigation(String title, long victimsAmount) {
        this.title = title;
        this.victimsAmount = victimsAmount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public long getVictimsAmount() {
        return victimsAmount;
    }

    public void setVictimsAmount(long victimsAmount) {
        this.victimsAmount = victimsAmount;
    }

    public Detective getDetective() {
        return detective;
    }

    public void setDetective(Detective detective) {
        this.detective = detective;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder().append("Investigation{")
            .append("id=" + id)
            .append(", title='" + title + '\'')
            .append(", victimsAmount=" + victimsAmount);

        if (detective != null) {
            builder.append(", detective=" + detective.getName());
        }

        builder.append('}');
        return builder.toString();
    }
}
