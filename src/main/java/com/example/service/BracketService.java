package com.example.service;

import com.example.entity.Bracket;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import static com.example.constants.DialogConstants.*;

public class BracketService {
    private final Scanner scanner;

    public BracketService(Scanner scanner) {
        this.scanner = new Scanner(System.in);
    }

    public void beginGuessing() {
        System.out.println(SIZE_QUESTION);
        int sizeOfBracket = scanner.nextInt();
        System.out.println(MAX_ITEM_VALUE_QUESTION);
        int upperBound = scanner.nextInt();
        Bracket userBracket = new Bracket(sizeOfBracket, upperBound);
        Bracket randomBracket = new Bracket(sizeOfBracket, upperBound);
        createChosenItems(userBracket);
        createRandomItems(randomBracket);
        Set<Integer> commonElements = findCommonElements(userBracket, randomBracket);
        System.out.println(WINNING_NUMBERS);
        commonElements.forEach(System.out::println);
    }

    private void createChosenItems(Bracket bracket) {
        int sizeOfBracket = bracket.getSizeOfBracket();
        int upperBound = bracket.getUpperBound();
        if (sizeOfBracket > bracket.getUpperBound()) {
            System.out.println(UPPER_BOUND_WARNING);
            System.exit(0);
        }
        for (int i = 0; i < sizeOfBracket; i++) {
            System.out.printf((TAKE_NUMBER_TEMPLATE), i + 1, sizeOfBracket, upperBound);

            int tempInt = scanner.nextInt();

            if (canItemBeAdded(bracket, tempInt, upperBound))
                bracket.add(tempInt);
            else {
                System.out.println(WRONG_NUMBER_WARNING);
                i--;
            }
        }
    }

    private static boolean canItemBeAdded(Bracket bracket, int tempInt, int upperBound) {
        return (!(bracket.contains(tempInt))) && tempInt > 0 && tempInt <= upperBound;
    }

    private void createRandomItems(Bracket bracket) {
        Random random = new Random();
        for (int i = 0; i < bracket.getSizeOfBracket(); i++) {
            int tempInt = random.nextInt(1, bracket.getUpperBound() + 1);
            if (!(bracket.contains(tempInt)))
                bracket.add(tempInt);
            else
                i--;
        }
    }

    private Set<Integer> findCommonElements(Bracket chosenBracket, Bracket randomBracket) {
        Set<Integer> commonBracket = new HashSet<Integer>(chosenBracket.getItems());
        commonBracket.retainAll(randomBracket.getItems());
        return commonBracket;
    }

}
