package com.github.oscarmendezv.deckofcards.deck;

import com.github.oscarmendezv.deckofcards.card.Card;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class Deck {

    private final List<Card> cards;
    private final DeckType deckType;
    private int pointer;

    public Deck(List<Card> cards, DeckType deckType) {
        this.cards = cards;
        this.deckType = deckType;
        this.pointer = cards.size() - 1;
    }

    /**
     * Permutes deck cards in a random order using a Fiter-Yates shuffle. It adds back already dealt cards.
     */
    public void shuffle() {
        int deckSize = cards.size();

        IntStream.range(0, deckSize)
            .forEach(this::swap);

        pointer = deckSize - 1;
    }

    /**
     * Deals the first card of the deck
     *
     * @return The dealt Card
     */
    public Card dealOneCard() {
        if (pointer >= 0) {
            return cards.get(pointer--);
        }

        return null;
    }

    public DeckType getDeckType() {
        return deckType;
    }

    public List<Card> getCards() {
        return cards;
    }

    private void swap(int currentPosition) {
        Card helper = cards.get(currentPosition);
        int futurePosition = new Random().nextInt(cards.size());
        cards.set(currentPosition, cards.get(futurePosition));
        cards.set(futurePosition, helper);
    }
}
