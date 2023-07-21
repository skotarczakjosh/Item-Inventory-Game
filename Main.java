/*
* Author: Josh Skotarczak
* Created: 6/10/23
* Description: Main Method for a user input menu that interacts game items from 8 separate classes.
 */

// Imports
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class Main {
    // Scanner Object for reading inputs from command line
    private static final Scanner scanner = new Scanner(System.in);
    // Functions
    // Reusable True/False Function Loop; Makes Sure True/False Input Is Correct
    private static boolean getTrueFalse(String message) {
        String input;
        do {
            System.out.print(message);
            input = scanner.nextLine();
            if (input.equalsIgnoreCase("y")) {
                return true;
            } else if (input.equalsIgnoreCase("n")) {
                return false;
            } else {
                System.out.println("Invalid Input. Please enter either y or n.");
            }
        } while (true);
    }
    // Reusable Integer Limited Range Function Loop; Makes Sure Integer Input Is Within Available Range
    private static int getIntInRange(String message, int min, int max) {
        int input;
        do {
            System.out.print(message + " (" + min + "-" + max + "): ");
            input = scanner.nextInt();
            if (input < min || input > max) {
                System.out.println("Invalid Input. Must be between " + min + " and " + max + ".");
            }
        } while (input < min || input > max);
        return input;
    }

    //Returns Item Type As String
    private static String getItemType(Item item) {
        if (item instanceof Coin) {
            return "Coin";
        } else if (item instanceof Gem) {
            return "Gem";
        } else if (item instanceof Potion) {
            return "Potion";
        } else if (item instanceof Food) {
            return "Food";
        }
        return "";
    }

    // Main Method
    public static void main(String[] args) {
        // Array List for Items
        ArrayList < Item > myItems = new ArrayList < > ();
        String[] itemNames = {
                "Coin",
                "Gem",
                "Potion",
                "Food"
        };
        // User Inputs
        int mainInput; // Main Menu Input
        int subInput; // Sub Menu Inputs
        // Standard Item Variables
        String itemName;
        String itemLocation;
        boolean itemUnique;
        // Treasure Items Variables
        String itemUse;
        boolean itemHidden;
        // Coin Item
        int coinValue;
        String metalType;
        // Gem Item
        String gemColor;
        boolean gemValuable;
        // Health Items Variables
        String itemDescription;
        int healthValue;
        // Potion Item
        int potionDuration;
        double potionPotency;
        // Food Item
        int livesAdded;
        boolean itemPerishable;
        // Item Counts
        int numCoins = 0;
        int numGems = 0;
        int numPotions = 0;
        int numFoods = 0;
        // Interacting With Item
        String itemType;
        // Do While Loop For Text Based Main Menu
        do {
            // Main Menu
            mainInput = getIntInRange("---Main Menu---\n1. View Items\n2. Add Item\n3. Remove Item\n" +
                    "4. Interact with Item\n5. End Program\nSelect Option", 1, 5);
            switch (mainInput) {
                case 1 -> {
                    // Sub Menu For View Items
                    System.out.println("---View Items---\nItems in the list:");
                    if (!myItems.isEmpty()) {
                        for (int i = 0; i < myItems.size(); i++) {
                            System.out.print((i + 1) + ". ");
                            System.out.println(myItems.get(i));
                            System.out.println();
                        }
                    } else {
                        System.out.println("There are currently no items in the list.");
                    }
                }
                case 2 -> {
                    // Sub Menu For Add Items
                    System.out.println("Select an item to add");
                    for (int j = 0; j < 4; j++) {
                        System.out.println((j + 1) + ". " + itemNames[j]); // List Items You Can Create
                    }
                    subInput = getIntInRange("Enter Choice", 1, 4);
                    System.out.println("You selected " + itemNames[subInput-1] + ".");
                    scanner.nextLine(); // Consume the newLine character
                    System.out.print("What is the item's name? ");
                    itemName = scanner.nextLine();
                    System.out.print("Where can the item be found? ");
                    itemLocation = scanner.nextLine();
                    itemUnique = getTrueFalse("Is the item unique? (y/n): ");
                    // If a Treasure Item
                    if (subInput == 1 || subInput == 2) {
                        System.out.print("What is the item's used for? ");
                        itemUse = scanner.nextLine();
                        itemHidden = getTrueFalse("Is this item a hidden item? (y/n): ");
                        switch (subInput) {
                            // Coin Item
                            case 1 -> {
                                coinValue = getIntInRange("What is the coin's value?", 1, 20);
                                System.out.print("What is metal type of the coin? ");
                                scanner.nextLine(); // Consume the newLine character
                                metalType = scanner.nextLine();
                                Coin newCoin = new Coin(itemName, itemLocation, itemUnique, itemUse, itemHidden,
                                        coinValue, metalType);
                                myItems.add(newCoin);
                            }
                            // Gem Item
                            case 2 -> {
                                System.out.print("What is the color of the gem? ");
                                gemColor = scanner.nextLine();
                                gemValuable = getTrueFalse("Is this gem valuable? (y/n): ");
                                Gem newGem = new Gem(itemName, itemLocation, itemUnique, itemUse, itemHidden,
                                        gemColor, gemValuable);
                                myItems.add(newGem);
                            }
                        }
                    } else {
                        // If a Health Item
                        System.out.print("Provide a brief description: ");
                        itemDescription = scanner.nextLine();
                        healthValue = getIntInRange("What is the items health value?", 1, 15);
                        if (subInput == 3) {
                            // Potion Item
                            potionDuration = getIntInRange("What is the potions duration in hours?", 1, 10);
                            potionPotency = getIntInRange("What is the potions potency?", 1, 5);
                            Potion newPotion = new Potion(itemName, itemLocation, itemUnique, itemDescription,
                                    healthValue, potionDuration, potionPotency);
                            myItems.add(newPotion);
                        } else {
                            // Food Item
                            livesAdded = getIntInRange("How many extra lives given by the food item?", 0, 3);
                            scanner.nextLine(); // Consume the newline character
                            itemPerishable = getTrueFalse("Is this food item perish quickly? (y/n): ");
                            Food newFood = new Food(itemName, itemLocation, itemUnique, itemDescription,
                                    healthValue, livesAdded, itemPerishable);
                            myItems.add(newFood);
                        }
                    }
                    System.out.println("Item added successfully");
                    // Sort the list after adding Items
                    Collections.sort(myItems);
                }
                case 3 -> {
                    // Sub Menu For Remove Items
                    boolean itemFound = false;
                    if (!myItems.isEmpty()) {
                        scanner.nextLine(); // Consume the newline character
                        System.out.println("---Remove Item---");
                        System.out.println("Which item would you like to remove? Enter the item's name: ");
                        String itemToRemove = scanner.nextLine().toLowerCase();
                        for (int j = 0; j < myItems.size(); j++) {
                            Item myItem = myItems.get(j);
                            String nameOfItem = myItem.getItemName();
                            nameOfItem = nameOfItem.toLowerCase();
                            if (itemToRemove.equals(nameOfItem)) { // If Item Name Matches Item In List... Delete Item
                                myItems.remove(j); // Removes the Item from List
                                System.out.println("Item found and successfully removed.");
                                itemFound = true;
                                break;
                            }
                        }
                        if (!itemFound) {
                            System.out.println("Item does not exist.");
                        }
                    } else {
                        System.out.println("There are currently no items in the list.");
                    }
                }
                case 4 -> {
                    // Sub Menu For Interact With Items
                    if (!myItems.isEmpty()) {
                        // Display Items
                        System.out.println("---Interact With Item---");
                        for (int j = 0; j < myItems.size(); j++) {
                            Item item = myItems.get(j);
                            itemType = getItemType(item);
                            System.out.println((j + 1) + ". " + item.getItemName() + " - " + itemType);
                        }
                        subInput = getIntInRange("Which item would you like to interact with? " +
                                "\nSelect the number:", 1, myItems.size());
                        // Defining what item is selected
                        Item item = myItems.get(subInput - 1);
                        String interactOptions = "What action would you like to perform?\n" + "1. Activate Item\n" +
                                "2. Use Item\n" + "3. Expire Item\n";
                        if (item instanceof Gem || item instanceof Potion) {
                            interactOptions += "4. Grant a Wish\n" + "5. Cast a Spell\n";
                        }
                        interactOptions += "Select a choice";
                        int range = item instanceof Gem || item instanceof Potion ? 5 : 3;
                        subInput = getIntInRange(interactOptions, 1, range);
                        if (subInput == 1) { //Activate
                            item.activate();
                        } else if (subInput == 2) { // Use
                            item.use();
                        } else if (subInput == 3) { // Expire
                            item.expire();
                        } else if (subInput == 4) { // Grant Wish
                            // Found on Stack Overflow allows to create gemItem from item to access
                            // grantWish() etc... all in the if condition Saves many lines!
                            if(item instanceof Gem gemItem){
                                gemItem.grantWish();
                            } else if (item instanceof Potion potionItem){
                                potionItem.grantWish();
                            }
                        } else if (subInput == 5) { // Cast Spell
                            if(item instanceof Gem gemItem){
                                gemItem.castSpell();
                            } else if (item instanceof Potion potionItem){
                                potionItem.castSpell();
                            }
                        }
                    } else {
                        System.out.println("There are currently no items in the list.");
                    }
                }
                case 5 -> {
                    System.out.println("Exiting Program...");
                    if (!myItems.isEmpty()) {
                        // Adds up the total number of each item by using instanceof
                        // in conjunction with a for each loop
                        for (Item item: myItems) {
                            if (item instanceof Coin) {
                                numCoins = numCoins + 1;
                            } else if (item instanceof Gem) {
                                numGems = numGems + 1;
                            } else if (item instanceof Potion) {
                                numPotions = numPotions + 1;
                            } else if (item instanceof Food) {
                                numFoods = numFoods + 1;
                            }
                        }
                        // Prints total when programmed is closed
                        System.out.println("The list currently contains:\n" + numCoins + " Coin(s)\n" + numGems +
                                        " Gem(s)\n" + numPotions + " Potion(s)\n" + numFoods + " Food Item(s)");
                    } else {
                        System.out.println("There were no items in the list");
                    }
                }
            }
        } while (mainInput != 5);
        System.out.println("Program Closed! Goodbye.");
    }
}