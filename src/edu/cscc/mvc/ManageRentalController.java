package edu.cscc.mvc;

import edu.cscc.mvc.domain.*;
import edu.cscc.mvc.framework.ApplicationController;
import edu.cscc.mvc.framework.MVCContext;
import edu.cscc.mvc.framework.Request;

import java.util.UUID;

public class ManageRentalController extends ApplicationController {
    private final RentalRepository rentalRepository;

    public ManageRentalController(MVCContext context) {
        super(context);
        this.rentalRepository = RentalRepository.getInstance();
    }
    public void index(){
        render(new ManageRentalIndex(context));
    }
    public void selectRentalForUpdate() {
        render(new SelectRentalForUpdate(context));
    }

    public void editRental(){
        Rental rental = RentalRepository.getInstance().read(getRentalIdFromParams());
        render(new EditRental(context, rental));
    }

    public void deleteRental(){
        Rental rental = RentalRepository.getInstance().read(getRentalIdFromParams());
        render(new DeleteRental(context, rental));
    }

    public void save(){
        Rental rental = new Rental();

        rental.setId(UUID.fromString((String) getRequest().getParams().get("rentalID").toString()));
        rental.setName((String) getRequest().getParams().get("rentalName"));
        rental.setFormat(getFormatFromString(getRequest().getParams().get("rentalFormat").toString()));
        rental.setGenre( getGenreFromString(getRequest().getParams().get("rentalGenre").toString()));
        rental.setDirector((String) getRequest().getParams().get("rentalDirector"));
        rental.setYear((String) getRequest().getParams().get("rentalYear"));
        RentalRepository.getInstance().update(rental);
        render(new ShowRental(context, rental));
    }


    private UUID getRentalIdFromParams() {
        return UUID.fromString((String) getRequest().getParams().get("rentalId"));
    }

    private Request getRequest() {
        return context.getRequest();
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