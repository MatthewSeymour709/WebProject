import java.security.SecureRandom;

public class StoreTest {

    public static void main(String[] args) {
        // Part 1
        Store firstStore=new Store("My First Store");
        Store secondStore=new Store("My Second Store");

        // Part 2
        Item firstItem1=new Item("CCM", "JetSpeed FT3", 139.99,15, Item.Type.STKL, firstStore);
        Item firstItem2=new Item("CCM", "JetSpeed FT3", 139.99,15, Item.Type.STKL, secondStore);
        Item secondItem1=new Item("CCM", "Ribcor Pro 3", 179.99,20, Item.Type.STKL, firstStore);
        Item secondItem2=new Item("CCM", "Ribcor Pro 3", 179.99,20, Item.Type.STKL, secondStore);
        Item thirdItem1=new Item("CCM", "Ribcor Pro 4", 349.99,15, Item.Type.STKR, firstStore);
        Item thirdItem2=new Item("CCM", "Ribcor Pro 4", 349.99,15, Item.Type.STKR, secondStore);
        Item forthItem1=new Item("Bauer", "Vapor Flylite", 244.99,20, Item.Type.STKR, firstStore);
        Item forthItem2=new Item("Bauer", "Vapor Flylite", 244.99,20, Item.Type.STKR, secondStore);
        Item fifthItem1=new Item("Bauer", "Nexus 2N Pro", 223.99,20, Item.Type.STKL, firstStore);
        Item fifthItem2=new Item("Bauer", "Nexus 2N Pro", 223.99,20, Item.Type.STKL, secondStore);
        Item sixthItem1=new Item("Bauer", "Nexus N2900", 125.99,25, Item.Type.STKR, firstStore);
        Item sixthItem2=new Item("Bauer", "Nexus N2900", 125.99,25, Item.Type.STKR, secondStore);
        Item seventhItem1=new Item("Warrior", "Alpha DX5", 159.99,25, Item.Type.STKL, firstStore);
        Item seventhItem2=new Item("Warrior", "Alpha DX5", 159.99,25, Item.Type.STKL, secondStore);
        Item eigthItem1=new Item("Warrior", "Covert QR5", 159.99,25, Item.Type.STKR, firstStore);
        Item eigthItem2=new Item("Warrior", "Covert QR5", 159.99,25, Item.Type.STKR, secondStore);
        Item ninthItem1=new Item("Howies", "Hockey Tape White", 4.99,45, Item.Type.ACCT, firstStore);
        Item ninthItem2=new Item("Howies", "Hockey Tape White", 4.99,45, Item.Type.ACCT, secondStore);
        Item tenthItem1=new Item("Howies", "Hockey Tape Black", 4.99,45, Item.Type.ACCT, firstStore);
        Item tenthItem2=new Item("Howies", "Hockey Tape Black", 4.99,45, Item.Type.ACCT, secondStore);

        Item[] storeInventory1={firstItem1, secondItem1, thirdItem1, forthItem1, fifthItem1, sixthItem1, seventhItem1, eigthItem1, ninthItem1, tenthItem1};
        Item[] storeInventory2={firstItem2, secondItem2, thirdItem2, forthItem2, fifthItem2, sixthItem2, seventhItem2, eigthItem2, ninthItem2, tenthItem2};

        for (int i=0; i<storeInventory1.length; i++) {
            firstStore.addItem(storeInventory1[i]);
        }
        for (int i=0; i<storeInventory2.length; i++) {
            secondStore.addItem(storeInventory2[i]);
        }

        // Part 3
        firstStore.displayInventory();
        secondStore.displayInventory();

        // Part 4
        Customer customer1=new Customer("Logan", "Drum", "ldrum@email.com", "709-420-6969", firstStore);
        Customer customer2=new Customer("Brittany", "Kavanagh", "bkavanagh@email.com", "709-420-8008", firstStore);
        Customer customer3=new Customer("Katie", "Gosse", "kgosse@email.com", "709-101-8487", secondStore);
        Customer customer4=new Customer("Ocean", "Man", "oman@email.com", "709-666-1010", secondStore);

        // Part 5
        Invoice invoice1=new Invoice(customer1, firstStore);

        SecureRandom rand = new SecureRandom();

        for(int i=0; i<5; i++) {
            Item item=firstStore.getItem(rand.nextInt(10));
            try {
                invoice1.addItem(item);
            }
            catch (Exception e) {
                System.out.println(e);
            }
            int newQuantity=item.getQuantity()-1;
            item.setQuantity(newQuantity);
        }

        customer1.addInvoice(invoice1);

        // Part 6
        invoice1.displayInvoice();

        // Part 7
        Invoice invoice2=new Invoice(customer1, firstStore);

        Item item=firstStore.getItem(rand.nextInt(10));
        try {
            invoice2.addItem(item);
        }
        catch (Exception e) {
            System.out.println(e);
        }
        int newQuantity=item.getQuantity()-1;
        item.setQuantity(newQuantity);

        invoice2.displayInvoice();
        customer1.addInvoice(invoice2);

        // Part 8
        customer1.displayProfile();

        // Part 9
        Item eleventhItem1=new Item("Howies", "Hockey Tape Clear", 4.99,0, Item.Type.ACCT, firstStore);
        firstStore.addItem(eleventhItem1);

        // Part 10
        firstStore.displayAvailableInventory();

        // Part 11
        Invoice invoice3 = new Invoice(customer2, firstStore);
        for(int i=0; i<firstStore.getItems().size(); i++) {
            Item itemtemp=firstStore.getItem(i);
            try {
                invoice3.addItem(itemtemp);
            }
            catch (Exception e) {
                System.out.println(e);
            }
            int newQuantitytemp=item.getQuantity()-1;
            item.setQuantity(newQuantitytemp);
        }
        invoice3.displayInvoice();
    }
}