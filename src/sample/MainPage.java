package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.input.MouseEvent;


import javax.swing.text.html.ListView;
import java.util.ArrayList;

public class MainPage {

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
    public void addItem(MouseEvent mouseEvent) {
        arrayList.add(new Items(mAddItem.getText()));
        treeView();
    }
    //Updates an item from the database
    public void updateItem(MouseEvent mouseEvent) {
        for (int i = 0; i < arrayList.size();i++){
            if (arrayList.get(i).getItem().contains(mTextToUpdate.getText())){
                arrayList.get(i).setItem(mUpdateItem.getText());
            }
        }
    }
    //Removes an item from the database
    public void deleteItem(MouseEvent mouseEvent) {
        for (int i = 0; i < arrayList.size();i++)
        if (arrayList.get(i).getItem().contains(mDeleteItem.getText())){
            arrayList.remove(new Items(mDeleteItem.getText()));
            System.out.print("Success");
        }
    }
    //Create treeView
    private void treeView(){
        TreeItem<String> root = new TreeItem<>();
        for (Items items : arrayList){
            root = makeBranch(items.getItem());
            mTreeView = new TreeView(root);
            mTreeView.setShowRoot(false);
            System.out.print("make it here");
        }
    }
    //Create a branch
    private TreeItem<String> makeBranch(String items) {
        TreeItem<String> item = new TreeItem<>(items);
        return item;
    }
}
