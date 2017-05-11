package com.badbanana.poll.api.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

/**
 * Created by langley on 10/5/17.
 */
@Entity
@Table(name = "poll", uniqueConstraints = @UniqueConstraint(columnNames = {"identity"}))
public class Poll {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter @Getter Long id;

    @Column(name = "identity")
    @Setter @Getter String identity;

    @Column(name = "title")
    @Setter @Getter String title;

    @OneToMany(cascade = CascadeType.ALL)
    @Setter @Getter List<Vote> votes;

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", identity='" + identity + '\'' +
                ", title='" + title + '\'' +
                ", votes=" + votes +
                '}';
    }
}
