package com.alpaca.kafkaposting.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
    @Column(name = "post_id")
    private String id;
    private String userId;
    private String title;
    private String content;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "post_hashtag",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "hashtag_id")
    )
    private Set<Hashtag> hashtags = new HashSet<>();
}
