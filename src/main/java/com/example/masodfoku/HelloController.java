package com.example.masodfoku;

import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;

public class HelloController {
    @FXML
    private Spinner<Integer> bevitelA;
    @FXML
    private Spinner<Integer> bevitelB;
    @FXML
    private Spinner<Integer> bevitelC;
    @FXML
    private Label lblEredmeny;
    @FXML
    private Button btnSzamol;

    public void clickSzamol() {
        try {
            int a = bevitelA.getValue();
            int b = bevitelB.getValue();
            int c = bevitelC.getValue();

            int d = (int) Math.pow(b, 2) - 4 * a * c;

            b *= -1;
            double eredmeny = (b + Math.sqrt(d)) / (2 * a);

            if (d < 0) {
                lblEredmeny.setText("Nem oldható meg a valós számok halmazán");
            } else if (d == 0) {
                lblEredmeny.setText("x1 = x2 = " + eredmeny);
            } else {
                double eredmeny2 = (b - Math.sqrt(d)) / (2 * a);
                lblEredmeny.setText("x1 = " + eredmeny + "\n" + "x2 = " + eredmeny2);
            }
        } catch (NumberFormatException e) {
            Alert hibauzenet = new Alert(Alert.AlertType.NONE);
            hibauzenet.setTitle("Hiba");
            hibauzenet.setContentText("Számot adjon meg!");
            hibauzenet.getButtonTypes().add(ButtonType.CLOSE);
        }
    }
}