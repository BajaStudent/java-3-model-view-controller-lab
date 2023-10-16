package edu.cscc.mvc;

import edu.cscc.mvc.domain.Rental;
import edu.cscc.mvc.domain.RentalRepository;
import edu.cscc.mvc.domain.RentalRepositoryImpl;
import edu.cscc.mvc.framework.ApplicationController;
import edu.cscc.mvc.framework.MVCContext;
import edu.cscc.mvc.framework.Request;

import java.util.UUID;

public class RentalsController extends ApplicationController {
    public RentalsController(MVCContext context) {
        super(context);
    }

    public void select() {
        render(new RentalsIndex(context));
    }

    public void show() {
        Rental rental = RentalRepositoryImpl.instance.read(getRentalIdFromParams());
        render(new ShowRental(context, rental));
    }

    private UUID getRentalIdFromParams() {
        return UUID.fromString((String) getRequest().getParams().get("orderId"));
    }

    private Request getRequest() {
        return context.getRequest();
    }

    public void save(Rental rental){
        return;//TODO how to save?
    }
}



}
