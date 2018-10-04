package sample;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;


import javax.swing.text.html.ListView;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class MainPage<classes, xStream> {

    @FXML
    private TextField mAddItem;
    @FXML
    private TextField mUpdateItem;
    @FXML
    private TextField mTextToUpdate;
    @FXML
    private TreeView mTreeView;
    @FXML
    private TextField mDeleteItem;




    ArrayList<Items> arrayList = new ArrayList();

    //Adds an item to the database
    public void addItem(MouseEvent mouseEvent) throws Exception {
        arrayList.add(new Items(mAddItem.getText()));
        treeView();
        save();
    }
    //Updates an item from the database
    public void updateItem(MouseEvent mouseEvent) throws Exception {
        for (int i = 0; i < arrayList.size();i++){
            if (arrayList.get(i).getItem().contains(mTextToUpdate.getText())){
                arrayList.get(i).setItem(mUpdateItem.getText());
                System.out.println(arrayList.get(i).getItem());
                treeView();
            }
        }
    }
    //Removes an item from the database
    public void deleteItem(MouseEvent mouseEvent) throws Exception {
        for (int i = 0; i < arrayList.size();i++) {
            if (arrayList.get(i).getItem().contains(mDeleteItem.getText())) {
                arrayList.remove(i);
                treeView();
            }
        }
    }
    //Create treeView
    private void treeView(){
        TreeItem<String> root = new TreeItem();
        for (Items items : arrayList){
            root.getChildren().add(makeBranch(items.getItem()));
        }

        mTreeView.setRoot(root);
    }
    //Create a branch
    private TreeItem<String> makeBranch(String items) {
        TreeItem<String> item = new TreeItem<>(items);
        return item;
    }

    //Load
    @SuppressWarnings("unchecked")
    public void load() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader("ListOfItems.xml"));
        arrayList = (ArrayList<Items>) is.readObject();
        is.close();
    }
    //Save
    public void save() throws Exception
    {
        XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter("ListOfItems.xml"));
        out.writeObject(arrayList);
        out.close();
    }

    public void loadData(MouseEvent mouseEvent) throws Exception {
        load();
    }
}
