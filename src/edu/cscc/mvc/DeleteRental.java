package edu.cscc.mvc;

import edu.cscc.mvc.domain.Rental;
import edu.cscc.mvc.domain.RentalRepository;
import edu.cscc.mvc.framework.ApplicationView;
import edu.cscc.mvc.framework.MVCContext;

public class DeleteRental extends ApplicationView {
    private Rental rental;
    public DeleteRental(MVCContext context, Rental rental) {
        super(context);
        this.rental = rental;
    }

    @Override
    public void show() {
        System.out.println("****************************");
        System.out.println("Deleting: " + rental.getId());
        System.out.println("****************************");

        RentalRepository.getInstance().delete(rental.getId());

        route("Rentals", "index");
    }
}
