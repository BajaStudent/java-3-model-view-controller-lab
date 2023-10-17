package edu.cscc.mvc;

import edu.cscc.mvc.domain.Format;
import edu.cscc.mvc.domain.Genre;
import edu.cscc.mvc.domain.Rental;
import edu.cscc.mvc.domain.RentalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class RentalsControllerTest extends MVCTest{
    private RentalRepository rentalRepository;
    private Rental rental;

    @BeforeEach
    public void setUp() {
        super.setUp();
        rentalRepository = RentalRepository.getInstance();

        rental = new Rental("Secondhand Lions", Format.DVD, Genre.COMEDY,"Tim McCanlies", "2003" );
        rentalRepository.create(rental);
    }

    @Test
    public void itCanRouteToRentalsIndex() {
        assertRouteExists("Rentals", "index", RentalsController.class);
    }

    @Test
    public void itRendersRentalsIndex() {
        routeRequest("Rentals", "index");
        assertViewRendered(RentalsIndex.class);
    }

    @Test
    public void itCanRouteToRentalsSelect() {
        assertRouteExists("Rentals", "select", RentalsController.class);
    }


    @Test
    public void itRendersTheSelectRentalView() {
        routeRequest("Rentals", "select");

        assertViewRendered(SelectRental.class);
    }

    @Test
    public void itCanRouteToRentalsShow() {
        assertRouteExists("Rentals", "show", RentalsController.class);
    }

    @Test
    public void itRendersTheShowViewWithTheRentalModel() {
        Map<String, Object> params = new HashMap<>();
        params.put("rentalId", rental.getId().toString());

        routeRequest("Rentals", "show", params);

        assertViewRendered(ShowRental.class);
    }
}