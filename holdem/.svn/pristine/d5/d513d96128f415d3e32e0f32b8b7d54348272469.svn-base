package Table;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Table.Deck;
public class DeckTest {
Deck deck;
	@Before
	public void SetUp(){
		deck=new Deck();
	}
	@After
	public void tearDown() throws Exception {
		deck=null;
	}
	
	@Test
	public void DeckExist(){
		assertNotNull(deck);
		
	}
	
	@Test
	public void NotEnoughCards(){
		assertFalse(deck.deal(5, 11));
		
	}
	
	@Test
	public void shufflingWorks(){
		deck.shuffling();
		assertNotEquals("0123",""+deck.cards.get(0).getNo()+deck.cards.get(1).getNo()+deck.cards.get(2).getNo()+deck.cards.get(3).getNo());
	}
	
	@Test
	public void FullDeck(){
		assertSame(52,deck.cards.size());
	}
	
		
	
	
	

}
