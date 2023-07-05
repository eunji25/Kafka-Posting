package com.alpaca.kafkaposting.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "hashtag")
public class Hashtag {

    @Id
    @Column(name = "hashtag_id")
    private String id;
    @Column(unique = true)
    @NotFound
    private String hashtag;

    @ManyToOne
    private Post post;

}
