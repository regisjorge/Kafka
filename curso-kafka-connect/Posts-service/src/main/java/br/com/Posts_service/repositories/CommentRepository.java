package br.com.Posts_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Posts_service.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
