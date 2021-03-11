package machine;

import java.util.Scanner;

public class CoffeeMachine {
    final static int water = 200;
    final static int milk = 50;
    final static int coffeeBeans = 15;
    public static void main(String[] args) {
        CoffeeMaker();
    }
    public static void CoffeeMaker(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need: ");
        int cupCount = sc.nextInt();
        System.out.println("For " + cupCount + " cups of coffee you will need:");
        System.out.println(cupCount * water + " ml of water\n" + cupCount * milk + " ml of milk\n"
        + cupCount * coffeeBeans + " g of coffee beans");
    }
}


