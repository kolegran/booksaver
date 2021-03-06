package com.github.kolegran.book;

import io.micronaut.core.annotation.Introspected;

import javax.validation.constraints.NotBlank;

@Introspected
public class BookSaved {

    @NotBlank
    private String name;
    @NotBlank
    private String isbn;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String toString() {
        return "BookSaved{" +
            "name='" + name + '\'' +
            ", isbn='" + isbn + '\'' +
            '}';
    }
}
