package com.vapasi.justcinemas.model.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="movies")
@Getter
@Setter
public class Movie {
    @Id
    private String movieName;
    private String soundTrack;
    private Date releaseDate;
    @Column(name="file_name")
    private String fileName;


}