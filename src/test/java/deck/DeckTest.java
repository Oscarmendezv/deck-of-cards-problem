package deck;

import com.github.oscarmendezv.deckofcards.card.Card;
import com.github.oscarmendezv.deckofcards.card.poker.PokerCard;
import com.github.oscarmendezv.deckofcards.card.poker.PokerCardSuit;
import com.github.oscarmendezv.deckofcards.card.poker.PokerCardValue;
import com.github.oscarmendezv.deckofcards.deck.Deck;
import com.github.oscarmendezv.deckofcards.deck.DeckType;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DeckTest {

    private Deck deck;

    @Before
    public void setUp() {
        List<Card> cardList = new ArrayList<>();
        cardList.add(new PokerCard(PokerCardSuit.CLUBS, PokerCardValue.ACE));
        cardList.add(new PokerCard(PokerCardSuit.CLUBS, PokerCardValue.TWO));
        cardList.add(new PokerCard(PokerCardSuit.CLUBS, PokerCardValue.THREE));

        deck = new Deck(cardList, DeckType.POKER);
    }

    @Test
    public void dealOneCard_ShouldReturnDeckCardsInOrder() {
        Assert.assertSame(PokerCardValue.THREE, ((PokerCard) deck.dealOneCard()).getValue());
        Assert.assertSame(PokerCardValue.TWO, ((PokerCard) deck.dealOneCard()).getValue());
        Assert.assertSame(PokerCardValue.ACE, ((PokerCard) deck.dealOneCard()).getValue());
    }

    @Test
    public void dealOneCard_WhenDealingMoreThanAvailableCards_ShouldNotReturnACard() {
        for(int i = 0; i < 3; i++) {
            deck.dealOneCard();
        }

        Assert.assertNull(deck.dealOneCard());
    }

    @Test
    public void shuffle_ShouldIncludeDealtCards() {
        for(int i = 0; i < 3; i++) {
            deck.dealOneCard();
        }

        Assert.assertNull(deck.dealOneCard());

        deck.shuffle();
        Assert.assertNotNull(deck.dealOneCard());
    }

}
