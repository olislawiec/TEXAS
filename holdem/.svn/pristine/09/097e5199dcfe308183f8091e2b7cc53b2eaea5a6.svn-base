package Table;
import static org.junit.Assert.*;

import java.math.BigInteger;

import org.junit.Test;


public class PowerOfCardsTest {
	/*ROYAL_FLUSH, 9999999999
	STRAIGHT_FLUSH, 19...
	FOUR_OF_A_KIND, 18...
	FULL_HOUSE,	17....
	FLUSH, 16...
	STRAIGHT, 15...
	THREE_OF_A_KIND, 14...
	TWO_PAIR, 13...
	PAIR, 12...
	HIGH_CARD 11....;*/
	@Test
	public void ROYAL_FLUSH() {
		
    	Card[] hand=new Card[2];
    	Card[] table=new Card[5];
    	hand[0]=new Card(7,1,0);
    	hand[1]=new Card(8,1,0);
    	table[0]=new Card(9,1,0);
    	table[1]=new Card(10,1,0);
    	table[2]=new Card(11,1,0);
    	table[3]=new Card(12,1,0);
    	table[4]=new Card(13,1,0);    	
    	PowerOfCards power=new PowerOfCards(table);
    	assertEquals(new BigInteger("9999999999999"),(power.determineHandRank(hand)));		
	}
	@Test
	public void STRAIGHT_FLUSH() {
		Card[] hand=new Card[2];
    	Card[] table=new Card[5];
    	hand[0]=new Card(7,1,0);
    	hand[1]=new Card(8,1,0);
    	table[0]=new Card(9,1,0);
    	table[1]=new Card(10,1,0);
    	table[2]=new Card(11,1,0);
    	table[3]=new Card(12,1,0);
    	table[4]=new Card(6,1,0); 
    	PowerOfCards power=new PowerOfCards(table);  	
    	assertEquals(new BigInteger("190000000012"),(power.determineHandRank(hand)));		
	}

	@Test
	public void FOUR_OF_A_KIND() {
		Card[] hand=new Card[2];
    	Card[] table=new Card[5];
    	hand[0]=new Card(9,1,0);
    	hand[1]=new Card(9,2,0);
    	table[0]=new Card(9,3,0);
    	table[1]=new Card(9,4,0);
    	table[2]=new Card(10,1,0);
    	table[3]=new Card(11,1,0);
    	table[4]=new Card(12,1,0);    	
    	PowerOfCards power=new PowerOfCards(table);
    	assertEquals(new BigInteger("180000000009"),(power.determineHandRank(hand)));		
	}
	@Test
	public void FULL_HOUSE() {
		Card[] hand=new Card[2];
    	Card[] table=new Card[5];
    	hand[0]=new Card(9,1,0);
    	hand[1]=new Card(9,2,0);
    	table[0]=new Card(9,3,0);
    	table[1]=new Card(5,4,0);
    	table[2]=new Card(5,1,0);
    	table[3]=new Card(4,1,0);
    	table[4]=new Card(4,2,0);    	
    	PowerOfCards power=new PowerOfCards(table);
    	assertEquals(new BigInteger("170000000905"),(power.determineHandRank(hand)));		
	}
	@Test
	public void FLUSH() {
		Card[] hand=new Card[2];
    	Card[] table=new Card[5];
    	hand[0]=new Card(1,1,0);
    	hand[1]=new Card(2,1,0);
    	table[0]=new Card(3,1,0);
    	table[1]=new Card(4,1,0);
    	table[2]=new Card(6,1,0);
    	table[3]=new Card(7,1,0);
    	table[4]=new Card(8,1,0);    	
    	PowerOfCards power=new PowerOfCards(table);
    	assertEquals(new BigInteger("160807060403"),(power.determineHandRank(hand)));		
	}
	@Test
	public void STRAIGHT() {
		Card[] hand=new Card[2];
    	Card[] table=new Card[5];
    	hand[0]=new Card(1,1,0);
    	hand[1]=new Card(2,2,0);
    	table[0]=new Card(3,3,0);
    	table[1]=new Card(4,4,0);
    	table[2]=new Card(5,1,0);
    	table[3]=new Card(6,2,0);
    	table[4]=new Card(7,1,0);    	
    	PowerOfCards power=new PowerOfCards(table);
    	assertEquals(new BigInteger("150706050403"),(power.determineHandRank(hand)));		
	}
	@Test
	public void THREE_OF_A_KIND() {
		Card[] hand=new Card[2];
    	Card[] table=new Card[5];
    	hand[0]=new Card(1,1,0);
    	hand[1]=new Card(2,2,0);
    	table[0]=new Card(3,3,0);
    	table[1]=new Card(6,4,0);
    	table[2]=new Card(6,1,0);
    	table[3]=new Card(6,2,0);
    	table[4]=new Card(7,3,0);    	
    	PowerOfCards power=new PowerOfCards(table);
    	assertEquals(new BigInteger("140000000006"),(power.determineHandRank(hand)));		
	}
	@Test
	public void TWO_PAIR() {
		Card[] hand=new Card[2];
    	Card[] table=new Card[5];
    	hand[0]=new Card(7,1,0);
    	hand[1]=new Card(7,2,0);
    	table[0]=new Card(6,3,0);
    	table[1]=new Card(6,4,0);
    	table[2]=new Card(5,1,0);
    	table[3]=new Card(5,2,0);
    	table[4]=new Card(4,3,0);    	
    	PowerOfCards power=new PowerOfCards(table);
    	assertEquals(new BigInteger("130000000706"),(power.determineHandRank(hand)));		
	}
	@Test
	public void PAIR() {
		Card[] hand=new Card[2];
    	Card[] table=new Card[5];
    	hand[0]=new Card(7,1,0);
    	hand[1]=new Card(7,2,0);
    	table[0]=new Card(1,3,0);
    	table[1]=new Card(2,4,0);
    	table[2]=new Card(4,1,0);
    	table[3]=new Card(9,2,0);
    	table[4]=new Card(10,3,0);    	
    	PowerOfCards power=new PowerOfCards(table);
    	assertEquals(new BigInteger("120000000007"),(power.determineHandRank(hand)));		
	}
	@Test
	public void HIGH_CARD() {
		Card[] hand=new Card[2];
    	Card[] table=new Card[5];
    	hand[0]=new Card(11,1,0);
    	hand[1]=new Card(9,2,0);
    	table[0]=new Card(8,3,0);
    	table[1]=new Card(7,4,0);
    	table[2]=new Card(4,1,0);
    	table[3]=new Card(3,2,0);
    	table[4]=new Card(1,3,0);    	
    	PowerOfCards power=new PowerOfCards(table);
    	assertEquals(new BigInteger("111109080704"),(power.determineHandRank(hand)));		
	}
}
