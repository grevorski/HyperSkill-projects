package machine;

import java.util.Scanner;

public class CoffeeMachine {
    private static int water = 400;
    private static int milk = 540;
    private static int beans = 120;
    private static int cups = 9;
    private static int money = 550;
    private static boolean exit = true;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (exit) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String command = sc.nextLine();
            switch (command) {
                case "buy":
                    buy(sc);
                    break;
                case "fill":
                    fill(sc);
                    break;
                case "take":
                    take();
                    break;
                case "remaining":
                    printMenu();
                    break;
                case "exit":
                    exit = false;
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }

        }

    }
    public static void printMenu() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
    }

    public static void fill(Scanner sc) {
        System.out.println("Write how many ml of water do you want to add: ");
        water += sc.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += sc.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        beans += sc.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups += sc.nextInt();
    }

    public static void buy(Scanner sc){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String number = sc.nextLine();
        int waterNeeded = 0;
        int milkNeeded = 0;
        int beansNeeded = 0;
        boolean back = false;
        switch(number){
            case "1": // espresso
                waterNeeded = 250;
                milkNeeded = 0;
                beansNeeded = 16;
                money += 4;
                break;
            case "2": // latte
                waterNeeded = 350;
                milkNeeded = 75;
                beansNeeded = 20;
                money += 7;
                break;
            case "3": // cappuccino
                waterNeeded = 200;
                milkNeeded = 100;
                beansNeeded = 12;
                money += 6;
                break;
            case "back":
                back = true;
                break;
            default:
                System.out.println("Unknown coffee type");
                break;
        }
        if (water < waterNeeded) {
            System.out.println("Sorry, not enough water!");
        } else if (milk < milkNeeded) {
            System.out.println("Sorry, not enough milk!");
        } else if (beans < beansNeeded) {
            System.out.println("Sorry, not enough coffee beans!");
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
        } else if(!back){
            System.out.println("I have enough resources, making you a coffee!");
            water -= waterNeeded;
            milk -= milkNeeded;
            beans -= beansNeeded;
            cups -= 1;
        }
    }

    public static void take(){
        System.out.println("I gave you $" + money);
        money = 0;
    }
}


