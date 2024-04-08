import java.util.List;
import java.util.ArrayList;

class ProductGroup {
    private String groupName;
    private String groupDescription;
    private List<Product> products;

    public ProductGroup(String groupName, String groupDescription) {
        this.groupName = groupName;
        this.groupDescription = groupDescription;
        this.products = new ArrayList<>();
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void editProductInformation(Product product, String productName, String description, String manufacturer, int quantity, double price) {
        product = new Product(productName, description, manufacturer, quantity, price);
    }

    public void addNewProduct(String productName, String description, String manufacturer, int quantity, double price) {
        products.add(new Product(productName, description, manufacturer, quantity, price));
    }
}
