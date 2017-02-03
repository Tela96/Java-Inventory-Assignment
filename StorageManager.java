import java.util.ArrayList;

/**
 * Created by akos on 2017.02.02..
 */

public class StorageManager {
    private StoreCapable storage;
    public void addStorage(StoreCapable storage)
    {
        this.storage = storage;
    }

    public void addCDProduct(String name, int price, int tracks)
    {
        storage.storeCDProduct(name, price, tracks);
    }

    public void addBookProduct(String name, int price, int size)
    {
        storage.storeBookProduct(name, price, size);
    }

    public String listProducts() {
        ArrayList<Product> listToPrint =((Store)storage).loadProducts();
        for(Product product : listToPrint)
        {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
        return "Products loaded to list";
    }

    public int getTotalProductPrice() {
        int totalPrice = 0;
        ArrayList<Product> products = ((PersistentStore)storage).getProductArrayList();
        for(Product i : products)
        {
            totalPrice += i.getPrice();
        }
        return totalPrice;
    }
}
