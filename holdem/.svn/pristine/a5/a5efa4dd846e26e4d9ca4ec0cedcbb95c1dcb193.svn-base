package Table;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Stream;


public class PowerOfCards {
	BigInteger Power;
	private Card[] table = new Card[5];

	public enum HandRank {

		ROYAL_FLUSH,
		STRAIGHT_FLUSH,
		FOUR_OF_A_KIND,
		FULL_HOUSE,
		FLUSH,
		STRAIGHT,
		THREE_OF_A_KIND,
		TWO_PAIR,
		PAIR,
		HIGH_CARD;
	}



	public PowerOfCards() {
	}

	public PowerOfCards(Card[] table) {
		this.table = table;
	}

	public Card[] getTable() {
		return table;
	}

	public void setTable(Card[] table) {
		this.table = table;
	}

	public void printTable() {
		for (Card c : table) {
			System.out.println(c);
		}
	}
	public Card[] sort(Card[] allCards)
	{
		int nic=1;
		for(int i=6;nic==1;)
		{
			nic=1;
			boolean change =false;
			for(int j=5;j>=0;j--,i--)
			{        		
				if(allCards[i].getRankInt()<allCards[j].getRankInt())
				{

					Card help=allCards[i];
					allCards[i]=allCards[j];
					allCards[j]=help;       
					change=true;
				}

			}
			i=6;
			if(change==false)
			{
				nic=0;
			}
		}
		return allCards;

	}
	public BigInteger determineHandRank(Card[] flop) 
	{
		Card[] allCards=new Card[7];
		for(int i=0;i<5;i++)
		{
			allCards[i]=table[i];
		}
		allCards[5]=flop[0];
		allCards[6]=flop[1];
		allCards=sort(allCards);

		if (isARoyalFlush(allCards)) {
			return Power;
		} else if (isAStraightFlush(allCards)) {
			return Power;
		} else if (isAFourOfAKind(allCards)) {
		return Power;
		} else if (isAFullHouse(allCards)) {
		return Power;
		} else if (isAFlush(allCards)) {
		return Power;
		} else if (isAStraight(allCards)) {
		return Power;
		} else if (isThreeOfAKind(allCards)) {
		return Power;
		} else if (isTwoPair(allCards)) {
		return Power;
		} else if (isPair(allCards)) {
		return Power;
		} else {
			isHighCard(allCards);
		return Power;
		}

	}


	public boolean isARoyalFlush(Card[] flop) {

		int[] suits=new int[20];
		for(Card a:flop)
		{
			suits[a.getSuitInt()]++;
		}
		int miejsce=0;
		int g=0;
		boolean jest=false;
		for(int a:suits)
		{
			if(a>=5)
			{
				miejsce=g;
				jest=true;
			}
			g++;
		}
		if(jest==false)
		{
			return false;
		}
		else
		{
			
			int i=0;
			ArrayList<Card> kartys=new ArrayList<Card>();
			Card[] karty=new Card[5];
			for(Card karta:flop)
			{
				if(karta.getSuitInt()==miejsce)
				{
					kartys.add(karta);

				}
			}
			
			int czyjest[]=new int[kartys.size()-4];
			for(int m=0;m<kartys.size()-4;m++)
			{
				
			int liczenierank=kartys.get(m).getRankInt()-1;
			for(int h=m;h<m+5;h++)
				{
				
				if(kartys.get(h).getRankInt()-1!=liczenierank)
				{
					czyjest[m]=0;
					break;
				}
				liczenierank=kartys.get(h).getRankInt();
				czyjest[m]=1;
				}
			}
			if(kartys.get(kartys.size()-5).getRankInt()==9 && czyjest[kartys.size()-5]==1)
			{
				Power=new BigInteger("9999999999999");
				
				return true;
			}
			else
			{
				return false;
			}
		}
		
	}
	public boolean isAStraightFlush(Card[] flop)
	{
		int[] suits=new int[4];
		for(Card a:flop)
		{
			suits[a.getSuitInt()]++;
		}
		int miejsce=0;
		int g=0;
		boolean jest=false;
		for(int a:suits)
		{
			if(a>=5)
			{
				miejsce=g;
				jest=true;
			}
			g++;
		}
		if(jest==false)
		{
			return false;
		}
		else
		{
			
			
			ArrayList<Card> kartys=new ArrayList<Card>();
			for(Card karta:flop)
			{
				if(karta.getSuitInt()==miejsce)
				{
					kartys.add(karta);

				}
			}
			
			int czyjest[]=new int[kartys.size()-4];
			for(int m=0;m<kartys.size()-4;m++)
			{
				
			int liczenierank=kartys.get(m).getRankInt()-1;
			for(int h=m;h<m+5;h++)
				{
				if(kartys.get(h).getRankInt()-1!=liczenierank)
				{
					czyjest[m]=0;
					break;
				}
				liczenierank=kartys.get(h).getRankInt();
				czyjest[m]=1;
				}
			}
			for(int m=kartys.size()-5;m>=0;m--)
			{
				if(czyjest[m]==1)
				{
					Power=new BigInteger("190000000000");
					Power=Power.add(new BigInteger(Integer.toString(kartys.get(kartys.size()-1).getRankInt())));
					
					return true;
				}
			}
			return false;
		}
	}
	public boolean isAFourOfAKind(Card[] flop)
	{
		int check=0;
		for(int i=0;i<4;i++)
		{
			for(int j=i+1;j<7;j++)
			{
				if(flop[i].getRankInt()==flop[j].getRankInt())
				{
					check++;
				}
			}
			if(check==3)
			{
				
				Power=new BigInteger("180000000000");
				Power=Power.add(new BigInteger(Integer.toString(flop[i].getRankInt())));
				
				
				return true;
			}
			check=0;
		}
		return false;

	}
	public boolean isAFullHouse(Card[] flop)
	{
		int[] trojki=new int[2];
		int trojka=0;
		int para=0;
		int k=0;
		for(int i=0;i<5;i++)
		{
			for(int j=i+1;j<7;j++)
			{
				if(flop[i].getRankInt()==flop[j].getRankInt())
				{
					trojka++;
				}
			}
			if(trojka==2)
			{
				trojki[k]=flop[i].getRankInt();
				k++;

			}
			trojka=0;
		}
		int wieksza=0;
		if(trojki[0]>trojki[1])
		{
			wieksza=trojki[0];
		}
		else wieksza=trojki[1];
		int pary[]=new int[2];
		k=0;
		if(wieksza!=0)
		{		
			for(int i=0;i<6;i++)
			{
				for(int j=i+1;j<7;j++)
				{
					if(flop[i].getRankInt()==flop[j].getRankInt() && flop[i].getRankInt()!=wieksza)
					{
						para++;
					}
				}
				if(para>=1)
				{
					pary[k]=flop[i].getRankInt();
					k++;
					para=0;
				}
				para=0;
			}
		}
		else
		{
			return false;
		}
		if(pary[0]!=0)
		{
			if(pary[0]>pary[1])
			{
				Power=new BigInteger("170000000000");
				int wynik=wieksza*100+pary[0];
				Power=Power.add(new BigInteger(Integer.toString(wynik)));
								return true;
			}
			Power=new BigInteger("170000000000");
			int wynik=wieksza*100+pary[1];
			Power=Power.add(new BigInteger(Integer.toString(wynik)));
			return true;
		}
		return false;
	}
	public boolean isAFlush(Card[] flop)
	{
		int jakikolor=0;
		int kolor=1;
		for(int i=6;i>2;i--)
		{
			for(int j=i-1;j>-1;j--)
			{
				if(flop[i].getSuit()==flop[j].getSuit())
				{
					kolor++;
				}
			}
			if(kolor==5)
			{
				jakikolor=flop[i].getSuitInt();
				String wynik="";
				for(int k=6;k>0 && wynik.length()<10;k--)
				{
					if(flop[k].getSuitInt()==jakikolor)
					{
					if(flop[k].getRankInt()<10)
					{
						wynik+="0"+flop[k].getRankInt();
					}
					else
					{
					wynik+=flop[k].getRankInt();
					}
					}
				}
				Power=new BigInteger("160000000000");
				Power=Power.add(new BigInteger(wynik));
				return true;
			}
			kolor=1;
		}
		return false;
	}
	public boolean isAStraight(Card[] flop)
	{
		ArrayList<Card> cards=new ArrayList<Card>();
		cards.add(flop[0]);
		for(Card a:flop)
		{
			if(cards.get(cards.size()-1).getRankInt()!=a.getRankInt())
			{
				
				cards.add(a);
			}
		}
		Card poczotkowa=cards.get(cards.size()-1);
		int strit=1;
		for(int i=cards.size()-1;i>=0;i--)
		{
			
			if(poczotkowa.getRankInt()==cards.get(i).getRankInt())
			{

			}
			else if(poczotkowa.getRankInt()-1==cards.get(i).getRankInt())
			{
				strit++;
			}
			else
			{
				strit=1;
			}
			if(strit==5)
			{
				String wynik="";
				for(int k=i+4;k>=i;k--)
				{
					if(cards.get(k).getRankInt()<10)
					{
						wynik+="0"+cards.get(k).getRankInt();
					}
					else
					{
					wynik+=cards.get(k).getRankInt();
					}
				}
				Power=new BigInteger("150000000000");
				Power=Power.add(new BigInteger(wynik));
				
				return true;
			}
			poczotkowa=cards.get(i);
		}
		return false;
	}
	public boolean isThreeOfAKind(Card[] flop)
	{
		int[] trojki=new int[2];
		int trojka=0;
		int para=0;
		int jest=0;
		int k=0;
		for(int i=0;i<5;i++)
		{
			for(int j=i+1;j<7;j++)
			{
				if(flop[i].getRankInt()==flop[j].getRankInt())
				{
					trojka++;
					
				}
			}
			if(trojka==2)
			{
				jest=1;
				trojki[k]=flop[i].getRankInt();
				k++;

			}
			trojka=0;
		}
		int wieksza=0;
		if(jest==1)
		{
		if(trojki[0]>trojki[1])
		{
			wieksza=trojki[0];
			Power=new BigInteger("140000000000");
			Power=Power.add(new BigInteger(Integer.toString(wieksza)));
			return true;
		}
		else 
		{
		wieksza=trojki[0];
		Power=new BigInteger("140000000000");
		Power=Power.add(new BigInteger(Integer.toString(wieksza)));
		return true;
		}
		}
		return false;
	}
	public boolean isTwoPair(Card[] flop)
	{	
		ArrayList<Integer> pary=new ArrayList<Integer>();;
		int para=0;
		int k=0;
		for(int i=0;i<6;i++)
		{
			for(int j=i+1;j<7;j++)
			{
				if(flop[i].getRankInt()==flop[j].getRankInt())
				{
					para++;
				}
			}
			if(para==1)
			{
				pary.add(flop[i].getRankInt());
				k++;
				para=0;

			}
			para=0;
		}
		if(pary.size()>1)
		{
			Power=new BigInteger("130000000000");
			Power=Power.add(new BigInteger(Integer.toString(pary.get(pary.size()-1)*100+pary.get(pary.size()-2))));
			
			return true;
		}
		return false;
		
	}
	public boolean isPair(Card[] flop)
	{
		int[] trojki=new int[4];
		int para1=0;
		int para=0;
		int k=0;
		for(int i=0;i<5;i++)
		{
			for(int j=i+1;j<7;j++)
			{
				if(flop[i].getRankInt()==flop[j].getRankInt())
				{
					para1++;
				}
			}
			if(para1==1)
			{
				Power=new BigInteger("120000000000");
				Power=Power.add(new BigInteger(Integer.toString(flop[i].getRankInt())));
				
				return true;
			}
			para1=0;
		}
		return false;
	}
	public boolean isHighCard(Card[] flop)
	{
	
		String wynik="";
		for(int k=6;k>1;k--)
		{
			
			if(flop[k].getRankInt()<10)
			{
				wynik+="0"+flop[k].getRankInt();
			}
			else
			{
			wynik+=flop[k].getRankInt();
			}
		}
		Power=new BigInteger("110000000000");
		Power=Power.add(new BigInteger(wynik));
		
		return true;
		
	}
}