import java.util.List;

public class Player {

    private String name;
    private int id;
    private List<Card>playerCards;

    //Setters
    public void setPlayerCards(List<Card> playerCards) {
        this.playerCards = playerCards;
    }

    //Getters
    public List<Card> getPlayerCards() {
        return playerCards;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
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
