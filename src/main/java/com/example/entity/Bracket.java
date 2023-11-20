package com.example.entity;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class Bracket {

    private final int sizeOfBracket;
    private final int upperBound;
    private final Set<Integer> items;

    public Bracket(int sizeOfBracket, int upperBound) {
        this.sizeOfBracket = sizeOfBracket;
        this.upperBound = upperBound;
        this.items = new HashSet<>(sizeOfBracket);
    }

    public boolean contains(int number) {
        return this.items.contains(number);
    }

    public void add(int number) {
        this.items.add(number);
    }




}

