package edu.cscc.mvc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import edu.cscc.mvc.domain.Format;
import edu.cscc.mvc.domain.Genre;
import edu.cscc.mvc.domain.Rental;
import edu.cscc.mvc.domain.RentalRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

class ManageRentalControllerTest extends MVCTest{
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
    public void itCanRouteToIndex() {
        assertRouteExists("ManageRental", "index", ManageRentalController.class);
    }
    @Test
    public void itRendersTheManageRentalIndexView() {
        routeRequest("ManageRental", "index");

        assertViewRendered(ManageRentalIndex.class);
    }

    @Test
    public void itCanRouteToEditRental() {
        assertRouteExists("ManageRental", "editRental", ManageRentalController.class);
    }
    @Test
    public void itRendersTheEditRentalIndexView() {

        Map<String, Object> params = new HashMap<>();
        params.put("rentalId", rental.getId().toString());
        routeRequest("ManageRental", "editRental", params);

        assertViewRendered(EditRental.class);
    }

    @Test
    public void itCanRouteToDeleteRental() {
        assertRouteExists("ManageRental", "deleteRental", ManageRentalController.class);
    }
    @Test
    public void itRendersTheDeleteRentalIndexView() {

        Map<String, Object> params = new HashMap<>();
        params.put("rentalId", rental.getId().toString());
        routeRequest("ManageRental", "deleteRental", params);

        assertViewRendered(DeleteRental.class);
    }

    @Test
    public void itCanRouteToSaveRental() {
        assertRouteExists("ManageRental", "save", ManageRentalController.class);
    }
    @Test
    public void itRendersTheSaveRentalIndexView() {

        Map<String, Object> params = new HashMap<>();
        params.put("rentalId", rental.getId().toString());
        routeRequest("Rentals", "show", params);

        assertViewRendered(ShowRental.class);
    }
}