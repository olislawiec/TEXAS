package Player;

import Table.Card;

public interface Player{
	
	public long getId();
	public void setId(int id);
	public int getChips();
	public void setChips(int chips);
	public int getBet();
	public void setBet(int bet);
	public void makeBet(int bet);
	public void makeRaise(int bet);
	public void makeCall();
	public void makeCheck();
	public void makeAllin();
	public void makeFold();
	public int play(int maxBet);
	public boolean wasBet();
	public void setWasBet(boolean b);
	public void showCards();
	public void showFlop(int a,int b,int c);
	public void showturnOrRiver(int no);
	public void setPot(int pot);
	public void setSomeoneBet(boolean b);
	public void sentChanges(int[] bets);
	public Card[] getArrayHand();
	public void hideCards();
}
