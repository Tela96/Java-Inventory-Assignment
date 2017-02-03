import java.util.ArrayList;
public class Main
{
    public static void main(String[] args)
    {
        StorageManager sm = new StorageManager();
        StoreCapable sc = new PersistentStore();
        sm.addStorage(sc);
        sm.addCDProduct("kovbojok megamix", 3000, 20);
    }
}
