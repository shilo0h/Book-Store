package com.example.demo.controller;

import com.example.demo.entities.Book;
import com.example.demo.entities.Genre;
import com.example.demo.service.GenreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/genre")
public class GenreController {
    @Autowired
    GenreService service;
    @GetMapping("/getAll")
    public ResponseEntity<List<Genre>> getAllGenre(){
        log.info("GenreController.getAllGenre()started at{}", Instant.now());
        List<Genre>list=null;
        try {
            list=service.getAllGenre();
            log.info("GenreController.getAllGenre() ended request in{}",Instant.now());
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            log.info("GenreController.getAllGenre()Ended error request in{}",Instant.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/getGenreById")
    public ResponseEntity<Genre>getGenreById(@RequestParam("id")Integer genreId){
        log.info("GenreController.getGenreById()started request at{}",Instant.now());
        Genre genre=null;
        try {
            genre=service.getGenreById(genreId);
            log.info("GenreController.getGenreById() Ended Request at {}", Instant.now());
            return ResponseEntity.ok(genre);
        }catch (Exception e){
            log.info("GenreController.getGenreById()Error at{}",Instant.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/save")
    public ResponseEntity<String>saveGenre(@RequestBody Genre genre){
        log.info("Started saveGenre() at {}  request body: {}", Instant.now(), genre);
        service.saveGenre(genre);
        log.info("Ended saveGenre()at{}", Instant.now());
        return ResponseEntity.ok("Genre saved successfully");
    }
    @PutMapping("/update")
    public ResponseEntity<String>updateGenre(@RequestBody Genre genre){
        try {
            service.updateGenre(genre);
            log.info("UpdateGenre()ended request at{}",Instant.now());
            return ResponseEntity.ok("Genre updated successfully");
        }catch (Exception e){
            log.error("Error,Genre not found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String>deleteGenre(@RequestParam("genre_Id")Integer genreId){
        service.deleteGenre(genreId);
        return ResponseEntity.ok("Genre deleted successfully");
    }
}
