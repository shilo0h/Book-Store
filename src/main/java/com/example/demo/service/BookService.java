package com.example.demo.service;

import com.example.demo.entities.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository repository;
    public List<Book>getAllBooks()throws Exception{
        Optional<List<Book>>list=repository.getAllBooks();
        if (list.isPresent()){
            return list.get();
        }
        throw new Exception("Empty table");
    }
    public Book getBookById(Integer bookId)throws Exception{
        Optional<Book> book=repository.getBookById(bookId);
        if (book.isPresent()){
            return book.get();
        }
        throw new Exception("Book not found");
    }
    public void saveBook(Book book){
        repository.save(book);
    }
    @Transactional//update te nje libri sipas id
    public void updateBook(Book book)throws Exception{
        Optional<Book>book1=repository.findById(book.getBook_id());
        if (book1.isPresent()){
            repository.updateBook(book.getTitle(), book.getIsbn(), book.getPublication_year(),
                    book.getPrice(), book.getQuantity(), book.getBook_id());
        }
        else {
            throw new Exception("Book not found");
        }
    }
    @Transactional//do fshinj ne liber
    public void deleteBook(Integer bookId){
        repository.deleteById(bookId);
    }
}
