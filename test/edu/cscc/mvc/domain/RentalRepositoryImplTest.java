package edu.cscc.mvc.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class RentalRepositoryImplTest {
    private RentalRepositoryImpl repository;

    @BeforeEach
    public void setUp() {
        repository = new RentalRepositoryImpl();
    }

    @Test
    public void itCanCreateARental() {
        Rental rental = createDefaultRental();

        rental = repository.create(rental);

        assertNotNull(rental.getId());
    }

    @Test
    public void itCanReadARental() {
        Rental rental = repository.create(createDefaultRental());

        Rental found = repository.read(rental.getId());

        assertEquals(rental, found);
    }

    @Test
    public void itCanUpdateARental() {
        Rental rental = repository.create(createDefaultRental());

        Rental toUpdate = new Rental(rental.getId(), rental.getName(), rental.getFormat(), rental.getGenre(), rental.getDirector(), rental.getYear());
        toUpdate.setName("Alien");

        repository.update(toUpdate);

        Rental found = repository.read(toUpdate.getId());
        assertEquals("Alien", found.getName());
    }

    @Test
    public void itCanReadAllRentals() {
        Rental rockyHorror = repository.create(createDefaultRental());
        Rental alien = new Rental("Alien", Format.DVD, Genre.HORROR, "Ridley Scott", "1979");
        alien = repository.create(alien);

        List<Rental> rentals = repository.readAll();
        assertTrue(rentals.contains(rockyHorror));
        assertTrue(rentals.contains(alien));
    }

    @Test
    public void itCanDeleteARental() {
        Rental rockyHorror = repository.create(createDefaultRental());
        repository.delete(rockyHorror.getId());
        assertTrue(repository.readAll().isEmpty());
    }

    @Test
    public void itCanDeleteARentalAfterBeingUpdated() {
        Rental rental = repository.create(createDefaultRental());
        rental.setName("Alien");
        rental.setFormat(Format.VHS);
        rental.setDirector("Ridley Scott");
        rental.setYear("1976");
        Rental updated = repository.update(rental);

        repository.delete(updated.getId());

        assertTrue(repository.readAll().isEmpty());
    }

    private Rental createDefaultRental() {
        Rental rental = new Rental("Rocky Horror Picture Show", Format.DVD, Genre.COMEDY, "Jim Sharman", "1975");
        return rental;
    }
}