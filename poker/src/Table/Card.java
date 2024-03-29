package Table;
public class Card {
	private int rank;
	private int suit;
	private int no;
	public String[] suits = { "Hearts", "Spades", "Diamonds", "Clubs" };
	public String[] ranks  = {  "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" ,"Ace"};

	Card(int rank,int suit,int no){
		this.rank=rank;
		this.suit=suit;
		this.no=no;
		
	}
	public int getRankInt()
	{
		return rank;
	}
	public int getSuitInt()
	{
		return suit-1;
	}
	public String getRank()
	{
		return ranks[rank-1];
	}
	public String getSuit()
	{
		return suits[suit-1];
	}
	public int getNo()
	{
		return no;
	}
}