package JAVAFxTable;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Product {
    protected SimpleStringProperty productName;
    protected SimpleDoubleProperty productPrice;
    protected SimpleIntegerProperty productQuantity;

    public Product() {

    }

    public Product(String productName, double productPrice, int productQuantity) {
        this.productName = new SimpleStringProperty(productName);
        this.productPrice = new SimpleDoubleProperty( productPrice);
        this.productQuantity = new SimpleIntegerProperty( productQuantity);
    }

    public String getProductName() {
        return productName.get();
    }

    public void setProductName(String productName) {
        this.productName = new SimpleStringProperty(productName);
    }

    public double getProductPrice() {
        return productPrice.get();
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = new SimpleDoubleProperty(productPrice);
    }

    public int getProductQuantity() {
        return productQuantity.get();
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = new SimpleIntegerProperty(productQuantity);
    }
    public String toString()
    {
        return String.format("%s %s", productName, productPrice,productQuantity);
    }
}
