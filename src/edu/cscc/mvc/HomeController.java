package edu.cscc.mvc;

import edu.cscc.mvc.framework.ApplicationController;
import edu.cscc.mvc.framework.MVCContext;

public class HomeController extends ApplicationController {
    public HomeController(MVCContext context) {
        super(context);
    }

    public void index() {
        render(new HomeIndex(context));
    }

    public void goodbye() {
        render(new GoodbyeView(context));
    }
}