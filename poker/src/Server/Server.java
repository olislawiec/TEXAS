package Server;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.net.*;
import java.util.ArrayList;

import javax.swing.JFrame;

import Player.Bot;
import Player.Player;
import Table.Table;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Button;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Server extends JFrame implements ChangeListener{
	static Server server;
	
	static int humans;
	static int bots;
	static int winner;
	static int bBValue;
	static int sBValue;
	static int chips;
	
	static int NoP;
	static ArrayList<Player> players = new ArrayList<Player>();
	static Table table;
	JSpinner sChips,sSB,sBB;
	Choice chPlayers,chBots;
	Button btnStart;
	public void start()
	{
		ServerSocket serversocket;
		Socket socket;
		int i=0;
		System.out.println(i+" players of "+NoP);
		while(i<humans)
		{
		try {
			serversocket = new ServerSocket(5218);
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
	public Server()
	{
		getContentPane().setBackground(Color.DARK_GRAY);
		setSize(262,303);
		setTitle("Server");
		getContentPane().setLayout(null);
		chPlayers = new Choice();
		chPlayers.setBounds(138, 33, 52, 20);
		getContentPane().add(chPlayers);
		chPlayers.addItemListener(new ItemListener(){
	        public void itemStateChanged(ItemEvent ie)
	        {
	        	chBots.removeAll();
	        	for(int i=0;i<=chPlayers.getSelectedIndex()+1;i++)
	        chBots.add(""+(i));
	        }});
		for(int i=2;i<=10;i++)
		{
			chPlayers.add(i+"");
		}
		
		
		Label lblPlayers = new Label("Players");
		lblPlayers.setForeground(Color.WHITE);
		lblPlayers.setBounds(55, 33, 77, 22);
		getContentPane().add(lblPlayers);
		
		Label lblBots = new Label("Bots");
		lblBots.setForeground(Color.WHITE);
		lblBots.setBounds(55, 65, 77, 22);
		getContentPane().add(lblBots);
		
		chBots = new Choice();
		chBots.setBounds(138, 65, 52, 20);
		getContentPane().add(chBots);
		chBots.add("0");
		chBots.add("1");
		
		btnStart = new Button("Run Server");
		btnStart.setBounds(55, 219, 135, 22);
		getContentPane().add(btnStart);
		btnStart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				humans=(chPlayers.getSelectedIndex()+2)-chBots.getSelectedIndex();
				bots=chBots.getSelectedIndex();
				bBValue=(Integer)sBB.getValue();
				sBValue=(Integer)sSB.getValue();
				chips=(Integer)sChips.getValue();
				NoP=chPlayers.getSelectedIndex()+2;
				server.setVisible(false);
				
				start();
				
			}
			
		});
		
		Label lblSB = new Label("Small Blind");
		lblSB.setForeground(Color.WHITE);
		lblSB.setBounds(55, 158, 77, 22);
		getContentPane().add(lblSB);
		
		Label lblBB = new Label("Big Blind");
		lblBB.setForeground(Color.WHITE);
		lblBB.setBounds(55, 129, 77, 22);
		getContentPane().add(lblBB);
		
		sSB = new JSpinner();
		sSB.setModel(new SpinnerNumberModel(new Integer(2), null, null, new Integer(1)));
		sSB.setToolTipText("");
		sSB.setBounds(137, 160, 53, 20);
		getContentPane().add(sSB);
		
		sBB = new JSpinner();
		sBB.setModel(new SpinnerNumberModel(new Integer(4), null, null, new Integer(1)));
		sBB.setBounds(137, 129, 53, 20);
		getContentPane().add(sBB);
		sBB.addChangeListener(this);
		
		Label lblChips = new Label("Chips");
		lblChips.setForeground(Color.WHITE);
		lblChips.setBounds(55, 98, 77, 22);
		getContentPane().add(lblChips);
		
		sChips = new JSpinner();
		sChips.setModel(new SpinnerNumberModel(new Integer(250), null, null, new Integer(10)));
		sChips.setBounds(138, 98, 52, 20);
		getContentPane().add(sChips);
		sChips.addChangeListener(this);
	}
	public static void main(String[] args) {
		server=new Server();
		server.setVisible(true);
		server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		
		sBB.setModel(new SpinnerNumberModel(new Integer((Integer)sBB.getValue()), null,(Integer)sChips.getValue()-1, new Integer(1)));
		sSB.setModel(new SpinnerNumberModel(new Integer((Integer)sSB.getValue()), null,(Integer)sBB.getValue()-1, new Integer(1)));
		
	}
	
	
	
	
}
