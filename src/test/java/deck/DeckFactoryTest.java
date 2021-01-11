package deck;


import com.github.oscarmendezv.deckofcards.deck.Deck;
import com.github.oscarmendezv.deckofcards.deck.DeckFactory;
import com.github.oscarmendezv.deckofcards.deck.DeckType;
import org.junit.Assert;
import org.junit.Test;

public class DeckFactoryTest {

    @Test
    public void createDeck_WhenGivenPokerDeckType_ShouldReturnValidPokerDeck() {
        Deck deck = DeckFactory.createDeck(DeckType.POKER);

        Assert.assertNotNull(deck.dealOneCard());
        Assert.assertEquals(52, deck.getCards().size());
    }
}
