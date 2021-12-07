package com.example.masodfoku;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;



public class HelloController {
    @FXML
    private Spinner<Integer> bevitelA, bevitelB, bevitelC;
    @FXML
    private Label lblEredmeny;
    @FXML
    private Button btnSzamol;
    int a, b, c;

    public void clickSzamol() {
        try {
            a = bevitelA.getValue();
            b = bevitelB.getValue();
            c = bevitelC.getValue();


            int d = (int) Math.pow(b, 2) - 4 * a * c;

            b *= -1;
            double eredmeny = (b + Math.sqrt(d)) / (2 * a);

            if (d < 0) {
                lblEredmeny.setText("Nem oldható meg a valós számok halmazán");
            } else if (d == 0) {
                lblEredmeny.setText("x1 = x2 = " + eredmeny);
            } else {
                double eredmeny2 = (b - Math.sqrt(d)) / (2 * a);
                lblEredmeny.setText(String.format("x1 = %.2f\n x2 = %.2f", eredmeny, eredmeny2));
            }
        } catch (NullPointerException e) {
            Alert felugroAblak = new Alert(Alert.AlertType.ERROR, "Minden mező kitöltése kötelező");
            felugroAblak.show();
        } catch (NumberFormatException e) {
            Alert felugroAblak = new Alert(Alert.AlertType.ERROR, "Egész szémot adjon meg");
            felugroAblak.show();
        }
    }
}