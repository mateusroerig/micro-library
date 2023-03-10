package com.microlibrary.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Book {

    @Id
    @GeneratedValue
    Long id
    String title
    int pages

    Book() {}

    Book(String title, int pages) {
        this.title = title
        this.pages = pages
    }
}