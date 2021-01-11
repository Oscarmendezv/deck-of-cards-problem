package com.github.oscarmendezv.deckofcards.deck;

import com.github.oscarmendezv.deckofcards.card.Card;
import com.github.oscarmendezv.deckofcards.card.poker.PokerCard;
import com.github.oscarmendezv.deckofcards.card.poker.PokerCardSuit;
import com.github.oscarmendezv.deckofcards.card.poker.PokerCardValue;
import java.util.ArrayList;
import java.util.List;

public class DeckFactory {

    /**
     * Generates a sorted deck of the required type.
     *
     * @param deckType the type of deck to be created
     */
    public static Deck createDeck(DeckType deckType) {

        List<Card> cards = new ArrayList<>();

        switch (deckType) {
            case POKER:
                /*
                I'm opting for the general approach as both enums don't have much length (performance wise is faster).
                Another viable option would be using Java 8 streams, with or without the parallel option depending on
                if enums are big enough and if you want to be compliant with returning a sorted Deck or not:

                        Arrays.stream(PokerCardValue.values())
                            .parallel()
                            .forEach(value -> Arrays.stream(PokerCardSuit.values())
                                                .parallel()
                                                .map(suit -> new PokerCard(suit, value))
                                                .forEach(System.out::println));
                 */

                for (PokerCardSuit suit : PokerCardSuit.values()) {
                    for (PokerCardValue value : PokerCardValue.values()) {
                        cards.add(new PokerCard(suit, value));
                    }
                }
                break;
        }

        return new Deck(cards, deckType);
    }
}
