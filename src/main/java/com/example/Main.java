package com.example;

import java.util.HashSet;
import java.util.Random;
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
        choosenBracket.setUpperBound();
        choosenBracket.ChooseSet();
        choosenBracket.getSet();

        randomBracket.setSizeOfBracket(choosenBracket.getSizeOfBracket());
        randomBracket.setUpperBound(choosenBracket.getUpperBound());
        randomBracket.RandomSet();
        randomBracket.getSet();

        choosenBracket.commonElements(randomBracket.bracket);

    }

}

class Bracket {
    Scanner scanner = new Scanner(System.in);
    int sizeOfBracket;
    int upperBound;
    String user;

    public int setSizeOfBracket() {
        System.out.println("Podaj ile liczb chcesz wylosować.");
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

    public int setUpperBound() {
        System.out.println("Podaj górny zakres losowanych liczb.");
        upperBound = scanner.nextInt();
        return upperBound;
    }

    public int setUpperBound(int upperBound) {
        this.upperBound = upperBound;
        return upperBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    Set<Integer> bracket = new HashSet<Integer>(sizeOfBracket);

    public void ChooseSet() {
        for (int i = 0; i < sizeOfBracket; i++) {
            System.out.println(
                    "Podaj " + (i + 1) + ". z " + sizeOfBracket + " liczb w zakresie od 1 do " + upperBound + ".");
            int tempInt = scanner.nextInt();

            if ((!(this.bracket.contains(tempInt))) && tempInt > 0 && tempInt <= upperBound)
                bracket.add(tempInt);
            else {
                System.out.println("Ta liczba nie spełnia założonych warunków");
                i--;
            }
        }
    }

    public void RandomSet() {
        Random random = new Random();
        for (int i = 0; i < sizeOfBracket; i++) {
            int tempInt = random.nextInt(1, this.upperBound + 1);
            if (!(this.bracket.contains(tempInt)))
                bracket.add(tempInt);
            else
                i--;

        }
    }

    public Set<Integer> getSet() {
        System.out.println(bracket);
        return bracket;
    }

    public Set<Integer> commonElements(Set<Integer> bracket) {
        Set<Integer> commonBracket = new HashSet<Integer>(this.bracket);
        commonBracket.retainAll(bracket);
        System.out.println("Wspólne liczby z setu to: " + this.bracket);
        return commonBracket;
    }
}
