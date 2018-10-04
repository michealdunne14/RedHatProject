package sample;

import com.sun.net.httpserver.Authenticator;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;


import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

public class Controller {

    @FXML
    public TextField mUserName;

    @FXML
    private Text mNoUser;

    @FXML
    public TextField mPassword;

    ArrayList<Users> ArraylistUsers = new ArrayList();

    public void mSignIn(javafx.scene.input.MouseEvent mouseEvent) throws Exception {
        load();
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


    public void mCreateAccount(ActionEvent actionEvent) throws Exception {
        ArraylistUsers.add(new Users(mUserName.getText(),mPassword.getText()));
        save();
    }

    //Load
    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream users = xstream.createObjectInputStream(new FileReader("ListOfUsers.xml"));
        ArraylistUsers = (ArrayList<Users>) users.readObject();
        users.close();
    }
    //Save
    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("ListOfUsers.xml"));
        out.writeObject(ArraylistUsers);
        out.close();
    }
}
