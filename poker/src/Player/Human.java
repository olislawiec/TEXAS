package Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.*;

import Table.Card;

public class Human extends Thread implements Player{
	private int id;
	private int chips;
	private int bet;
	int maxBet;
	private int pot;
    private  Socket socket;
    private  PrintWriter out;
    private  BufferedReader in;
    private boolean wasBet=false;
    static int NoP;
    int card1;
	int card2;
	static HumanGui gui;
	ArrayList<Integer> playersBet = new ArrayList<Integer>();
	boolean someoneBet=false;

    public Human(Socket socket)
    {
    	try {
    		gui = new HumanGui(this);
    		gui.setVisible(true);
    		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		    this.socket=socket;
		    out = new PrintWriter(socket.getOutputStream(), true);
		    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		    
		}catch(IOException e)
		{
			
		}
    	
    }
	
	public long getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getChips() {
		return chips;
	}
	public void setChips(int chips) {
		this.chips = chips;
		gui.setChips(chips);
	}
	public int getBet() {
		return bet;
	}
	public void setBet(int bet) {
		this.bet = bet;
		gui.lblMyBet.setText(""+bet);
	}
	public void makeBet(int bet)
	{
		out.println("makeBet");
		out.println(bet);
	}
	@Override
	public void makeRaise(int bet) {
		out.println("makeRaise");
		out.println(bet);
		
	}
	@Override
	public void makeCall() {
		out.println("makeCall");
		
	}
	@Override
	public void makeCheck() {
		out.println("makeCheck");
		
	}
	@Override
	public void makeAllin() {
		out.println("makeAllin");
		
	}
	@Override
	public void makeFold() {
		out.println("makeFold");
	}

	@Override
	public boolean wasBet() {
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
	public void run() {
		String command;
	    try {
			while((command=in.readLine())!=null)
			{
			switch(command){
			case "Play":
			{
				int maxbet=Integer.parseInt(in.readLine());
				maxBet=maxbet;
				gui.slider.setMinimum(maxBet);
				setPossibleAction(maxBet);
				break;
			}
			case "setPot":
			{
				int pot=Integer.parseInt(in.readLine());
				setPot(pot);
				break;
			}
			case "setHand":
			{
				card1=Integer.parseInt(in.readLine());
				card2=Integer.parseInt(in.readLine());
				gui.showMyCards(card1,card2);
				break;
			}
			case "N":
			{
				NoP=Integer.parseInt(in.readLine());
				gui.prepareNoP(NoP);
				break;
			}
			case "setChips":
			{
				int chips=Integer.parseInt(in.readLine());
				setChips(chips);
				break;
			}
			case "setId":
			{
				int id=Integer.parseInt(in.readLine());
				setId(id);
				break;
			}
			case "setBet":
			{
				int bet=Integer.parseInt(in.readLine());
				setBet(bet);
				break;
			}
			case "wasBet":
			{
				boolean b=Boolean.parseBoolean(in.readLine());
				setWasBet(b);
				break;
			}
			case "setSomeoneBet":
			{
				boolean b=Boolean.parseBoolean(in.readLine());
				setSomeoneBet(b);
				break;
			}
			case "showCards":
			{
				//TODO
				System.out.println("Koniec rundy");
				break;
			}
			case "showFlop":
			{
				int a=Integer.parseInt(in.readLine());
				int b=Integer.parseInt(in.readLine());
				int c=Integer.parseInt(in.readLine());
				showFlop(a,b,c);
				break;
			}
			case "showturnOrRiver":
			{
				int a=Integer.parseInt(in.readLine());
				showturnOrRiver(a);
				break;
			}
			case "sentChanges":
			{
				int length=Integer.parseInt(in.readLine());
				int[] bets = new int[length];
				for(int i=0;i<length;i++)
				{
					bets[i]=Integer.parseInt(in.readLine());
				}
				for(int i=0;i<length-1;i++)
				{
					gui.players.get(i).setText(""+bets[(i+id)%length]);
				}
				break;
			}
			case "hideCards":
			{
				hideCards();
				break;
			}
			default:
			{
			break;	
			}
			}
				
			}
		} catch (IOException e) {
			System.out.println("Error with reading");
			e.printStackTrace();
		}
		
	}
	private void setPossibleAction(int maxBet) {
		if((maxBet+1)<chips)
		{
		gui.slider.setValue(maxBet+1);
		}else
		{
			gui.slider.setValue(chips);
		}
		gui.btnFold.setEnabled(true);
		gui.btnAllin.setEnabled(true);

		if(someoneBet==false)
		{
			if(chips<maxBet)
			{
				gui.btnBet.setEnabled(false);
				gui.btnCall.setEnabled(false);
				gui.btnCheck.setEnabled(false);
				gui.btnRaise.setEnabled(false);
				gui.raiseMemory=false;
			}
			else
			{
				if(bet<maxBet)
				{
					gui.btnBet.setEnabled(true);
					gui.btnCall.setEnabled(false);
					gui.btnCheck.setEnabled(false);
					gui.btnRaise.setEnabled(false);
					gui.raiseMemory=false;
				}else
				{
					gui.btnBet.setEnabled(true);
					gui.btnCall.setEnabled(false);
					gui.btnCheck.setEnabled(true);
					gui.btnRaise.setEnabled(false);
					gui.raiseMemory=false;
				}
			}
		}
		else
		{
			if(chips<maxBet)
			{
				gui.btnBet.setEnabled(false);
				gui.btnCall.setEnabled(false);
				gui.btnCheck.setEnabled(false);
				gui.btnRaise.setEnabled(false);
				gui.raiseMemory=false;
			}
			else
			{
				if(bet<maxBet)
				{
					gui.btnBet.setEnabled(false);
					gui.btnCall.setEnabled(true);
					gui.btnCheck.setEnabled(false);
					gui.btnRaise.setEnabled(true);
					gui.raiseMemory=true;
				}else
				{
					gui.btnBet.setEnabled(false);
					gui.btnCall.setEnabled(false);
					gui.btnCheck.setEnabled(true);
					gui.btnRaise.setEnabled(true);
					gui.raiseMemory=true;
				}
			}
		}
		
	}

	@Override
	public void showFlop(int a, int b, int c) {
		gui.showCommunityCards(a);
		gui.showCommunityCards(b);
		gui.showCommunityCards(c);
		
	}

	@Override
	public void showturnOrRiver(int no) {
		gui.showCommunityCards(no);
		
	}

	@Override
	public int play(int maxBet) {		
		return 0;
	}

	@Override
	public void setPot(int pot) {
		gui.lblPot.setText("Pot: "+pot);
		
	}

	@Override
	public void setSomeoneBet(boolean b) {
		someoneBet=b;
		
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
		for(int i=0;i<gui.communityCards.size();i++)
			gui.communityCards.get(i).setVisible(false);
		
	}
	
}
