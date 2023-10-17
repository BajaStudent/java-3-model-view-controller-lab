package edu.cscc.mvc;

import edu.cscc.mvc.domain.Rental;
import edu.cscc.mvc.framework.ApplicationView;
import edu.cscc.mvc.framework.MVCContext;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ManageRentalIndex extends ApplicationView {
    private Rental rental;
    /**
     * Sets the context and configures it to exit by default
     * unless a route is specified.
     *
     * @param context The {@link MVCContext}.
     */
    public ManageRentalIndex(MVCContext context, Rental rental) {
        super(context);
        this.rental = rental;
    }

    @Override
    public void show() {
        System.out.println("Manage Rental");
        System.out.println("1. Update rental");
        System.out.println("2. Delete rental");
        System.out.println("3. Rentals Menu");
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    route("Rentals", "edit");
                    break;
                case 2:
                    route("Rentals", "delete");
                    break;
                case 3:
                    route("Rentals", "index");
                    break;
            }
        } catch (InputMismatchException ex) {
            route("Rentals", "show");
        }
    }
}
