package br.com.Posts_service.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Posts_service.model.Comment;
import br.com.Posts_service.model.Post;
import br.com.Posts_service.repositories.PostRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("posts")
@RequiredArgsConstructor
public class PostController {
	
  private final PostRepository repository;


  @PostMapping
  public Post createPost(@RequestBody Post post) {
    return repository.save(post);
  }

  @GetMapping
  public List<Post> getPosts() {
    return repository.findAll();
  }

  @GetMapping("{postId}")
  public List<Comment> getComments(@PathVariable Long postId) {
    return repository.findById(postId).get().getComments();
  }
}
