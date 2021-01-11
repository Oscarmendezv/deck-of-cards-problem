# Deck Of Cards Problem

_This is my solution to the deck Of Cards Problem. The solution I proposed it's a Java console application, as it makes things easier to test and to interact with the program. In a real environment, functionalities would probably be exposed by endpoints._

Assumptions:
   - In my approach, I've assumed that when shuffling the dealt cards are returned to the deck (in order to continue dealing cards).
   - Application might be extended with further functionalities (such as other types of decks or cards) in the future, so the solution I proposed makes this easier.
   - In case card values want to be compared at some point (which sounds likely to me), I've assigned integer values to the poker card values as well (although they are not used in the current state of the program).

## Getting Started 🚀

My solution consists of a console Java application. It's built with Maven. 

On the first start, a sorted deck is generated. After that, the application will keep running accepting commands for its functioning.
The available commands are:
   - shuffle : it shuffles the deck, including again the already dealt cards
   - dealOneCard : it returns the first card of the deck
   - stop : exits the execution of the application


## Testing ⚙️

I've used JUnit to test functionalities of the application. Randomness in the shuffle has not been tested, as it's hard to prove and I've used a widely known algorithm for it.
