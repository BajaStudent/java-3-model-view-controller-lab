package edu.cscc.mvc;

import edu.cscc.mvc.domain.Rental;
import edu.cscc.mvc.framework.ApplicationView;
import edu.cscc.mvc.framework.MVCContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SelectRentalForDelete extends ApplicationView {
    private Rental rental;
    /**
     * Sets the context and configures it to exit by default
     * unless a route is specified.
     *
     * @param context The {@link MVCContext}.
     */
    public SelectRentalForDelete(MVCContext context) {
        super(context);
    }

    @Override
    public void show() {
        Map params = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Rental ID: ");
        String rentalId = scanner.nextLine();
        params.put("rentalId", rentalId);

        route("ManageRental", "deleteRental",params);
    }
}
