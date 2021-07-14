package com.platzifundaments.springboot.fundaments.repository;

import com.platzifundaments.springboot.fundaments.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}