package edu.cscc.mvc.domain;

import java.util.List;
import java.util.UUID;

/**
 * Repository for rental objects. Rentals can be in
 * different formats, such as DVD, VHS, or Blu-ray. They can
 * also be in different genres.
 */
public interface RentalRepository {
    RentalRepository instance = new RentalRepositoryImpl();

    static RentalRepository getInstance() {
        return instance;
    }

    Rental create(Rental rental);

    Rental read(UUID id);

    Rental update(Rental rental);

    List<Rental> readAll();

    Rental delete(UUID id);
}