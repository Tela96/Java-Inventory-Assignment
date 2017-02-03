/**
 * Created by akos on 2017.02.02..
 */
public class BookProduct extends Product {
    public int pageSize;

    public BookProduct(String name, Integer size, int pageSize)
    {
        super(name, size);
        this.pageSize = pageSize;
    }
}
