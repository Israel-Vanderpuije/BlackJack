import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int id;
    public List<Card>playerCards = new ArrayList<>();

    //Setters
    public void setPlayerCards(Card card) {
        this.playerCards.add(card);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getPlayerCards() {
        for (Card card : playerCards){
            //return card.getRank() + " of " + card.getSuit();
            System.out.println(card.getRank() + " of " + card.getSuit());
        }
        return null;
    }

    public List<Card> getPlayerCardsList(){
        return playerCards;
    }

    /**
     * Constructor for Player
     * @param name name of player
     * @param id id of player
     */
    public Player(String name, int id) {
        this.name = name;
        this.id = id;

    }

    //Player toString
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", playerCards=" + playerCards +
                '}';
    }
}
