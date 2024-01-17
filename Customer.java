import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String template1 = "%s: %s, %s %35s: %-7.2f %n";
    private String template2 = "%s: %s %23s: %s %n";
    private String firstName="";
    private String lastName="";
    private String emailAddress="";
    private String phoneNumber="";
    private List<Invoice> invoices = new ArrayList<Invoice>();
    private Store store;

    public Customer(String f, String l, String e, String p, Store s) {
        this.firstName=f;
        this.lastName=l;
        this.emailAddress=e;
        this.phoneNumber=p;
        this.store=s;
    }

    public void addInvoice(Invoice invoice) {
        this.invoices.add(invoice);
    }

    public void displayProfile() {
        System.out.println("----------------------------------------------------------------------");
        double t = 0.00;
        for (int i = 0; i < this.invoices.size(); i++) {
            t+= this.invoices.get(i).getTotal();
        }
        System.out.printf(template1, "Name", this.lastName, this.firstName, "Total Sales", t);
        System.out.printf(template2, "E-mail", this.emailAddress, "Store", this.store.getName());
        System.out.printf("%s: %s %n", "Phone", this.phoneNumber);
        System.out.println("----------------------------------------------------------------------");
        for (int i = 0; i < this.invoices.size(); i++) {
            this.invoiceFormatter(i);
        }
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Store getStore() {
        return this.store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    private void invoiceFormatter(int num) {
        System.out.printf("Invoice %d %n", num+1);
        System.out.printf("Purchase Date: %s %n", this.invoices.get(num).getDate());
        System.out.println("Items Purchased");
        for (int i = 0; i < this.invoices.get(num).getItems().size(); i++) {
            String temp = this.invoices.get(num).getItem(i).getManufacturer() + " " + this.invoices.get(num).getItem(i).getModel();
            System.out.printf("\t%-59s %6.2f %n", temp, this.invoices.get(num).getItem(i).getPrice());
        }
        System.out.printf("\t%s %n", "------------------------------------------------------------------");
        System.out.printf("\tTotal %60.2f %n", this.invoices.get(num).getTotal());
        System.out.println("----------------------------------------------------------------------");
    }
}
