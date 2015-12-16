package Table;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Random;

import Player.Player;
import Server.HumanThread;

public class Table {
int dealerButton,sB,sBValue,bB,bBValue,maxBet;
int pot;
ArrayList<Player> players = new ArrayList<Player>();
ArrayList<Player> activePlayers = new ArrayList<Player>();
ArrayList<Player> allinPlayers = new ArrayList<Player>();
ArrayList<Card> communityCards = new ArrayList<Card>();
ArrayList<BigInteger> powerofcards = new ArrayList<BigInteger>();
Deck deck=null;
int round;

public Table(ArrayList<Player> players,int sBValue,int bBValue)
{
	this.players=players;
	this.sBValue=sBValue;
	this.bBValue=bBValue;
	round=1;
}
public int game()
{
	while(players.size()>=2)
	{
		deck=new Deck();
		activePlayers=players;
		allinPlayers=new ArrayList<Player>();
		pot=0;
		deck.shuffling();
		deal();
		setButtons();
		betting((bB+1)%activePlayers.size());
		if(isEnd()==true)
		{
			nextRound();
			continue;
		}
		System.out.println("Flop!");
		flop();
		betting(sB);
		if(isEnd()==true)
		{
			nextRound();
			continue;
		}
		//turn
		System.out.println("Turn!");
		turnOrRiver();
		betting(sB);
		if(isEnd()==true)
		{
			nextRound();
			continue;
		}
		//river
		System.out.println("River!");
		turnOrRiver();
		betting(sB);
		if(isEnd()==true)
		{
			nextRound();
			continue;
		}
		System.out.println("Show Cards!");
		showCards();
		// TODO Liczenie ukladow 
		//potToWinner
		//nextRound();
		//czyszczenie bets[]
		System.out.println("End of Round!");
}
	return 0;
}
private void showCards() {
	for(int j=0;j<activePlayers.size();j++)
	{
		activePlayers.get(j).showCards();
	}
	
}
private void turnOrRiver() {
	communityCards.add(deck.getCard());	
	for(int i=0;i<players.size();i++)
	{
		players.get(i).showturnOrRiver(communityCards.get(communityCards.size()-1).getNo());
	}
}
public void nextRound() {
	
	int n=players.size();
	Card[] cm=CommunityCardsToArray(communityCards);
	for(int i=0;i<n;i++)
	{
		powerofcards.add((new PowerOfCards(cm)).determineHandRank(players.get(i).getArrayHand()));	
		}
	//potToWinner(0);
	for(int j=n;j>=0;j--)
	{
		if(players.get(j).getChips()==0)
		{
			players.remove(j);
		}
	}
	round++;
	deck=null;
}
private Card[] CommunityCardsToArray(ArrayList<Card> communityCards)
{
	Card[] cm=new Card[5];
	for(int i=0;i<5;i++)
	{
		cm[i]=communityCards.get(i);
	}
	return cm;
}
private void flop() {
	communityCards.add(deck.getCard());
	communityCards.add(deck.getCard());
	communityCards.add(deck.getCard());
	for(int i=0;i<players.size();i++)
	{
		players.get(i).showFlop(communityCards.get(0).getNo(), communityCards.get(1).getNo(), communityCards.get(2).getNo());
	}
}
private void potToWinner(int i) {
	players.get(i).setChips(players.get(i).getChips()+pot);	
}
private boolean isEnd() {
	if(activePlayers.size()<2)
		return true;
	return false;
}
private void betting(int i) {
	while(!endBetting())
	{
		int temp;
		temp=activePlayers.get(i).play(maxBet);
		if(temp==-1)
		{
			activePlayers.remove(i);
		}
		else if(temp==-2)
		{
			if(maxBet<activePlayers.get(i).getBet())
			{
			maxBet=activePlayers.get(i).getBet();
			}
			allinPlayers.add(activePlayers.get(i));
			activePlayers.remove(i);
		}
			maxBet=temp;
			if(isEnd()==true)
			{
				break;
			}else
			{
			i=(i+1)%activePlayers.size();
			}
	setPot();
	setSomeoneBet(true);
	sentChanges();
	}
	for(int j=0;j<activePlayers.size();j++)
	{
		activePlayers.get(j).setWasBet(false);
	}
	setSomeoneBet(false);

}
private void sentChanges() {
	int[] bets=new int[players.size()];
	for(int j=0;j<players.size();j++)
	{
		bets[j]=players.get(j).getBet();
		System.out.print(bets[j]+" ");
	}
	for(int i=0;i<players.size();i++)
	{
		players.get(i).sentChanges(bets);
	}
	
}
private void setSomeoneBet(boolean b) {
	for(int j=0;j<activePlayers.size();j++)
	{
		activePlayers.get(j).setSomeoneBet(b);
	}
	
}
private void setPot() {
	pot=0;
	for(int i=0;i<players.size();i++)
	{
		pot=pot+players.get(i).getBet();
	}
	for(int i=0;i<players.size();i++)
	{
		players.get(i).setPot(pot);
	}
	
}
private boolean endBetting() {
	for(int i=0;i<activePlayers.size();i++)
	{
		if((activePlayers.get(i).getBet()<maxBet) || !activePlayers.get(i).wasBet())
		{
			return false;
		}
	}
	System.out.println("End of Betting");
	return true;
}
public void setButtons() {
	if(round==1)
	{
	int rnd =(new Random()).nextInt(players.size());
	dealerButton=rnd;
	}
	else{
		dealerButton=(dealerButton+1)%players.size();
	}
	sB=(dealerButton+1)%players.size();
	bB=(dealerButton+2)%players.size();
	
	players.get(sB).makeRaise(sBValue);
	players.get(bB).makeRaise(bBValue);
	players.get(sB).setWasBet(false);
	players.get(bB).setWasBet(false);
	setPot();
	maxBet=bBValue;	
}
public void deal() {
	if(deck.deal(players.size(), 2)==true)
	{
		for(int i=0;i<players.size();i++)
		{
			((HumanThread) players.get(i)).setHand(deck.getHand(i));
		}
	}}
}

