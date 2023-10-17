package edu.cscc.mvc;

import edu.cscc.mvc.framework.ApplicationView;
import edu.cscc.mvc.framework.MVCContext;

public class EditRental extends ApplicationView {
    /**
     * Sets the context and configures it to exit by default
     * unless a route is specified.
     *
     * @param context The {@link MVCContext}.
     */
    public EditRental(MVCContext context) {
        super(context);
    }

    @Override
    public void show() {

    }
    //This is gonna be the same as create...I think double check everything after fixing create
}
