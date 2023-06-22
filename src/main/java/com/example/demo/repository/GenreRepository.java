package com.example.demo.repository;

import com.example.demo.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Integer> {
    @Query(nativeQuery = true,value ="select*from genre")
    Optional<List<Genre>> getAllGenre();
    //GET /genre/{id}: Retrieve the details of a specific genre
    @Query(nativeQuery = true,value = "Select*from genre g where g.genre_id=:genreId")
    Optional <Genre>getGenreById(@Param("genreId")Integer genreId);
    @Modifying
    @Query(nativeQuery = true,value = "Update genre " +
            "Set name=:name " +
            "Where genre_id=:genreId")
    void updateGenre(@Param("name")String name,
                     @Param("genreId")Integer genreId);
}
