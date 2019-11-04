package WS_07_MVC;

import WS_07_MVC.controller.Controller;
import WS_07_MVC.model.Model;
import WS_07_MVC.view.View;

import javax.swing.*;

public class Application {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(()-> runApp());



    }


    public static void runApp(){
        Model model = new Model();
        View view = new View(model);
        Controller controller = new Controller(model, view);

    }
}
