package edu.cscc.mvc;

import edu.cscc.mvc.domain.Rental;
import edu.cscc.mvc.framework.ApplicationController;
import edu.cscc.mvc.framework.ApplicationView;
import edu.cscc.mvc.framework.MVCContext;

import java.util.HashMap;
import java.util.Map;

public class ShowRental extends ApplicationView {
    private Rental rental;
    public ShowRental(MVCContext context, Rental rental) {
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
        params.put("orderId", rental.getId());
        route("Rentals", "index", params);

    }

    public Rental getRental(){
        return rental;
    }
}