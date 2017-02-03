public class Main
{
    public static void main(String[] args)
    {
        StorageManager storageManager = new StorageManager();
        StoreCapable storeInterface = new PersistentStore();
        storageManager.addStorage(storeInterface);
        storageManager.addCDProduct("kovbojok megamix", 3000, 20);
        storageManager.addBookProduct("A halal 50 arnyalata", 4500, 354);
        System.out.println(storageManager.listProducts());
        System.out.println(storageManager.getTotalProductPrice());
    }
}
