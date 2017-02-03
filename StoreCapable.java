/**
 * Created by akos on 2017.02.02..
 */
import java.util.ArrayList;

public interface StoreCapable {
    ArrayList<Product> getAllProduct();

    void storeCDProduct(String name, int price, int tracks);

    void storeBookProduct(String name, int price, int size);

}
