import constants.Rank;
import constants.Suit;

import java.util.*;

public class Black {

    public Map<Player, List<Card>> playersAndAssignedCards = new HashMap<>();
    public Stack<Card> stackOfCards;
    public List<Player>listOfPlayers  = new ArrayList<>();
    public List<Player>winners = new ArrayList<>();

    //create new set of cards
    public void createCards(){

        stackOfCards = new Stack<>();

        for (Rank rank: Rank.values()){
            Card card = new Card(Suit.HEARTS, rank);
            stackOfCards.push(card);
        }

        for (Rank rank: Rank.values()){
            Card card = new Card(Suit.CLUBS, rank);
            stackOfCards.push(card);
        }

        for (Rank rank: Rank.values()){
            Card card = new Card(Suit.DIAMONDS, rank);
            stackOfCards.push(card);
        }

        for (Rank rank: Rank.values()){
            Card card = new Card(Suit.SPADES, rank);
            stackOfCards.push(card);
        }

        Collections.shuffle(stackOfCards);

    }// End of createCards


    //Assign players with cards
    public void assignCards(Player player, int numberOfCards){

        //List<Card>listOfCards = new ArrayList<>();

        for(int i = 1; i <= numberOfCards; i++){
            player.setPlayerCards(stackOfCards.pop());
        }

        playersAndAssignedCards.put(player, player.getPlayerCardsList());
    } //End of assignCards


    //Get player's total number of cards
    public int getValueOfCards(Player player) {
        return playersAndAssignedCards.get(player).stream().
                map(x -> x.getRank().getValue()).
                reduce(0, (a, b) -> a + b);
    }


    /**
     * Game flow
     */

    public void startGame(){

        Player player1 = new Player("Nii", 1);
        listOfPlayers.add(player1);
        Player player2 = new Player("NAA", 2);
        listOfPlayers.add(player2);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter '1' to hit OR '2' to stick ");
        System.out.println();

        for (Player player: listOfPlayers){
            assignCards(player, 2);
            System.out.println(player.getName() +"'s cards are: ");
            player.getPlayerCards();
            System.out.println("Total value  is : " + getValueOfCards(player));
            System.out.println();

        }

        boolean ended = false;

        while (!ended){

            if (listOfPlayers.size() != 0){

                for (Player player : listOfPlayers){
                    System.out.println(player.getName() + "'s turn: ");
                    int option = scanner.nextInt();

                    if (option == 1){
                        assignCards(player, 1);

                        System.out.println(player.getName() + "'s new assigned cards are: ");
                        player.getPlayerCards();
                        System.out.println("Total value  is now: " + getValueOfCards(player));
                        System.out.println();

                    }

                    //remove player if total score is above 21
                    if (getValueOfCards(player) > 21){
                        listOfPlayers.remove(player);
                    }

                    //Add player to winners list is score is 21
                    if (getValueOfCards(player) == 21){
                        winners.add(player);
                    }

                }
            } else ended = true;

            System.out.println("Next Round");

        }

    }
}
