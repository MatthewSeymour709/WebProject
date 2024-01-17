import java.util.ArrayList;
import java.util.List;

public class Store {
    private String template1 = "%-22s %-27s %-4s %4s %6s %n";
    private String template2 = "%-22s %-27s %-4s %4d %6.2f %n";
    private String name="";
    private List<Item> items = new ArrayList<Item>();

    public Store(String n) {
        this.name=n;
    }

    public void displayInventory() {
        this.inventoryFormatting();
        for (int i=0; i<this.items.size(); i++) {
            System.out.printf(template2, this.items.get(i).getManufacturer(), this.items.get(i).getModel(), this.items.get(i).getType(), this.items.get(i).getQuantity(), this.items.get(i).getPrice());
            System.out.println("\tLocation: " + this.items.get(i).storageLocation(this.items.get(i).getType()));
        }
        System.out.println("----------------------------------------------------------------------");
    }

    public void displayAvailableInventory() {
        this.inventoryFormatting();
        for (int i=0; i<this.items.size(); i++) {
            if (items.get(i).getQuantity() > 0) {
                System.out.printf(template2, this.items.get(i).getManufacturer(), this.items.get(i).getModel(), this.items.get(i).getType(), this.items.get(i).getQuantity(), this.items.get(i).getPrice());
                System.out.println("\tLocation: " + this.items.get(i).storageLocation(this.items.get(i).getType()));
            }
        }
        System.out.println("----------------------------------------------------------------------");
    }

    public void addItem(Item item) {
        this.items.add(item);
    }

    public String getName() {
        return this.name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public Item getItem(int index) {
        return this.items.get(index);
    }

    public List<Item> getItems() {
        return this.items;
    }

    private void inventoryFormatting() {
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("Store Name: %s %n", this.name);
        System.out.println("----------------------------------------------------------------------");
        System.out.printf(template1, "Manufacturer", "Model", "Type", "Qty", "Price");
        System.out.println("----------------------------------------------------------------------");
    }
}
