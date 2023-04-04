// AP CS - Lab 7.7 - Shopping Cart
// ***************************************************************
//   Item.java
//
//   Represents a type of item in a shopping cart.
//   Contains 3 instance data fields representing the item's:
//         name
//         unit price
//         quantity purchased
// ***************************************************************

import java.text.NumberFormat;

public class Item
{
    private String name;
    private double price;
    private int quantity;

    // -------------------------------------------------------
    // Create a new item with the given attributes.
    // -------------------------------------------------------
    public Item(String name, double price, int numPurchased)
    {
        this.name = name;
        this.price = price;
        quantity = numPurchased;
    }
    private Item() {/* prevent uninitialized instances */}

    // -------------------------------------------------------
    // Return a string with the information about the item
    // -------------------------------------------------------
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        return (quantity + " " + name + "s cost " + fmt.format(price * quantity));
    }

    // -------------------------------------------------
    // Returns the unit price of the item
    // -------------------------------------------------
    public double getPrice()
    {
        return price;
    }

    // -------------------------------------------------
    // Returns the name of the item
    // -------------------------------------------------
    public String getName()
    {
        return name;
    }

    // -------------------------------------------------
    // Returns the quantity of the item
    // -------------------------------------------------
    public int getQuantity()
    {
        return quantity;
    }
}
