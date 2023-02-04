package com.microlibrary.service

import com.microlibrary.command.BookSaveCommand
import com.microlibrary.domain.Book
import com.microlibrary.repository.BookRepository
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class BookService {

    @Inject
    private BookRepository bookRepository

    Book show(Long id) {
        return bookRepository.findById(id).orElse(null)
    }

    Book save(BookSaveCommand command) {
        return bookRepository.save(command.title, command.pages)
    }

}
