import constants.Rank;
import constants.Suit;

import java.util.*;

public class Black {

    public Map<Player, List<Card>> playersAndAssignedCards = new HashMap<>();
    public Stack<Card> stackOfCards;
    //public List<Card>listOfAllCards = new ArrayList<>();
    public List<Player>listOfPlayers  = new ArrayList<>();

    //create new set of cards
    public void createCards(){

        stackOfCards = new Stack<>();

        for (Rank rank: Rank.values()){
            Card card = new Card(Suit.Hearts, rank);
            stackOfCards.push(card);
        }

        for (Rank rank: Rank.values()){
            Card card = new Card(Suit.Clubs, rank);
            stackOfCards.push(card);
        }

        for (Rank rank: Rank.values()){
            Card card = new Card(Suit.Diamonds, rank);
            stackOfCards.push(card);
        }

        for (Rank rank: Rank.values()){
            Card card = new Card(Suit.Spades, rank);
            stackOfCards.push(card);
        }

        Collections.shuffle(stackOfCards);

    }// End of createCards


    //Assign players with cards
    public void assignCards(Player player, int numberOfCards){

        List<Card>listOfCards = new ArrayList<>();

        for(int i = 1; i <= numberOfCards; i++){
            listOfCards.add(stackOfCards.pop());
            player.setPlayerCards(listOfCards);
        }

        //listOfAllCards.add(stackOfCards.pop());
        playersAndAssignedCards.put(player, listOfCards);
        listOfPlayers.add(player);
    } //End of assignCards

}
