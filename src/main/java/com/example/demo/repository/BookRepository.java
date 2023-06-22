package com.example.demo.repository;

import com.example.demo.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query(nativeQuery = true,value ="select * from book")
    Optional <List<Book>> getAllBooks();
    //GET /books/{id}: Retrieve the details of a specific book
    @Query(nativeQuery = true,value = "Select * from book b where b.book_id=:bookId")
    Optional <Book>getBookById(@Param("bookId")Integer bookId);
    @Modifying
    @Query(nativeQuery = true,value = "Update book " +
            "Set title=:title,isbn=:isbn,publication_year=:publicationYear " +
            "price=:price,quantity=:quantity Where book_id=:bookId")
    void updateBook(@Param("title")String title,@Param("isbn")Integer isbn,
                    @Param("publicationYear")Integer publicationYear,
                    @Param("price")Integer price,@Param("quantity")Integer quantity,
                    @Param("bookId")Integer bookId);
}
