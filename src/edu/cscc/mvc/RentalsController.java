package edu.cscc.mvc;

import edu.cscc.mvc.domain.*;
import edu.cscc.mvc.framework.ApplicationController;
import edu.cscc.mvc.framework.MVCContext;
import edu.cscc.mvc.framework.Request;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class RentalsController extends ApplicationController {
    private final RentalRepository rentalRepository;
    public RentalsController(MVCContext context) {
        super(context);
        rentalRepository = RentalRepository.getInstance();
    }

    public void create(){
        render(new CreateRental(context, UUID.randomUUID()));
    }
    public void list(){
        List<Rental> rentals = rentalRepository.readAll();
        render(new ListRentals(context, rentals));
    }
    public void index() {

        render(new RentalsIndex(context));
    }


    public void show() {
        Rental rental = RentalRepository.getInstance().read(getRentalIdFromParams());
        render(new ShowRental(context, rental));
    }




    private UUID getRentalIdFromParams() {
        return UUID.fromString((String) getRequest().getParams().get("rentalId"));
    }

    private Request getRequest() {
        return context.getRequest();
    }

    public void save(){
        Rental rental = new Rental();

        rental.setName((String) getRequest().getParams().get("rentalName"));
        rental.setFormat(getFormatFromString(getRequest().getParams().get("rentalFormat").toString()));
        rental.setGenre( getGenreFromString(getRequest().getParams().get("rentalGenre").toString()));
        rental.setDirector((String) getRequest().getParams().get("rentalDirector"));
        rental.setYear((String) getRequest().getParams().get("rentalYear"));
        RentalRepository.getInstance().create(rental);

        Map params = new HashMap<>();
        params.put("rentalId", rental.getId());

        render(new ShowRental(context, rental));
    }

    private Genre getGenreFromString(String s){
        switch(s){
            case("1"):
                return Genre.HORROR;
            case("2"):
                return Genre.ACTION;
            case("3"):
                return Genre.COMEDY;
            case ("4"):
                return Genre.DRAMA;
            case("5"):
                return Genre.ROMANCE;
            default:
                return null;
        }
    }

    private Format getFormatFromString(String s){
        switch(s){
            case("1"):
                return Format.DVD;
            case("2"):
                return Format.VHS;
            case("3"):
                return Format.BLU_RAY;
            default:
                return null;
        }
    }
}

