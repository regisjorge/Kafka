package br.com.Comments_service.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.Comments_service.model.Comment;
import br.com.Comments_service.repositories.CommentRepository;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("comments")
@RequiredArgsConstructor
public class CommentController {
	
  private final CommentRepository repository;

  @PostMapping
  public Comment createComment(@RequestBody Comment comment) {
    return repository.save(comment);
  }

  @GetMapping
  public List<Comment> getComments() {
    return repository.findAll();
  }
}