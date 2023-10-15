package edu.cscc.mvc;

import edu.cscc.mvc.framework.MVCContext;
import edu.cscc.mvc.framework.Request;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) {
        MVCContext context = new MVCContext();

        try {
            context.processRequest(new Request("Home", "index"));
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
