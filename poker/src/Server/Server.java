package Server;

import java.awt.List;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

import Player.Bot;
import Player.Player;
import Table.Table;

public class Server {

	public static void main(String[] args) {
		ServerSocket serversocket;
		Socket socket;
		int humans=3;
		int bots=0;
		int winner;
		int bBValue=4,sBValue=2,chips=250;
		int i=0,NoP=humans+bots;
		ArrayList<Player> players = new ArrayList<Player>();
		Table table;
		
		System.out.println(i+" players of "+NoP);
		while(i<humans)
		{
		try {
			serversocket = new ServerSocket(5217);
			socket = serversocket.accept();
			players.add(new HumanThread(socket,i+1,NoP,chips));
			((Thread) players.get(i)).start();
			i++;
			System.out.println(i+" players of "+NoP);
			} catch (IOException e) 
			{
			}
			
		}
		while(i<NoP)
		{
			players.add(new Bot(i+1));
			i++;
		}
		table = new Table(players,sBValue,bBValue);
		winner=table.game();
		System.out.println("Winner is "+winner);
	}

}
