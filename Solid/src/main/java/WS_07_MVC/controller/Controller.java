package WS_07_MVC.controller;

import WS_07_MVC.model.Model;
import WS_07_MVC.view.View;

public class Controller {

    private Model model;
    private View view;


    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }


}
