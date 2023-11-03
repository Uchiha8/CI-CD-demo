package com.example.cicddemo.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(Book book) {
        bookRepository.save(book);
        return book;
    }

    public Book update(Long id, Book book) {
        Book update_book = bookRepository.getBookById(id);
        update_book.setName(book.getName());
        update_book.setAuthor(book.getAuthor());
        update_book.setDescription(book.getDescription());
        update_book.setId(book.getId());
        bookRepository.save(update_book);
        return update_book;
    }

    public Book getById(Long id) {
        return bookRepository.getBookById(id);
    }

    public List<Book> getAll() {
        List<Book> bookList = bookRepository.findAll();
        return bookList;
    }

    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}
