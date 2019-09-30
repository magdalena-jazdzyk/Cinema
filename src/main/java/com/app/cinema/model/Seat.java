package com.app.cinema.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue
    private Long id;

    private Integer columnNumber;
    private Integer rowNumber;
    private Integer roomNumber;

    @OneToOne(mappedBy = "seat")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Reservation reservation;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private User user;

}