package edu.cscc.mvc;

import edu.cscc.mvc.domain.Rental;
import edu.cscc.mvc.framework.ApplicationView;
import edu.cscc.mvc.framework.MVCContext;

import java.util.ArrayList;
import java.util.List;

public class ListRentals extends ApplicationView {
   private List<Rental> rentals = new ArrayList<>();
    /**
     * Sets the context and configures it to exit by default
     * unless a route is specified.
     *
     * @param context The {@link MVCContext}.
     * @param rentals
     */
    public ListRentals(MVCContext context, List<Rental> rentals) {
        super(context);
        this.rentals = rentals;
    }

    @Override
    public void show() {
        for (int i = 0; i < rentals.size(); i++) {
            System.out.println("*******************");
            System.out.println("Id: " + rentals.get(i).getId());
            System.out.println("Name: " + rentals.get(i).getName());
            System.out.println("Format: " + rentals.get(i).getFormat());
            System.out.println("Genre: " + rentals.get(i).getGenre());
            System.out.println("Director: " + rentals.get(i).getDirector());
            System.out.println("Year: " + rentals.get(i).getYear());
        }
        route("Rentals", "index");
    }
}
