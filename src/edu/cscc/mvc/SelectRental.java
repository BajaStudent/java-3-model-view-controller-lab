package edu.cscc.mvc;

import edu.cscc.mvc.framework.ApplicationView;
import edu.cscc.mvc.framework.MVCContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.UUID;

public class SelectRental extends ApplicationView {

    /**
     * Sets the context and configures it to exit by default
     * unless a route is specified.
     *
     * @param context The {@link MVCContext}.
     */
    public SelectRental(MVCContext context) {
        super(context);
    }

    @Override
    public void show() {
        Map params = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rental ID: ");

        String rentalId = scanner.nextLine();
        params.put("rentalId", rentalId);

        route("Rentals", "show",params);
    }
}
