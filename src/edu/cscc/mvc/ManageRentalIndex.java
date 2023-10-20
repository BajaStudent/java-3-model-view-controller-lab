package edu.cscc.mvc;

import edu.cscc.mvc.domain.Rental;
import edu.cscc.mvc.framework.ApplicationView;
import edu.cscc.mvc.framework.MVCContext;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class ManageRentalIndex extends ApplicationView {

    public ManageRentalIndex(MVCContext context) {
        super(context);
    }

    @Override
    public void show() {

        System.out.println("************");
        System.out.println("Manage Rental");
        System.out.println("1. Update rental");
        System.out.println("2. Delete rental");
        System.out.println("3. Rentals Menu");
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    route("ManageRental", "selectRentalForUpdate" );
                    break;
                case 2:
                    route("ManageRental", "selectRentalForDelete");
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
