// AP CS - Lab 7.7 - Shopping Cart
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class Shop
{

    public static void main(String[] args)
    {
        // declare and instantiate an ArrayList of Item objects to represent the shopping cart
        ArrayList<Item> shoppingCart = new ArrayList<Item>();

        /*
         * Repeatedly prompt the user for the name, unit cost, and quantity of an item they're purchasing.
         *
         * Before each request, ask the user if they would like to continue shopping ("no" indicates they're done).
         */
        Scanner keyboard = new Scanner(System.in);
        boolean continueShopping = true;
        while (continueShopping)
        {
            System.out.println("Do you wish to continue shopping (enter no to stop. Press enter key to continue shopping)?");
            String line = keyboard.nextLine();
            // Hitting the Enter key means keep shopping. Entering N, n, No, NO, or no means stop shopping
            continueShopping = (line.length() > 0 && !line.substring(0, 1).equalsIgnoreCase("n")) || line.length() == 0;
            if (!continueShopping)
            {
                break;
            }

            System.out.println("What is the name of the item you wish to purchase?");
            String itemName = keyboard.nextLine();

            System.out.println("What is the unit cost?");
            double unitCost = Double.parseDouble(keyboard.nextLine());

            System.out.println("How many do you want to purchase?");
            int quantity = Integer.parseInt(keyboard.nextLine());

            shoppingCart.add(new Item(itemName, unitCost, quantity));
        }
        keyboard.close();

        // Use a traditional for loop to print the contents of the shopping cart and calculate the total cost of the items.
        double total = 0;
        for (int i = 0; i < shoppingCart.size(); i++)
        {
            Item item = shoppingCart.get(i);
            System.out.println(item);
            total += item.getPrice() * item.getQuantity();
        }

        // Print the total cost of the items
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        System.out.format("Order total is %s%n", fmt.format(total));

        // Now remove the first item from the cart
        if (shoppingCart.size() > 0)
            shoppingCart.remove(0);

        // Use an enhanced for loop (for each loop) to print the updated cart contents and re-calculate the total cost of the items
        total = 0;
        System.out.println();
        for (Item item : shoppingCart)
        {
            System.out.println(item.toString());
            total += item.getPrice() * item.getQuantity();
        }

        // print the new total
        System.out.println("Order total is " + fmt.format(total));

    }

}
