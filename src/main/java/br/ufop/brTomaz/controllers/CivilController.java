package br.ufop.brTomaz.controllers;

import br.ufop.brTomaz.model.entities.Civil;
import br.ufop.brTomaz.util.Singleton;
import br.ufop.brTomaz.util.Utils;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class CivilController implements Initializable {
    @FXML
    private JFXTextField txtCEP;

    @FXML
    private JFXTextField txtStreet;

    @FXML
    private JFXTextField txtBairro;

    @FXML
    private JFXTextField txtNumber;

    @FXML
    private JFXTextField txtCity;

    @FXML
    private JFXComboBox<String> cmbState;

    @FXML
    private JFXButton btnNext;

    @FXML
    private Pane contentArea;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void backPage(MouseEvent mouseEvent) throws IOException {
        Utils.setView("/views/WitnessView.fxml", contentArea);
    }

    public void nextPage(ActionEvent actionEvent) throws IOException {
        String CEP = txtCEP.getText();
        String street = txtStreet.getText();
        String bairro = txtBairro.getText();
        String number = txtNumber.getText();
        String city = txtCity.getText();
        String state = cmbState.getSelectionModel().getSelectedItem();

        String place = CEP + " - " + street +  " - " + bairro + " - " + number +
                " - " + city + " - " + state;

        Civil civil = new Civil(place, new Date());
        Singleton.getInstance().setCivil(civil);

        Utils.setView("/views/MarriageView.fxml", contentArea);
    }

    public void closeApp(MouseEvent mouseEvent) {
        System.exit(0);
    }
}
