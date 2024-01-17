import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class Invoice {
    private double total;
    private List<Item> itemsSold = new ArrayList<Item>();
    private Customer customer;
    private Store store;
    private String date;
    private String template = "%-28s %41.2f %n";

    public Invoice(Customer c, Store s) {
        this.customer=c;
        this.store=s;
        LocalDate d=LocalDate.now();
        this.date=LocalDate.parse(d.toString(), DateTimeFormatter.ofPattern("yyyy-MM-dd")).format(DateTimeFormatter.ofPattern("dd-MMM-yyyy"));
        this.total=0.00;
    }

    public void addItem(Item item) throws Exception {
        if(item.getQuantity()!=0) {
            this.itemsSold.add(item);
            for(int i = 0; i < this.store.getItems().size(); i++) {
                if(this.store.getItem(i) == item) {
                    int newQuantity = this.store.getItem(i).getQuantity()-1;
                    this.store.getItem(i).setQuantity(newQuantity);
                }
            }
        }
        else {
            throw new Exception("Item is not available.");
        }
    }

    public void displayInvoice() {
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("Store Name: %s %n", this.store.getName());
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("Name: %s, %s %n", this.customer.getLastName(), this.customer.getFirstName());
        System.out.printf("E-mail: %s %n", this.customer.getEmailAddress());
        System.out.printf("Phone: %s %n", this.customer.getPhoneNumber());
        System.out.printf("Purchase Date: %s %n",this.date);
        System.out.println("----------------------------------------------------------------------");
        for (int i = 0; i < this.itemsSold.size(); i++) {
            String temp = this.itemsSold.get(i).getManufacturer() + " " + this.itemsSold.get(i).getModel();
            System.out.printf(this.template, temp, this.itemsSold.get(i).getPrice());
            this.total+=this.itemsSold.get(i).getPrice();
        }
        System.out.println("----------------------------------------------------------------------");
        System.out.printf("%-7s %62.2f %n", "Total: ", this.total);
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public double getTotal() {
        return this.total;
    }

    public String getDate() {
        return this.date;
    }

    public List<Item> getItems() {
        return this.itemsSold;
    }

    public Item getItem(int index) {
        return this.itemsSold.get(index);
    }
}
