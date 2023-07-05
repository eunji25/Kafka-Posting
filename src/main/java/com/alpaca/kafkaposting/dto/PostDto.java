package com.alpaca.kafkaposting.dto;

import com.alpaca.kafkaposting.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {
    private String id;
    private String userId;
    private String title;
    private String content;
    private Set<HashtagDto> hashtags = new HashSet<>();

    public PostDto(Post post) {
        this.id = post.getId();
        this.userId = post.getUserId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.hashtags = post.getHashtags().stream().map(tag -> new HashtagDto(tag)).collect(Collectors.toSet());
    }
}
