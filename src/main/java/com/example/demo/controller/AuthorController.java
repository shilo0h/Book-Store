package com.example.demo.controller;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.Instant;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    AuthorService service;
    @GetMapping("/getAll")
    public ResponseEntity<List<Author>>getAllAuthors(){
        log.info("AuthorService.getAllAuthors()started at{}", Instant.now());
        List<Author>list=null;
        try{
            list=service.getAllAuthors();
            log.info("AuthorService.getAllAuthors()Ended at{}",Instant.now());
            return ResponseEntity.ok(list);
        }
        catch (Exception e){
            log.info("AuthorService.getAllAuthors()Error at{}",Instant.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/getAuthorById")
    public ResponseEntity<Author>getAuthorById(@RequestParam("id")Integer authorId){
        log.info("AuthorService.getAuthorById()Started at{}", Instant.now());
        Author author=null;
        try{
            author=service.getAuthorById(authorId);
            log.info("AuthorService.getAuthorById()Ended at{}",Instant.now());
            return ResponseEntity.ok(author);
        }catch (Exception e){
            log.info("AuthorController.getAuthorById()Error at{}",Instant.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/save")
    public ResponseEntity<String>saveAuthor(@RequestBody Author author){
        log.info("Started saveAuthor() at {}  request body: {}", Instant.now(), author);
        service.saveAuthor(author);
        log.info("Ended saveAuthor()at{}", Instant.now());
        return ResponseEntity.ok("Author saved successfully");
    }
    @PutMapping("/update")
    public ResponseEntity<String>updateAuthor(@RequestBody Author author){
        try {
            service.updateAuthor(author);
            log.info("UpdateAuthor()ended request at{}",Instant.now());
            return ResponseEntity.ok("Author updated successfully");
        }catch (Exception e){
            log.error("Error,Author not found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String>deleteAuthor(@RequestParam("id")Integer authorId){
        service.deleteAuthor(authorId);
        return ResponseEntity.ok("Author deleted successfully");
    }
}
