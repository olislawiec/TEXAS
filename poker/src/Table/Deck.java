package Table;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
	public static ArrayList<Card> cards;
	 Hand[] hand;

	Deck() {
		cards = new ArrayList<Card>();
		int rank, suit, number = 1;
		for (suit = 1; suit <= 4; suit++) {
			for (rank = 1; rank <= 13; rank++) {
				cards.add(new Card(rank,suit, number));
				number++;
			}
	}
	}


	void shuffling() {
		
		int random = 0;
		Random generator = new Random();
		
		for (int i = 52; i >= 1; i--) {

			random = generator.nextInt(i);
			Card cd = cards.get(random);
			cards.add(cd);
			cards.remove(random);

		}
		
	}
	boolean deal(int players,int cardsInHands){
		hand= new Hand[players];
		if(players*cardsInHands<=52){
		for(int i=0;i<players;i++){
			hand[i]=new Hand();
		}
		for(int i=1;i<=cardsInHands;i++)
		{
			for(int j=0;j<players;j++)
			{
				hand[j].addCard(cards.get(0));
				cards.remove(0);
				
			}
		}
		}
		else{
			return false;
		}
		return true;
	}
	public Hand getHand(int i)
	{
		return hand[i];
	}
	public Card getCard()
	{
		Card tmp = cards.get(0);
		cards.remove(0);
		return tmp;
	}
}

