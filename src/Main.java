import java.util.*;

public class Main {
    public static void main(String[] args) {
        burx chicken = new burx("kanaBurger", "kanaliha", "sai", 3.99);
        burx cheese = new burx("juustuBurger", "loomaliha", "sai", 2.99);
        burx taco = new burx("tacoBurger", "sealiha", 3.50);

        Scanner scanner = new Scanner(System.in);
        Scanner reader = new Scanner(System.in);
        double kokku = 0;

        while(true) {
            System.out.println("Vali burger: 1 - kanaBurger, 2 - juustuBurger, 3 - tacoBurger");
            int valik = scanner.nextInt();
            if(valik == 1) {
                System.out.println(chicken);
                chicken.lisaLisandid();
                kokku += chicken.koostaBurger();
                System.out.println("Burgeri hind: " + chicken.koostaBurger());
                System.out.println("Kas soovid veel burgereid? (jah/ei)");
                String veelBurgereid = reader.nextLine();
                if(veelBurgereid.equals("ei")) {
                    break;
                }

            }
            else if(valik == 2) {
                System.out.println(cheese);
                cheese.lisaLisandid();
                kokku += cheese.koostaBurger();
                System.out.println("Burgeri hind: " + cheese.koostaBurger());
                System.out.println("Kas soovid veel burgereid? (jah/ei)");
                String veelBurgereid = reader.nextLine();
                if(veelBurgereid.equals("ei")) {
                    break;
                }
            }
            else if(valik == 3) {
                System.out.println(taco);
                taco.lisaLisandid();
                kokku += taco.koostaBurger();
                System.out.println("Burgeri hind: " + taco.koostaBurger());
                System.out.println("Kas soovid veel burgereid?  (jah/ei)");
                String veelBurgereid = reader.nextLine();
                if(veelBurgereid.equals("ei")) {
                    break;
                }
            }
            else break;
        }
        System.out.println("Hind kokku on " + kokku + " €.");
    }
}
