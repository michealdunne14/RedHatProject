package sample;

import com.sun.net.httpserver.Authenticator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    @FXML
    public TextField mUserName;

    @FXML
    private Text mNoUser;

    @FXML
    public TextField mPassword;

    ArrayList<Users> ArraylistUsers = new ArrayList();

    public void mSignIn(javafx.scene.input.MouseEvent mouseEvent) {
        for (int i = 0; i < ArraylistUsers.size();i++){
            if(ArraylistUsers.get(i).getName().contains(mUserName.getText()) && ArraylistUsers.get(i).getPassword().contains(mPassword.getText())){
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("mainpage.fxml"));

                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load(),600,400);
                Stage stage = new Stage();
                stage.setTitle("Food Items");
                stage.setScene(scene);
                stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                mNoUser.setText("No User Create an Account");
            }
        }
    }


    public void mCreateAccount(ActionEvent actionEvent) {
        ArraylistUsers.add(new Users(mUserName.getText(),mPassword.getText()));
    }
}
