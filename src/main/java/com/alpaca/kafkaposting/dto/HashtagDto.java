package com.alpaca.kafkaposting.dto;

import com.alpaca.kafkaposting.entity.Hashtag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HashtagDto {
    private String id;
    private String hashtag;
    private PostDto post;

    public HashtagDto(Hashtag hashtag) {
        this.id = hashtag.getId();
        this.hashtag = hashtag.getHashtag();
//        this.post = hashtag.getPost();
    }
}
