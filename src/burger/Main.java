package burger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Scanner reader = new Scanner(System.in);

        // Create burgers
        Burger kanaBurger = new Burger("kanaBurger", "kanaliha", "sai ", 3.99);
        Burger juustuBurger = new Burger("juustuBurger", "loomaliha", "sai ", 2.99);
        Burger tacoBurger = new Burger("tacoBurger", "sealiha", "täisterakukkel ", 3.50);

        // Adding extras to the burgers
        SelectionOfExtras kanaBurgerExtras = new SelectionOfExtras(new Extras("juust", 0.5), new Extras("salat", 0.3), new Extras("tomat", 0.5), new Extras("ketsup", 0.5));
        SelectionOfExtras juustuBurgerExtras = new SelectionOfExtras(new Extras("peekon", 0.7), new Extras("marineeritud kurk", 0.5), new Extras("sibul", 0.3), new Extras("BBQ kaste", 0.5));
        SelectionOfExtras tacoBurgerExtras = new SelectionOfExtras(new Extras("kebab", 0.7), new Extras("tomat", 0.5), new Extras("hapukurk", 0.5), new Extras( "jalapeno", 0.3));

        // Creating new burger menu
        BurgerMenu burgerMenu = new BurgerMenu();

        // Adding burger to the menu
        burgerMenu.addToBurgerMenu(kanaBurger, kanaBurgerExtras);
        burgerMenu.addToBurgerMenu(juustuBurger, juustuBurgerExtras);
        burgerMenu.addToBurgerMenu(tacoBurger, tacoBurgerExtras);

        // Print out the menu for the customer
        System.out.println("Burgeri menüü:");

        // Start the receipt
        Receipt receipt = new Receipt();

        while (true) {
            System.out.println(burgerMenu);
            System.out.println("Vali burger (Vajuta 0 kui oled valmis saanud): ");
            int selectionNumber;
            try {
                selectionNumber = Integer.parseInt(input.nextLine());

                if (selectionNumber > burgerMenu.getBurgers().size()) {
                    throw new BurgerException();
                } else if (selectionNumber == 0) {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Vale number");
                continue;
            }

            // Burger that the client has selected and its additions
            Burger selectedBurger = burgerMenu.getBurgers().get(selectionNumber - 1);
            SelectionOfExtras selectedBurgerExtras = burgerMenu.getBurgerMenu().get(selectedBurger);

            System.out.println("Lisandid burgerile: " + selectedBurgerExtras);

            // Loop of extras
            while (true) {
                System.out.println("Vali lisandid (Vajuta enter kui oled valmis saanud): ");
                String extraChosen = reader.nextLine();

                if (extraChosen.isEmpty()) {
                    break;
                }

                for (Extras extra : selectedBurgerExtras.getExtras()) {
                    if (extra.getName().toLowerCase().equals(extraChosen)) {
                        selectedBurger.addExtras(extra);
                        break;
                    }
                }
            }

            receipt.addToReceipt(selectedBurger);
            System.out.println("Jooksev arve: " + receipt.sumUpPrice() + " €");
        }

        System.out.println("Kviitung:");
        System.out.println(receipt);
        System.out.println("Tasuda: " + receipt.sumUpPrice() + " €");
    }
}