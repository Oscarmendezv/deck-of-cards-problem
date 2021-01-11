package com.github.oscarmendezv.deckofcards.card.poker;

import com.github.oscarmendezv.deckofcards.card.Card;

public class PokerCard implements Card {

    private final PokerCardSuit suit;
    private final PokerCardValue value;

    public PokerCard(PokerCardSuit suit, PokerCardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public PokerCardSuit getSuit() {
        return suit;
    }

    public PokerCardValue getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "PokerCard{" +
            "suit=" + suit +
            ", value=" + value +
            '}';
    }
}
