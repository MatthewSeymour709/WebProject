public class Item {
    private String manufacturer="";
    private String model="";
    private double price=0.00;
    private int quantity=0;
    protected enum Type {
        STKL,
        STKR,
        ACCT
    };
    private Type type;
    private Store store;

    public Item(String man, String mod, double p, int q, Type t, Store s) {
        this.manufacturer=man;
        this.model=mod;
        this.price=p;
        this.quantity=q;
        this.type=t;
        this.store=s;
    }

    public String getManufacturer() {
        return this.manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int q) {
        this.quantity=q;
    }

    public Type getType() {
        return this.type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String storageLocation(Type t) {
        switch(t) {
            case STKL:
                return "Lefty Stick Rack";
            case STKR:
                return "Righty Stick Rack";
            case ACCT:
                return "Front Counter";
        }
        return "";
    }
}
