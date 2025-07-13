package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.model.Book;
import com.example.LibraryManagementSystem.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService service) {
        this.bookService = service;
    }

    @PostMapping
    public ResponseEntity<Book> addBook(@Valid @RequestBody Book book) {
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Integer id) {
        Book book = bookService.getBookById(id);
        return (book != null) ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Integer id) {
        return (bookService.deleteBook(id)) ?
                ResponseEntity.noContent().build() :
                ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}/availability")
    public ResponseEntity<Book> updateAvailability(@PathVariable Integer id, @RequestParam boolean available) {
        Book book = bookService.updateAvailability(id, available);
        return (book != null) ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }
}
