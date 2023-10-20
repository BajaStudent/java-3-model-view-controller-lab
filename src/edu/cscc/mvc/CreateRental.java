package edu.cscc.mvc;

import edu.cscc.mvc.framework.ApplicationView;
import edu.cscc.mvc.framework.MVCContext;

import java.util.*;

public class CreateRental extends ApplicationView {
    private UUID rentalID;
    /**
     * Sets the context and configures it to exit by default
     * unless a route is specified.
     *
     * @param context The {@link MVCContext}.
     */
    public CreateRental(MVCContext context, UUID rentalID) {
        super(context);
        this.rentalID = rentalID;
    }

    @Override
    public void show() {
        Scanner scanner = new Scanner(System.in);
        Map params = new HashMap<>();
        try {
            params.put("rentalID", rentalID);

            System.out.println("Create a Rental:\n****************");

            System.out.println("Name: ");
            String rentalName = scanner.nextLine();
            params.put("rentalName", rentalName);

            System.out.println("Format: ");
            System.out.println( "\t1. DVD" );
            System.out.println("\t2. VHS");
            System.out.println("\t3. BLU_RAY");
            System.out.println("Choice: ");
            String rentalFormat = scanner.nextLine();
            params.put("rentalFormat", rentalFormat);

            System.out.println("Genre:");
            System.out.println("\t1. HORROR");
            System.out.println("\t2. ACTION");
            System.out.println("\t2. ACTION");
            System.out.println("\t3. COMEDY");
            System.out.println("\t4. DRAMA");
            System.out.println("\t5. ROMANCE");
            System.out.println("Choice: ");
            String rentalGenre = scanner.nextLine();
            params.put("rentalGenre", rentalGenre);

            System.out.println("Director: ");
            String rentalDirector = scanner.nextLine();
            params.put("rentalDirector", rentalDirector);

            System.out.println("Year: ");
            String rentalYear = scanner.nextLine();
            params.put("rentalYear", rentalYear);

            route("Rentals", "save",params);
        }catch (InputMismatchException e){
            route("Rentals", "index");
        }
    }
}
