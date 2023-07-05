package com.alpaca.kafkaposting.repository;

import com.alpaca.kafkaposting.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, String> {
}