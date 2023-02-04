package com.microlibrary.repository

import com.microlibrary.domain.Book

import javax.validation.constraints.NotBlank

interface BookRepository {

    Optional<Book> findById(Long id)

    Book save(@NotBlank String title, @NotBlank int pages)

}