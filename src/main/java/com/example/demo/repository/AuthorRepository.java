package com.example.demo.repository;

import com.example.demo.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Integer> {
@Query(nativeQuery = true,value = "select*from author")
    Optional<List<Author>>getAllAuthors();
@Query(nativeQuery = true,value = "select*from author a where a.author_id=:authorId")
    Optional<Author>getAuthorById(@Param("authorId")Integer authorId);
    @Modifying
    @Query(nativeQuery = true,value = "Update author " +
            "Set name=:name,age=:age " +
            "Where author_id=:authorId")
    void updateAuthor(@Param("name")String name,@Param("age")Integer age,
                    @Param("authorId")Integer authorId);
}

