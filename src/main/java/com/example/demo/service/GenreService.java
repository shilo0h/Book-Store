package com.example.demo.service;

import com.example.demo.entities.Book;
import com.example.demo.entities.Genre;
import com.example.demo.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    @Autowired
    GenreRepository repository;
    public List<Genre> getAllGenre()throws Exception{
        Optional<List<Genre>> list=repository.getAllGenre();
        if (list.isPresent()){
            return list.get();
        }
        throw new Exception("Empty table");
    }
    public Genre getGenreById(Integer genreId)throws Exception{
        Optional<Genre> genre=repository.getGenreById(genreId);
        if (genre.isPresent()){
            return genre.get();
        }
        throw new Exception("Genre not found");
    }
    public void saveGenre(Genre genre){
        repository.save(genre);
    }
    @Transactional//update te nje genre sipas id
    public void updateGenre(Genre genre)throws Exception{
        Optional<Genre>genre1=repository.findById(genre.getGenreId());
        if (genre1.isPresent()){
            repository.updateGenre(genre.getName(),
                    genre.getGenreId());
        }
        else {
            throw new Exception("Genre not found");
        }
    }
    @Transactional//do fshinj ne liber
    public void deleteGenre(Integer genreId){
        repository.deleteById(genreId);
    }
}
