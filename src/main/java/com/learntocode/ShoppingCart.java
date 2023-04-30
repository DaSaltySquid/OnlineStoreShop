package com.learntocode;

public class ShoppingCart {
    private Product[] cart;
    private int productCount;      // total number of items in the cart
    private double totalPrice;  // total price of items in the cart
    private int capacity;       // current cart capacity

    // -----------------------------------------------------------
    //  Creates an empty shopping cart with a capacity of 5 items.
    // -----------------------------------------------------------
    public ShoppingCart()
    {

        capacity = 5;
        cart = new Product[capacity];
        productCount = 0;
        totalPrice = 0.0;
    }

    // -------------------------------------------------------
    //  Adds an item to the shopping cart.
    // -------------------------------------------------------
    public void addToCart(String productName, double price, int quantity)
    {

        Product temp = new Product(productName, price, quantity);
        totalPrice += (price * quantity);
        productCount += quantity;
        cart[productCount] = temp;
        if(productCount==capacity)
        {
            increaseSize();
        }
    }

    // -------------------------------------------------------
    //  Returns the contents of the cart together with
    //  summary information.
    // -------------------------------------------------------
    public String toString()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();

        String contents = "\nShopping Cart\n";
        contents += "\nItem\t\tUnit Price\tQuantity\tTotal\n";

        for (int i = 0; i < productCount; i++)
            contents += cart[i].toString() + "\n";

        contents += "\nTotal Price: " + fmt.format(totalPrice);
        contents += "\n";

        return contents;
    }

    // ---------------------------------------------------------
    //  Increases the capacity of the shopping cart by 3
    // ---------------------------------------------------------
    private void increaseSize()
    {
        Product[] temp = new Product[capacity+3];
        for(int i=0; i < capacity; i++)
        {
            temp[i] = cart[i];
        }
        cart = temp;
        temp = null;
        capacity = cart.length;
    }
}

