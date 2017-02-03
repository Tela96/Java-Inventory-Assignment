import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.ArrayList;

public abstract class Store implements StoreCapable
{
    private String filename = "products.xml";
    private void saveToXML(Product product)
        {
            File xmlFile = new File(filename);
            try
            {
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

                Document doc;
                Element rootElement;
                if(xmlFile.exists())
                {
                    doc = dBuilder.parse(xmlFile);
                    rootElement = doc.getDocumentElement();
                }
                else
                {
                    doc = dBuilder.newDocument();
                    rootElement = doc.createElement("Products");
                    doc.appendChild(rootElement);
                }
                Element name = doc.createElement("Product");
                rootElement.appendChild(name);

                Attr attr = doc.createAttribute("Name");
                attr.setValue(product.name);
                name.setAttributeNode(attr);
                Attr attr2 = doc.createAttribute("Price");
                attr2.setValue(product.price.toString());
                name.setAttributeNode(attr2);

                TransformerFactory transformerFactory = TransformerFactory.newInstance();
                Transformer transformer = transformerFactory.newTransformer();
                DOMSource source = new DOMSource(doc);
                StreamResult result = new StreamResult(new File(filename));
                transformer.transform(source, result);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
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

    public ArrayList<Product> loadProducts()
    {
        ArrayList<Product> products = new ArrayList<>();
        try
        {
            File file = new File(filename);
            DocumentBuilderFactory dBF = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuild = dBF.newDocumentBuilder();
            Document doc = dBuild.parse(file);
            doc.getDocumentElement().normalize();
            NodeList nodes = doc.getElementsByTagName("Product");
            for(int i = 0; i<nodes.getLength(); i++)
            {
                Node node = nodes.item(i);
                String name = ((Element)node).getAttribute("Name");
                String priceStr = ((Element)node).getAttribute("Price");
                int price = Integer.parseInt(priceStr);
                Product product = createProduct(" ", name, price, 0 );
                products.add(product);
            }
            return products;
        }
        catch(Exception e)
        {
            System.out.println("File not found");
        }
        return null;
    }

    public void store(Product product)
    {
        storeProduct(product);
        saveToXML(product);
    }
   public void storeCDProduct(String name, int price, int tracks)
   {
       Product cd = createProduct("CD", name, price, tracks);
       store(cd);



   }

   public void storeBookProduct(String name, int price, int size)
   {
       Product book = createProduct("Book", name, price, size);
       store(book);
   }
}
