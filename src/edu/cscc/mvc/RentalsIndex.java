package edu.cscc.mvc;

import edu.cscc.mvc.framework.ApplicationView;
import edu.cscc.mvc.framework.MVCContext;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RentalsIndex extends ApplicationView {
    public RentalsIndex(MVCContext context) {
        super(context);
    }

    @Override
    public void show() {
        System.out.println("Rental Management");
        System.out.println("1. List rentals.");
        System.out.println("2. Create a rental");
        System.out.println("3. Select a rental");
        System.out.println("4. Main Menu");
        Scanner scanner = new Scanner(System.in);
        try {
            int choice = scanner.nextInt();
            switch(choice) {
                case 1:
                    route("Rentals", "list");
                    break;
                case 2:
                    route("Rentals", "create");
                    break;
                case 3:
                    route("Rentals", "select");
                    break;
                case 4:
                    route("Home", "index");
                    break;
            }
        } catch (InputMismatchException ex) {
            route("Rentals", "index");
        }
    }
}
