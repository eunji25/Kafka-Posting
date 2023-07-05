package com.alpaca.kafkaposting.controller;

import com.alpaca.kafkaposting.dto.PostDto;
import com.alpaca.kafkaposting.entity.Post;
import com.alpaca.kafkaposting.service.HashtagService;
import com.alpaca.kafkaposting.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping(value = "/post")
public class PostController {

    private static final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final String topicName = "Hashtag";
    @Autowired
    private PostService postService;
    @Autowired
    private HashtagService hashtagService;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/find-post-list")
    public List<PostDto> findPostList() {
        return postService.findAll();
    }

    @GetMapping("/find-post/{id}")
    public PostDto findPostById(@PathVariable String id) {
        return postService.findPostById(id);
    }

    @PostMapping("/new-post")
    public void newPost(@RequestBody Post post) {
        hashtagService.saveAll(post.getHashtags());
        postService.save(post);
    }
}
