package Table;
import java.util.ArrayList;

public class Hand 
{
	public ArrayList<Card> cards;
	Hand(){
		cards = new ArrayList<Card>();
		
	}
	
	
 public void addCard(Card card)
 {
	 
	 cards.add(card);
 }
 public Card getCard(int i)
 {
	 return cards.get(i);
 }

}
