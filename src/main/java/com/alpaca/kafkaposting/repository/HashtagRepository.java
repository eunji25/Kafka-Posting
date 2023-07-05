package com.alpaca.kafkaposting.repository;

import com.alpaca.kafkaposting.entity.Hashtag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashtagRepository extends JpaRepository<Hashtag, String> {
}
