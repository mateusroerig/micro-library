package com.microlibrary.command

import io.micronaut.core.annotation.Introspected

import javax.validation.constraints.NotBlank

@Introspected
class BookSaveCommand {

    @NotBlank
    String title

    @NotBlank
    int pages

    BookSaveCommand(String title, int pages) {
        this.title = title
        this.pages = pages
    }

}
