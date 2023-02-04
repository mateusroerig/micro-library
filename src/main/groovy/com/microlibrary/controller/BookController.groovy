package com.microlibrary.controller

import com.microlibrary.command.BookSaveCommand
import com.microlibrary.domain.Book
import com.microlibrary.service.BookService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import jakarta.inject.Inject

import javax.validation.Valid

@Controller('/books')
class BookController {

    @Inject
    private BookService bookService

    @Get('/{id}')
    HttpResponse<Book> show(Long id) {
        Book book = bookService.show(id)

        if (!book) {
            return HttpResponse.notFound()
        }

        return HttpResponse.ok(book)
    }

    @Post
    HttpResponse<Book> save(@Body @Valid BookSaveCommand command) {
        Book book = bookService.save(command)

        return HttpResponse.created(book)
    }

}
