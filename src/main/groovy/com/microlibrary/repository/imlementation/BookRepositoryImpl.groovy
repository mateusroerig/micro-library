package com.microlibrary.repository.imlementation

import com.microlibrary.domain.Book
import com.microlibrary.repository.BookRepository
import io.micronaut.transaction.annotation.ReadOnly
import jakarta.inject.Inject
import jakarta.inject.Singleton

import javax.persistence.EntityManager
import javax.transaction.Transactional
import javax.validation.constraints.NotBlank

@Singleton
class BookRepositoryImpl implements BookRepository {

    @Inject
    private EntityManager entityManager

    @Override
    @ReadOnly
    Optional<Book> findById(Long id) {
        return Optional.ofNullable(entityManager.find(Book, id))
    }

    @Override
    @Transactional
    Book save(@NotBlank String title, @NotBlank int pages) {
        Book book = new Book(title, pages)
        entityManager.persist(book)

        return book
    }

}
