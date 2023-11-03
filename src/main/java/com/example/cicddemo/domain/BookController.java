package com.example.cicddemo.domain;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/createBook")
    public ResponseEntity<Book> save(@RequestBody Book book) {
        return ResponseEntity.ok(bookService.save(book));
    }

    @PutMapping("/updateBook/id")
    public ResponseEntity<Book> update(@RequestParam Long id, @RequestBody Book book) {
        return ResponseEntity.ok(bookService.update(id, book));
    }

    @GetMapping("/readBook/id")
    public ResponseEntity<Book> read(@RequestParam Long id) {
        return ResponseEntity.ok(bookService.getById(id));
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<Book>> readAll() {
        List<Book> bookList = bookService.getAll();
        return ResponseEntity.ok(bookList);
    }

    @DeleteMapping("/delete/id")
    public ResponseEntity<String> delete(@RequestParam Long id) {
        bookService.deleteById(id);
        return ResponseEntity.ok("Data has been deleted");
    }
}
