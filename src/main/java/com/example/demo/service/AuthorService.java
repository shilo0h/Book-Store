package com.example.demo.service;

import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository repository;
    public List<Author>getAllAuthors()throws Exception{
        Optional<List<Author>>list=repository.getAllAuthors();
        if (list.isPresent()){
            return list.get();
        }
        throw new Exception("Empty table");
    }
    public Author getAuthorById(Integer authorId)throws Exception{
        Optional<Author>author=repository.getAuthorById(authorId);
        if (author.isPresent()){
            return author.get();
        }
        throw new Exception("Author not found");
    }
    public void saveAuthor(Author author){
        repository.save(author);
    }
    @Transactional//update te nje author sipas id
    public void updateAuthor(Author author)throws Exception{
        Optional<Author>author1=repository.findById(author.getAuthorId());
        if (author1.isPresent()){
            repository.updateAuthor(author.getName(), author.getAge(),
                     author.getAuthorId());
        }
        else {
            throw new Exception("Author not found");
        }
    }
    @Transactional//do fshij nje autor
    public void deleteAuthor(Integer authorId){
        repository.deleteById(authorId);
    }
}
