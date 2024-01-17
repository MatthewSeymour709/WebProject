Java Term Project - Fall 2021 - Matt Seymour

Pseudocode

Create Classes
- Customer
- Invoice
- Item
- Store
- StoreTest

Customer Class Variables
- First Name (String)
- Last Name (String)
- Email Address (String)
- Phone Number (String)
- Invoices (Array List)
- Store (Store)

Customer Class Methods
- Constructor (Sets initial variables)
- First Name (Getter and Setter)
- Last Name (Getter and Setter)
- Email Address (Getter and Setter)
- Phone Number (Getter and Setter)
- Store (Getter and Setter)
- Add Invoice (Adds invoice to an array list)
- Display Profile (displays customer profile to terminal)
- Invoice Formatter (Helper function to build invoices)

Invoice Class Variables
- Customer (Customer)
- Store (Store)
- Items Sold (Array List)
- Total (Double/Dependant on items and items sold)
- Date (String (Only necessary for construction))

Invoice Class Methods
- Constructor (Sets inital variables (when date is need))
- Customer (Getter and Setter)
- Store (Getter and Setter)
- Total (Getter)
- Date (Getter)
- Items (Getter (for all items))
- Item (Getter (for an individual item))
- Add Item (Adds item to itemsSold array list) **Throws exception if item is not available**
- Display Invoice (displays invoice to terminal)

Item Class Variables
- Manufacturer (String)
- Model (String)
- Price (Double)
- Quantity (Integer)
- Type (enum type)
- Type (Type)
- Store (Store)

Item Class Methods
- Constructor (Sets inital variables)
- Manufacturer (Getter and Setter)
- Model (Getter and Setter)
- Price (Getter and Setter)
- Quantity (Getter and Setter)
- Type (Getter and Setter)
- Store (Getter and Setter)
- Storage Location (Returns location based on type)

Store Class Variables
- Name (String)
- Items (Array List)

Store Class Methods
- Constructor (Sets initial variables)
- Name (Getter and Setter)
- Items (Get all items)
- Item (Get an individual item)
- Add Item (Adds an item to the Store array list)
- Display Inventory (Displays entire inventory to terminal)
- Display Available Inventory (Displays all available inventory to terminal)
- Inventory Formatting (Helper function for formating inventory)

Store Test Class for Testing project
- Answers all questions in project and displays to terminal.
