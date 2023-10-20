package edu.cscc.mvc;

import edu.cscc.mvc.domain.Format;
import edu.cscc.mvc.domain.Genre;
import edu.cscc.mvc.domain.Rental;
import edu.cscc.mvc.domain.RentalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
    public void itCanRouteToCreate() {
        assertRouteExists("Rentals", "create", RentalsController.class);
    }
    @Test
    public void itRendersTheCreateRentalsView() {
        routeRequest("Rentals", "create");

        assertViewRendered(CreateRental.class);
    }
    @Test
    public void itCanRouteToList() {
        routeRequest("Rentals", "list");

        assertViewRendered(ListRentals.class);
    }
    @Test
    public void itRendersTheListView() {
        routeRequest("Rentals", "list");

        assertViewRendered(ListRentals.class);
    }

    @Test
    public void itRendersTheShowRentalIndexView() {
        routeRequest("Rentals", "create");

        assertViewRendered(CreateRental.class);
    }
    @Test
    public void itCanRouteToRentalsIndex() {
        assertRouteExists("Rentals", "index", RentalsController.class);
    }
    @Test
    public void itRendersTheRentalsIndexView() {
        routeRequest("Rentals", "index");

        assertViewRendered(RentalsIndex.class);
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

    @Test
    public void itCanRouteToSaveRental() {
        assertRouteExists("Rentals", "save", RentalsController.class);
    }
    @Test
    public void itRendersTheSaveRentalIndexView() {

        Map<String, Object> params = new HashMap<>();
        params.put("rentalId", rental.getId().toString());
        routeRequest("Rentals", "show", params);

        assertViewRendered(ShowRental.class);
    }

}