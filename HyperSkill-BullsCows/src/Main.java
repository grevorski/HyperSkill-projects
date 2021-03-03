package bullscows;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        boolean condition = true;
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);

        System.out.println("Please, enter the secret code's length: ");
        int secretCodeLength = 0;
        if(sc.hasNextInt()) {
            secretCodeLength = sc.nextInt();
        }else{
            System.out.println("error");
            return;
        }

        if(secretCodeLength >36 || secretCodeLength <1){
            System.out.println("Error: can't generate a secret number with a length of 11 because there aren't enough unique digits.");
            return;
            //secretCodeLength =sc.nextInt();
        }

        System.out.println("Please, enter the number of possible symbols in the code: ");
        int rangeOfCharacter = sc.nextInt();
        if(rangeOfCharacter > 36 || rangeOfCharacter <1){
            System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            return;
        }
        if(rangeOfCharacter<secretCodeLength){
            System.out.println("Error: it's not possible to generate a code with a length of " +
                    secretCodeLength + " with " + rangeOfCharacter + " unique symbols.");
            return;
        }
        System.out.println("Okay, let's start a game!");

        List<String> listOfCharacters = new ArrayList<>(List.of("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
        List<String> listOfSelectedCharacters = listOfCharacters.subList(0, rangeOfCharacter);
        Collections.shuffle(listOfSelectedCharacters);

        StringBuilder secret = new StringBuilder();
        for (int i = 0; i < secretCodeLength; i++) {
            secret.append(listOfSelectedCharacters.get(i));
        }
        String secretCode = secret.toString();

        char maxCharacter = 97;
        maxCharacter += rangeOfCharacter - 10 - 1;

        System.out.print("The secret is prepared: ");

        for (int i = 0; i < secretCodeLength; i++) {
            System.out.print("*");
        }

        if (rangeOfCharacter <= 10) {
            System.out.println(" (0-9).");
        } else if (rangeOfCharacter == 11) {
            System.out.println(" (0-9, a).");
        } else {
            System.out.println(" (0-9, a-" + maxCharacter + ").");
        }
        int turn = 1;
        while(condition) {
            int bullCount=0;
            int cowCount=0;
            String guessNumber = sc1.nextLine();

            String[] guessHold = guessNumber.split("");
            String[] codeHold = secretCode.split("");

            for (int i = 0; i < guessHold.length; i++) {
                if (guessHold[i].equals(codeHold[i])) {
                    bullCount++;
                } else if (secretCode.contains(guessHold[i])) {
                    cowCount++;
                }
            }
            System.out.println("Turn: " + turn++);
            if (bullCount == secretCode.length()) {
                System.out.println("Grade: " + bullCount + " bull(s).");
                System.out.println("Congratulations! You guessed the secret code.");
                condition = false;
            } else if (cowCount == 0 && bullCount == 0) {
                System.out.println("Grade: None.");
            } else if (cowCount == 0) {
                System.out.println("Grade: " + bullCount + " bull(s).");
            } else if (bullCount == 0) {
                System.out.println("Grade: " + cowCount + " cow(s).");
            } else {
                System.out.println("Grade: " + bullCount + " bull(s) and " + cowCount + " cow(s).");
            }
        }
    }
}