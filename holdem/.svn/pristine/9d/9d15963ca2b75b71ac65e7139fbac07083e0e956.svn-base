package Table;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Table.Card;
import Table.Hand;


public class HandTest {
	Hand hand;
	@Before
	public void SetUp(){
		hand=new Hand();
	}
	@After
	public void tearDown() throws Exception {
		hand=null;
	}

	@Test
	public void addCardWorks() {
		int beforeLength=hand.cards.size();
		hand.addCard(new Card(1,1,0));
		int afterLength=hand.cards.size();
		assertNotSame(beforeLength,afterLength);
		
	}
	@Test
	public void getCardWorks() {
		Card card = new Card(2,2,0);
		hand.addCard(card);
		assertEquals(card,hand.cards.get(hand.cards.size()-1));
		
	}

}