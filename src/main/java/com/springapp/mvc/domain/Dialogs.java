package com.springapp.mvc.domain;

import javax.persistence.*;

/**
 * Created by Айрат on 27.04.2015.
 */
@Entity
@Table(name = "Dialogs", uniqueConstraints=@UniqueConstraint(columnNames = {"from_id" , "to_id"}))
public class Dialogs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private Long from_id;

    @Column(unique = true)
    private Long to_id;

    public Dialogs() {
    }

    public Dialogs(Long to_id, Long from_id) {
        this.to_id = to_id;
        this.from_id = from_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFrom_id() {
        return from_id;
    }

    public void setFrom_id(Long from_id) {
        this.from_id = from_id;
    }

    public Long getTo_id() {
        return to_id;
    }

    public void setTo_id(Long to_id) {
        this.to_id = to_id;
    }
}
