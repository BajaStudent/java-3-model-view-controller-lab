package edu.cscc.mvc;

import edu.cscc.mvc.domain.*;
import edu.cscc.mvc.framework.ApplicationController;
import edu.cscc.mvc.framework.MVCContext;
import edu.cscc.mvc.framework.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RentalsController extends ApplicationController {
    private final RentalRepository rentalRepository;
    public RentalsController(MVCContext context) {
        super(context);
        rentalRepository = RentalRepository.getInstance();
    }
    public void list(){
        List<Rental> rentals = rentalRepository.readAll();
        render(new ListRentals(context, rentals));
    }
    public void index() {

        render(new RentalsIndex(context));
    }
    public void select() {
        render(new SelectRental(context));
    }

    public void show() {
        Rental rental = RentalRepository.getInstance().read(getRentalIdFromParams());
        render(new ShowRental(context, rental));
    }

    private UUID getRentalIdFromParams() {
        return UUID.fromString((String) getRequest().getParams().get("rentalId"));
    }

    private Request getRequest() {
        return context.getRequest();
    }

    public void save(){
        Rental rental = new Rental();

        rental.setName((String) getRequest().getParams().get("rentalName"));
        rental.setFormat((Format) getRequest().getParams().get("rentalFormat"));
        rental.setGenre((Genre) getRequest().getParams().get("rentalGenre"));
        rental.setDirector((String) getRequest().getParams().get("rentalDirector"));
        rental.setDirector((String) getRequest().getParams().get("rentalYear"));
        RentalRepository.getInstance().create(rental);

        Map params = new HashMap<>();
        params.put("rentalId", rental.getId());

        context.route(new Request("Rentals", "index", params));
    }
}

