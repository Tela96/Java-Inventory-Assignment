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
         Product cd = ((Store) storage).createProduct("CD", name, price, tracks);
        ((Store) storage).store(cd);
    }

    public void addBookProduct(String name, int price, int size)
    {
        Product book = ((Store) storage).createProduct("Book", name, price, size);
        ((Store) storage).store(book);
    }

    public void listProducts() {
        ArrayList<Product> listToPrint = ((PersistentStore)storage).getProductArrayList();
        for(Product i : listToPrint)
        {
            System.out.println(i.getName() + " " + i.getPrice());
        }
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
