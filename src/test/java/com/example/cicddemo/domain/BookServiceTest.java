package com.example.cicddemo.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @InjectMocks
    BookService bookService;

    @Mock
    BookRepository bookRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getAllTest() {
        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book(1L, "Design Pattern", "John Clim", "If you need to improve DP"));
        bookList.add(new Book(2L, "Spring Boot", "ALisher Usmonov", "If you need to improve Spring Book"));
        bookList.add(new Book(3L, "Object Oriented Programming", "Imron Usmonov", "If you need to improve OOP"));

        Mockito.when(bookRepository.findAll()).thenReturn(bookList);

        List<Book> list = bookService.getAll();
        assertNotNull(list);
        assertEquals(3, list.size());
        assertEquals("Spring Boot", list.get(1).getName());
        assertEquals("Imron Usmonov", list.get(2).getAuthor());
    }

    @Test
    public void getById() {

    }

    @Test
    public void save() {

    }

    @Test
    void update() {

    }

    @Test
    public void deleteById() {

    }
}
