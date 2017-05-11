package com.badbanana.poll.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by langley on 11/5/17.
 */
@Entity
@Table(name = "vote")
public class Vote {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonIgnore
    @Setter @Getter private Long id;

    @Column(name = "name")
    @Setter @Getter private String name;

    @Column(name = "count")
    @Setter @Getter private Integer count = 0;

}
