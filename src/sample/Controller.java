package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Controller {

    @FXML
    public TextField mUserName;

    @FXML
    public TextField mPassword;

    ArrayList ArraylistUsers = new ArrayList();

    public void mSignIn(javafx.scene.input.MouseEvent mouseEvent) {
        if (ArraylistUsers.contains(mUserName.getText()) && ArraylistUsers.contains(mPassword.getText())){

        }
    }


    public void mCreateAccount(ActionEvent actionEvent) {

    }
}
