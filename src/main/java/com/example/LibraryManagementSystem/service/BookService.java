package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.model.Book;
import com.example.LibraryManagementSystem.repo.BookRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookService {
    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public boolean deleteBook(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;

    }

    public Book updateAvailability(Integer id, boolean available) {
        Optional<Book> optionalBook = repository.findById(id);
        if (optionalBook.isPresent()) {
            Book book = optionalBook.get();
            book.setAvailable(available);
            return repository.save(book);
        }
        return null;
    }

}
