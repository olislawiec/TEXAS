package Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import Player.Player;
import Table.Card;
import Table.Hand;

public class HumanThread extends Thread implements Player{

	Socket socket;
	PrintWriter out;
	BufferedReader in;
	int id,NoP,chips,bet,maxBet;
	boolean wasBet=false;
	Hand hand;
	
	public HumanThread(Socket socket,int id,int NoP,int chips){
		hand=null;
		this.socket=socket;
		this.id=id;
		this.NoP=NoP;
		this.chips=chips;
		try {
			out =new PrintWriter(socket.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out.println("N");
			out.println(NoP);
			setChips(chips);
			setId(id);
		} catch (IOException e) {
			System.out.println("IN OUT serwer filed");
		}
	}

public void run()
{
	
		while(true)
		{
			
		}
	
}
public int play(int maxBet)
{
	this.maxBet=maxBet;
	System.out.println("Player "+id+" turn");
	out.println("Play");
	out.println(maxBet);
	int newBet=-1;
	String method;
	try {
		method=in.readLine();
		System.out.println("Player "+id+" "+method);
		switch (method)
		{
		case "makeRaise":
		{
			newBet=Integer.parseInt(in.readLine());
			makeRaise(newBet);
			break;
		}
		case "makeCall":
		{
			newBet=maxBet;
			makeCall();
			break;
		}
		case "makeBet":
		{
			newBet=Integer.parseInt(in.readLine());
			makeBet(newBet);
			break;
		}
		case "makeFold":
		{
			newBet=-1;
			makeFold();
			break;
		}
		case "makeAllin":
		{
			makeAllin();
			newBet=-2;
			break;
		}
		case "makeCheck":
		{
			newBet=maxBet;
			makeCheck();
			break;
		}
		default:
		{
			break;
		}
		}
		} 
	catch (IOException e) {
		System.out.println("Disconnect");
		}
	
	return newBet;
}
public Hand getHand() {
	return hand;
}
public Card[] getArrayHand() {
	Card[] cards=new Card[2];
	cards[0]=hand.getCard(0);
	cards[1]=hand.getCard(1);
	return cards;
}
public void setHand(Hand hand) {
	this.hand=hand;
	out.println("setHand");
	out.println(hand.getCard(0).getNo());
	out.println(hand.getCard(1).getNo());
	
}
@Override
public long getId() {
return id;	
}
public void setId(int id) {
	this.id=id;
	out.println("setId");
	out.println(id);
	
}
public int getChips() {
	return chips;
}
public void setChips(int chips) {
	this.chips=chips;
	out.println("setChips");
	out.println(chips);	
}
public int getBet() {
	return bet;
}
public void setBet(int bet) {
	this.bet=bet;
	out.println("setBet");
	out.println(bet);
}
public boolean wasBet() {
	return wasBet;
}
public void setWasBet(boolean b) {
	wasBet=b;
	out.println("wasBet");
	out.println(wasBet);
	
}
public void showCards() {
	out.println("showCards");
}
public void setPot(int pot){
	out.println("setPot");
	out.println(pot);
}
@Override
public void makeCall() {
	int tmp=this.maxBet-this.bet;
	setChips(this.chips-tmp);
	setBet(this.maxBet);
	setWasBet(true);
}
@Override
public void makeCheck() {
	setWasBet(true);
}
@Override
public void makeAllin() {
	setBet(this.bet+this.chips);
	setChips(0);
	setWasBet(true);
	
	
}
@Override
public void makeFold() {
	setWasBet(true);
	
}
@Override
public void makeBet(int bet) {
	int tmp=bet-this.bet;
	setBet(bet);
	setChips(this.chips-tmp);
	setWasBet(true);
}
@Override
public void makeRaise(int bet) {
	int tmp=bet-this.bet;
	setBet(bet);
	setChips(this.chips-tmp);
	setWasBet(true);
}
public void showFlop(int a,int b,int c)
{
	out.println("showFlop");
	out.println(a);
	out.println(b);
	out.println(c);
}
@Override
public void showturnOrRiver(int no) {
	out.println("showturnOrRiver");
	out.println(no);
}

@Override
public void setSomeoneBet(boolean b) {
	out.println("setSomeoneBet");
	out.println(b);
	
}

@Override
public void sentChanges(int[] bets) {
	out.println("sentChanges");
	out.println(bets.length);
	for(int i=0;i<bets.length;i++)
	{
		out.println(bets[i]);
	}
}
}
