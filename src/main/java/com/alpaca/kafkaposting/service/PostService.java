package com.alpaca.kafkaposting.service;

import com.alpaca.kafkaposting.dto.PostDto;
import com.alpaca.kafkaposting.entity.Post;
import com.alpaca.kafkaposting.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<PostDto> findAll() {
        return postRepository.findAll()
                .stream().map(PostDto::new)
                .collect(Collectors.toList());
    }

    public PostDto findPostById(String id) {
        Post post = postRepository.findById(id).get();
        return new PostDto(post);
    }

    public void save(Post post) {
        postRepository.save(post);
    }
}
