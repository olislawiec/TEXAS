package Player;

import Table.Card;
import Table.Hand;

public class Bot implements Player{
	private int id;
	private boolean wasBet;

	public Bot(int id) {
		this.id=id;
	}

	@Override
	public void setId(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getChips() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setChips(int chips) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getBet() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setBet(int bet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeBet(int bet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeRaise(int bet) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeCall() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeCheck() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeAllin() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void makeFold() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean wasBet() {
		// TODO Auto-generated method stub
		return wasBet;
	}

	@Override
	public void setWasBet(boolean b) {
		wasBet=b;
		
	}

	@Override
	public void showCards() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showFlop(int a, int b, int c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void showturnOrRiver(int no) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int play(int maxBet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPot(int pot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setSomeoneBet(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sentChanges(int[] bets) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Card[] getArrayHand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void hideCards() {
		// TODO Auto-generated method stub
		
	}

}
