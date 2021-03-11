package machine;

import java.util.Scanner;

public class CoffeeMachine {
    final static int water = 200;
    final static int milk = 50;
    final static int coffeeBeans = 15;
    public static void main(String[] args) {
        //CoffeeMaker();
        MachineStockStatus();
    }
//    public static void CoffeeMaker(){
//
//        Scanner sc = new Scanner(System.in);
//        System.out.println("Write how many cups of coffee you will need: ");
//        int cupCount = sc.nextInt();
//        System.out.println("For " + cupCount + " cups of coffee you will need:");
//        System.out.println(cupCount * water + " ml of water\n" + cupCount * milk + " ml of milk\n"
//        + cupCount * coffeeBeans + " g of coffee beans");
//    }
    public static void MachineStockStatus(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has: ");
        int waterStock = sc.nextInt();
        System.out.println("Write how many ml of milk the coffee machine has: ");
        int milkStock = sc.nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has: ");
        int coffeeBeansStock = sc.nextInt();
        System.out.println("Write how many cups of coffee you will need: ");
        int cupCount = sc.nextInt();

        int numOfCupsCanMake = Math.min(Math.min((milkStock / milk),(waterStock / water)),(coffeeBeansStock / coffeeBeans));
        int extraCups = numOfCupsCanMake - cupCount;

        if (numOfCupsCanMake == cupCount) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if (numOfCupsCanMake > cupCount) {
            System.out.println("Yes, I can make that amount of coffee (and even "+ extraCups +" more than that)");
        } else System.out.println("No, I can make only "+ numOfCupsCanMake +" cup(s) of coffee");

    }
}


