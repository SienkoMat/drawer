package com.example;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public final class Main {

    public static void main(String[] args) {

        /*
         * System.out.println("Jak się nazywasz?");
         * String user = scanner.nextLine();
         */

        Bracket choosenBracket = new Bracket();
        Bracket randomBracket = new Bracket();
        choosenBracket.setSizeOfBracket();
        choosenBracket.ChooseSet();
        choosenBracket.getSet();

        randomBracket.setSizeOfBracket(choosenBracket.getSizeOfBracket());
        randomBracket.RandomSet();

    }

}

class Bracket {
    Scanner scanner = new Scanner(System.in);
    int sizeOfBracket;
    String user;

    public int setSizeOfBracket() {
        System.out.println("Podaj ile liczb chcesz wylosować");
        sizeOfBracket = scanner.nextInt();
        return sizeOfBracket;
    }

    public int setSizeOfBracket(int sizeOfBracket) {
        this.sizeOfBracket = sizeOfBracket;
        return sizeOfBracket;
    }

    public int getSizeOfBracket() {
        return sizeOfBracket;
    }

    Set<Integer> bracket = new HashSet<Integer>(sizeOfBracket);

    public void ChooseSet() {
        for (int i = 0; i < sizeOfBracket; i++) {
            System.out.println("Podaj " + (i + 1) + ". z " + sizeOfBracket + " liczb");
            int tempInt = scanner.nextInt();
            bracket.add(tempInt);
        }
    }

    public void RandomSet() {
        for (int i = 0; i < sizeOfBracket; i++) {
            System.out.println("Podaj " + (i + 1) + ". z " + sizeOfBracket + " liczb");
            int tempInt = scanner.nextInt();
            bracket.add(tempInt);
        }
    }

    public Set<Integer> getSet() {
        System.out.println(bracket);
        return bracket;
    }
}
