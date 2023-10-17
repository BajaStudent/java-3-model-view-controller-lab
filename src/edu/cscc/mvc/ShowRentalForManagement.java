package edu.cscc.mvc;

import edu.cscc.mvc.domain.Rental;
import edu.cscc.mvc.framework.ApplicationView;
import edu.cscc.mvc.framework.MVCContext;

import java.util.HashMap;
import java.util.Map;

public class ShowRentalForManagement extends ApplicationView {
    private Rental rental;
    public ShowRentalForManagement(MVCContext context, Rental rental) {
        super(context);
        this.rental = rental;
    }

    @Override
    public void show() {
        System.out.println("************");
        System.out.println("ID  " + rental.getId());
        System.out.println("Name: " + rental.getName());
        System.out.println("Format: " +rental.getFormat() );
        System.out.println("Genre: " + rental.getGenre());
        System.out.println("Director: " + rental.getDirector());
        System.out.println("Year: " + rental.getYear());
        Map params = new HashMap<>();
        params.put("rentalId", rental.getId());
        route("Rentals", "rmIndex", params);

    }

    public Rental getRental(){
        return rental;
    }
}
