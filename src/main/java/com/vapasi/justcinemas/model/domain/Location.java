package com.vapasi.justcinemas.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="locations")
@Getter
@Setter
public class Location {
    @Id
    private int id;

    @Column(name="location_name")
    private String locationName;
}
