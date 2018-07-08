package JAVAFxTable;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{
    public TableView<Product> tableview;

    public TableColumn<Product,String> colName;
    public TableColumn<Product,Double> colPrice;
    public TableColumn<Product,Integer> colQuantity;
    public TextField textfieldName;
    public TextField textfieldPrice;
    public TextField textfieldQuantity;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colName.setCellValueFactory(new PropertyValueFactory<>("ProductName"));
        colPrice.setCellValueFactory(new PropertyValueFactory<>("ProductPrice"));
        colQuantity.setCellValueFactory(new PropertyValueFactory<>("ProductQuantity"));
        tableview.setItems(observableList);

        tableview.setEditable(true);
        colName.setCellFactory(TextFieldTableCell.forTableColumn());

        tableview.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableview.getSelectionModel().setCellSelectionEnabled(true);
    }

    ObservableList<Product> observableList= FXCollections.observableArrayList(
            new Product("torab",24.1,18),
            new Product("kabir",42.1,0)
    );

    public void buttonAdd(ActionEvent actionEvent) {
        Product product=new Product(textfieldName.getText(),Double.parseDouble( textfieldPrice.getText()),Integer.parseInt(textfieldQuantity.getText()));
        tableview.getItems().add(product);
    }

    public void buttonSHow(ActionEvent actionEvent) {
       /* Product product =new Product();

        List <List<String>> arrList=new ArrayList<>();

        for (int i = 0; i <tableview.getItems().size() ; i++) {
            product=tableview.getItems().get(i);
            arrList.add(new ArrayList<>());
            arrList.get(i).add(product.productName.get());
            arrList.get(i).add(""+product.productPrice.get());
            arrList.get(i).add(""+product.productQuantity.get());

        }

        for (int i = 0; i < arrList.size(); i++) {
            for (int j = 0; j < arrList.get(i).size(); j++) {
                System.out.print(arrList.get(i).get(j)+" ");
            }
            System.out.println();
        }

*/
        //show just one selected row
      /*  ObservableList<Product> productslist;
        productslist=tableview.getSelectionModel().getSelectedItems();

        System.out.println(productslist.get(0).getProductPrice());

*/

    }



    public void buttonRemove(ActionEvent actionEvent) {

        ObservableList<Product> allProduct,SingleProduct;
        allProduct=tableview.getItems();
        SingleProduct=tableview.getSelectionModel().getSelectedItems();
        SingleProduct.forEach(allProduct::remove);
/*
        Product userReq;
        int index = tableview.getSelectionModel().selectedIndexProperty().get();
        userReq=tableview.getItems().get(index);*/
    }


    public void onEditChanged(TableColumn.CellEditEvent<Product,String> productStringCellEditEvent) {
        Product product=tableview.getSelectionModel().getSelectedItem();
        product.setProductName(productStringCellEditEvent.getNewValue());
    }

    public void clickedColumn(MouseEvent event) {
        TablePosition tablePosition=tableview.getSelectionModel().getSelectedCells().get(0);
        int row=tablePosition.getRow();
        Product item=tableview.getItems().get(row);
        TableColumn tableColumn=tablePosition.getTableColumn();
        String data= (String) tableColumn.getCellObservableValue(item).getValue();
        System.out.println(data);
    }
}
