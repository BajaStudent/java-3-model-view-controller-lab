package edu.cscc.mvc;

import edu.cscc.mvc.framework.ApplicationView;
import edu.cscc.mvc.framework.MVCContext;

import java.util.UUID;

public class SelectRental extends ApplicationView {

    private UUID uuid;
    /**
     * Sets the context and configures it to exit by default
     * unless a route is specified.
     *
     * @param context The {@link MVCContext}.
     */
    public SelectRental(MVCContext context, UUID uuid) {
        super(context);
        this.uuid = uuid;
    }

    @Override
    public void show() {
        System.out.println("Rental ID: ");

        route("Rentals", "show");
    }
}
