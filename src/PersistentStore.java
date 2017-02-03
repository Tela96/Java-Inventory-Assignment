import java.util.ArrayList;

/**
 * Created by akos on 2017.02.02..
 */
public class PersistentStore extends Store {
    private ArrayList<Product> productArrayList;

    public ArrayList<Product> getProductArrayList()
    {
        return productArrayList;
    }
    public void storeProduct(Product product)
    {
        productArrayList.add(product);
    }
    public ArrayList<Product> getAllProduct()
    {
        ArrayList<Product> products = getProductArrayList();
        return products;
    }

}
