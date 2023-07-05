package com.alpaca.kafkaposting.service;

import com.alpaca.kafkaposting.dto.HashtagDto;
import com.alpaca.kafkaposting.entity.Hashtag;
import com.alpaca.kafkaposting.repository.HashtagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HashtagService {

    @Autowired
    private HashtagRepository hashtagRepository;

    public List<HashtagDto> findAll() {
        return hashtagRepository.findAll()
                .stream().map(HashtagDto::new)
                .collect(Collectors.toList());
    }

    public void saveAll(Set<Hashtag> hashtags) {
        hashtagRepository.saveAll(hashtags);
    }
}
