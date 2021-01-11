package com.github.oscarmendezv.deckofcards.app;

import com.github.oscarmendezv.deckofcards.card.Card;
import com.github.oscarmendezv.deckofcards.deck.Deck;
import com.github.oscarmendezv.deckofcards.deck.DeckFactory;
import com.github.oscarmendezv.deckofcards.deck.DeckType;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Optional;
import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeckOfCardsApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeckOfCardsApp.class);

    public static void main(String[] args) {

        String input = "";

        // Needed for slf4j
        BasicConfigurator.configure();

        showOptions();

        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {

            Deck deck = DeckFactory.createDeck(DeckType.POKER);

            while (!input.equalsIgnoreCase("stop")) {
                input = in.readLine();

                if (input.equals("shuffle")) {
                    deck.shuffle();

                    LOGGER.info("Deck shuffled!");
                } else if (input.equals("deal")) {
                    Card card = deck.dealOneCard();

                    String dealtCard = Optional.ofNullable(card)
                        .map(Card::toString)
                        .orElse("No more cards to deal!");

                    LOGGER.info(dealtCard);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void showOptions() {
        LOGGER.info(
            "Welcome to DeckOfCardsApp. Available options are \"shuffle\" (shuffles the deck including already dealt "
                + "cards) and \"deal\" (returns the following card of the deck). Type \"stop\" to exit the program");
    }
}
