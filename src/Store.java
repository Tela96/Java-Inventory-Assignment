/**
 * Created by akos on 2017.02.02..
 */
import java.util.ArrayList;
public abstract class Store implements StoreCapable {
    private void saveToXML(Product product) {
    }

    protected abstract void storeProduct(Product product);

    protected Product createProduct(String type, String name, int price, int size) {
        if(type == "CD")
        {
            Product cd = new CDProduct(name, price, size);
            return cd;

        }
        else
        {
            Product book = new BookProduct(name, price, size);
            return book;
        }
    }

    public ArrayList<Product> loadProducts() {
        return null;
    }

    public void store(Product product)
    {
        saveToXML(product);
    }
   public void storeCDProduct(String name, int price, int tracks)
   {
       Product cd = new CDProduct(name, price, tracks);
       saveToXML(cd);
   }

   public void storeBookProduct(String name, int price, int size)
   {

   }
}
