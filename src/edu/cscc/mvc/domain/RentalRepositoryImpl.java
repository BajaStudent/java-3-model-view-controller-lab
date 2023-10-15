package edu.cscc.mvc.domain;

import java.util.*;
import java.util.stream.Collectors;

public class RentalRepositoryImpl implements RentalRepository {
    private Set<Rental> rentals;

    public RentalRepositoryImpl() {
        rentals = new HashSet<>();
    }

    @Override
    public Rental create(Rental rental) {
        rental.setId(UUID.randomUUID());
        rentals.add(rental);

        return rental;
    }

    @Override
    public Rental read(UUID id) {
        Optional<Rental> found = readOptional(id);

        return found.get();
    }


    private Optional<Rental> readOptional(UUID id) {
        return rentals.stream().filter(rental -> rental.getId().equals(id)).findFirst();
    }

    @Override
    public Rental update(Rental rental) {
        Rental toUpdate = read(rental.getId());
        toUpdate.setYear(rental.getYear());
        toUpdate.setDirector(rental.getDirector());
        toUpdate.setFormat(rental.getFormat());
        toUpdate.setGenre(rental.getGenre());
        toUpdate.setName(rental.getName());

        return toUpdate;
    }

    @Override
    public List<Rental> readAll() {
        return rentals.stream().collect(Collectors.toList());
    }

    @Override
    public Rental delete(UUID id) {
        Rental rental = read(id);
        rentals.remove(rental);

        return rental;
    }
}
