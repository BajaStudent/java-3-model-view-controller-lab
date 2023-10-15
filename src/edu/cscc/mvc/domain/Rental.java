package edu.cscc.mvc.domain;

import java.util.Objects;
import java.util.UUID;

public class Rental {

    private UUID id;
    private String name;
    private Format format;
    private Genre genre;
    private String director;
    private String year;

    public Rental() { }

    public Rental(String name, Format format, Genre genre, String director, String year) {
        this.name = name;
        this.format = format;
        this.genre = genre;
        this.director = director;
        this.year = year;
    }

    public Rental(UUID id, String name, Format format, Genre genre, String director, String year) {
        this.id = id;
        this.name = name;
        this.format = format;
        this.genre = genre;
        this.director = director;
        this.year = year;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Format getFormat() {
        return format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rental rental = (Rental) o;
        return Objects.equals(id, rental.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Rental{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", format=" + format +
                ", genre=" + genre +
                ", director='" + director + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
