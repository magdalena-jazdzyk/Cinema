package com.app.cinema.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "videos")
public class Video {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String site;
    private String keyHash;

    @ManyToOne()
    @JoinColumn(name = "movie_id")
    @JsonManagedReference
    private Movie movie;


}
