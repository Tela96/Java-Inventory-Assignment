/**
 * Created by akos on 2017.02.02..
 */
public abstract class Product {
    public String name;
    public Integer price;

    public Product(String name, Integer price)
    {
        this.name = name;
        this.price = price;
    }
    public String getName()
    {
        return name;
    }
    public int getPrice()
    {
        return price;
    }
}
