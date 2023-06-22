package com.example.demo.controller;

import com.example.demo.entities.Book;
import com.example.demo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.Instant;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService service;
    @GetMapping("/getAll")
    public ResponseEntity<List<Book>>getAllBooks(){
        log.info("BookController.getAllBooks()started at{}", Instant.now());
        List<Book>list;
        try {
            list=service.getAllBooks();
            log.info("BookController.getAllBooks() ended request in{}",Instant.now());
            return ResponseEntity.ok(list);
        } catch (Exception e) {
           log.info("BookController.getAllBooks()Ended error request in{}",Instant.now());
           return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @GetMapping("/getBookById")
    public ResponseEntity<Book>getBookById(@RequestParam("id")Integer bookId){
        log.info("BookController.getBookyId()startet request at{}",Instant.now());
        Book book=null;
        try {
            book=service.getBookById(bookId);
            log.info("BookController.getBookById() Ended Request at {}", Instant.now());
            return ResponseEntity.ok(book);
        }catch (Exception e){
            log.info("BookController.getBookById()Error at{}",Instant.now());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
    @PostMapping("/save")
    public ResponseEntity<String>saveBook(@RequestBody Book book){
        log.info("Started saveBook() at {}  request body: {}", Instant.now(), book);
        service.saveBook(book);
        log.info("Ended saveBook()at{}", Instant.now());
        return ResponseEntity.ok("Book saved successfully");
    }
    @PutMapping("/update")
    public ResponseEntity<String>updateBook(@RequestBody Book book){
        try {
            service.updateBook(book);
            log.info("UpdateBook()ended request at{}",Instant.now());
            return ResponseEntity.ok("Book updated successfully");
        }catch (Exception e){
            log.error("Error,Book not found");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<String>deleteBook(@RequestParam("id")Integer bookId){
        service.deleteBook(bookId);
        return ResponseEntity.ok("Book deleted successfully");
    }
}
