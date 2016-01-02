package Table;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import Player.Player;
import Server.HumanThread;

public class Table {
int dealerButton,sB,sBValue,bB,bBValue,maxBet;
int pot;
ArrayList<Player> players = new ArrayList<Player>();
ArrayList<Player> activePlayers;
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
		activePlayers = new ArrayList<Player>(players);
		Collections.copy(activePlayers, players);
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
		System.out.println("End of Round!");
		nextRound();
}
	return (int)players.get(0).getId();
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
	if((activePlayers.size()+allinPlayers.size())==1)
	{
		if(activePlayers.isEmpty())
		{
			ArrayList<Integer> helper=new ArrayList<Integer>();
			int k=players.indexOf(allinPlayers.get(0));
			helper.add(k);
			potToWinner(helper);
			helper=null;
		}else
		{
			ArrayList<Integer> helper=new ArrayList<Integer>();
			int k=players.indexOf(activePlayers.get(0));
			helper.add(k);
			potToWinner(helper);
			helper=null;
		}
	}else
	{
		while(communityCards.size()<5)
		{
			turnOrRiver();
		}
	Card[] cm=CommunityCardsToArray(communityCards);
	ArrayList<Integer> winners = new ArrayList<Integer>();
	winners.add(0);
	int max=0;
	for(int i=0;i<n;i++)
	{
		if((activePlayers.contains(players.get(i)))||(allinPlayers.contains(players.get(i))))
		{
		powerofcards.add((new PowerOfCards(cm)).determineHandRank(players.get(i).getArrayHand()));	
		}
		else{
			powerofcards.add(new BigInteger("-1"));
		
		}
		if(powerofcards.get(i).compareTo(powerofcards.get(max))==1)
		{
			max=i;
			winners.clear();
			winners.add(i);
		} else if(powerofcards.get(i).compareTo(powerofcards.get(max))==0)
		{
			winners.add(i);
		}
		
	}
	potToWinner(winners);
	}
	for(int j=n-1;j>=0;j--)
	{
		players.get(j).hideCards();
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
private void potToWinner(ArrayList<Integer> winners) {
	
	System.out.print("Round "+round+" winners are Players ");
	for(int i=0;i<winners.size();i++)
	{
		System.out.print(+players.get(winners.get(i)).getId()+" ");
		if((i+1==winners.size())&& pot%winners.size()!=0)
		{
			players.get(winners.get(i)).setChips(players.get(winners.get(i)).getChips()+(pot/winners.size())+pot%winners.size());
		}
		else{
	players.get(winners.get(i)).setChips(players.get(winners.get(i)).getChips()+(pot/winners.size()));	
		}
	}
	System.out.println("");
	for(int j=0;j<players.size();j++)
	{
		players.get(j).setBet(0);
	}
	
}
private boolean isEnd() {
	if((activePlayers.size()<2 && allinPlayers.isEmpty())||activePlayers.size()==0)
		return true;
	return false;
}
private void betting(int i) {
	while(!endBetting())
	{
		int temp;
		if(i>=activePlayers.size())
		{
			i=i%activePlayers.size();
		}
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
			ArrayList<Player> help = new ArrayList<Player>();
			help=activePlayers;
			Collections.copy(help,activePlayers);
			allinPlayers.add(activePlayers.get(i));
			help=null;
			activePlayers.remove(i);
		
		}
		else{
			maxBet=temp;
			i=(i+1)%activePlayers.size();
		}
			if(isEnd()==true)
			{
				break;
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

