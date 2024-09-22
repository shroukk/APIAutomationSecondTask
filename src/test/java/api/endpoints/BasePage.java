package api.endpoints;

import java.util.ResourceBundle;

public class BasePage {

    public static ResourceBundle getURL(){
        ResourceBundle routes = ResourceBundle.getBundle("routes");
        return routes;
    }
    public static ResourceBundle getData(){
        ResourceBundle userData = ResourceBundle.getBundle("config");
        return userData;
    }
}
