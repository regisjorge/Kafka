package br.com.Posts_service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Posts_service.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
