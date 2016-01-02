package Player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;

public class HumanGui extends JFrame implements ActionListener,ChangeListener{
	JButton btnAllin,btnFold,btnBet,btnCheck,btnRaise,btnCall;
	JSlider slider;
	JLabel lblSliderValue,lblCard1,lblCard2;
	JLabel lblPot;
	Human human;
	JLabel cCard1;
	JLabel cCard2;
	JLabel cCard3;
	JLabel cCard4;
	JLabel cCard5;
	JLabel lblMyBet;
	JLabel lblP1Cards,lblP2Cards,lblP3Cards,lblP4Cards,lblP5Cards,lblP6Cards,lblP7Cards,lblP8Cards,lblP9Cards;
	ArrayList<JLabel> communityCards= new ArrayList<JLabel>();
	ArrayList<JLabel> players= new ArrayList<JLabel>();
	private JLabel lblBackground;
	private JLabel lblMyChips;
	boolean raiseMemory;

	public HumanGui(Human human) {
		this.human=human;
		getContentPane().setBackground(new Color(0, 102, 0));
		setSize(514,340);
		setTitle("Texas Hold'em");
		getContentPane().setLayout(null);
		
		btnAllin = new JButton("All-in");
		btnAllin.setBounds(422, 237, 73, 23);
		getContentPane().add(btnAllin);
		btnAllin.addActionListener(this);
		btnAllin.setEnabled(false);
		
		btnFold = new JButton("Fold");
		btnFold.setBounds(10, 237, 73, 23);
		getContentPane().add(btnFold);
		btnFold.addActionListener(this);
		btnFold.setEnabled(false);
		
		btnBet = new JButton("Bet");
		btnBet.setBounds(90, 237, 73, 23);
		getContentPane().add(btnBet);
		btnBet.addActionListener(this);
		btnBet.setEnabled(false);
		
		btnCheck = new JButton("Check");
		btnCheck.setBounds(256, 237, 73, 23);
		getContentPane().add(btnCheck);
		btnCheck.addActionListener(this);
		btnCheck.setEnabled(false);
		
		btnRaise = new JButton("Raise");
		btnRaise.setBounds(339, 237, 73, 23);
		getContentPane().add(btnRaise);
		btnRaise.addActionListener(this);
		btnRaise.setEnabled(false);
		
		btnCall = new JButton("Call");
		btnCall.setEnabled(false);
		btnCall.setBounds(173, 237, 73, 23);
		getContentPane().add(btnCall);
		btnCall.addActionListener(this);
		btnCall.setEnabled(false);
		
		
		lblSliderValue = new JLabel("slider Value");
		lblSliderValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblSliderValue.setForeground(new Color(255, 255, 255));
		lblSliderValue.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSliderValue.setBounds(188, 261, 36, 32);
		getContentPane().add(lblSliderValue);
		
		lblCard1 = new JLabel("");
		lblCard1.setBounds(245, 171, 36, 48);
		getContentPane().add(lblCard1);
		lblCard1.setVisible(false);
		
		lblCard2 = new JLabel("");
		lblCard2.setBounds(208, 171, 36, 48);
		getContentPane().add(lblCard2);
		lblCard2.setVisible(false);
		
		slider = new JSlider();
		slider.setBounds(20, 264, 169, 26);
		getContentPane().add(slider);
		slider.setBackground(new Color(102, 0, 0));
		slider.setForeground(new Color(102, 0, 0));
		slider.addChangeListener(this);
		slider.setMaximum(human.getChips());
		lblSliderValue.setText(slider.getValue()+"");
		
		lblPot = new JLabel("Pot: 0");
		lblPot.setForeground(new Color(255, 255, 255));
		lblPot.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPot.setBounds(406, 257, 79, 36);
		getContentPane().add(lblPot);
		
		cCard1 = new JLabel("");
		cCard1.setBounds(153, 93, 36, 54);
		getContentPane().add(cCard1);
		communityCards.add(cCard1);
		
		cCard2 = new JLabel("");
		cCard2.setBounds(189, 93, 36, 54);
		getContentPane().add(cCard2);
		communityCards.add(cCard2);
		
		cCard3 = new JLabel("");
		cCard3.setBounds(225, 93, 36, 54);
		getContentPane().add(cCard3);
		communityCards.add(cCard3);
		
		cCard4 = new JLabel("");
		cCard4.setBounds(261, 93, 36, 54);
		getContentPane().add(cCard4);
		communityCards.add(cCard4);
		
		cCard5 = new JLabel("");
		cCard5.setBounds(297, 93, 36, 54);
		getContentPane().add(cCard5);
		communityCards.add(cCard5);
		
		lblMyBet = new JLabel("0");
		lblMyBet.setHorizontalAlignment(SwingConstants.CENTER);
		lblMyBet.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMyBet.setForeground(new Color(255, 255, 255));
		lblMyBet.setBounds(163, 149, 166, 23);
		getContentPane().add(lblMyBet);
		
		lblP1Cards = new JLabel("0");
		lblP1Cards.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblP1Cards.setForeground(new Color(255, 255, 255));
		lblP1Cards.setHorizontalAlignment(SwingConstants.LEFT);
		lblP1Cards.setIcon(new ImageIcon("C:\\Users\\domin\\Desktop\\Pokerfinal\\Small cards\\b2fv.png"));
		lblP1Cards.setBounds(10, 152, 89, 48);
		getContentPane().add(lblP1Cards);
		players.add(lblP1Cards);
		
		lblP2Cards = new JLabel("0");
		lblP2Cards.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblP2Cards.setForeground(new Color(255, 255, 255));
		lblP2Cards.setHorizontalAlignment(SwingConstants.LEFT);
		lblP2Cards.setIcon(new ImageIcon("C:\\Users\\domin\\Desktop\\Pokerfinal\\Small cards\\b2fv.png"));
		lblP2Cards.setBounds(10, 93, 89, 48);
		getContentPane().add(lblP2Cards);
		players.add(lblP2Cards);
		
		lblP3Cards = new JLabel("0");
		lblP3Cards.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblP3Cards.setForeground(new Color(255, 255, 255));
		lblP3Cards.setVerticalAlignment(SwingConstants.TOP);
		lblP3Cards.setHorizontalAlignment(SwingConstants.CENTER);
		lblP3Cards.setVerticalTextPosition(JLabel.BOTTOM);
		lblP3Cards.setHorizontalTextPosition(JLabel.CENTER);
		lblP3Cards.setIcon(new ImageIcon("C:\\Users\\domin\\Desktop\\Pokerfinal\\Small cards\\b2fv.png"));
		lblP3Cards.setBounds(38, 11, 79, 71);
		getContentPane().add(lblP3Cards);
		players.add(lblP3Cards);
		
		lblP4Cards = new JLabel("0");
		lblP4Cards.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblP4Cards.setForeground(new Color(255, 255, 255));
		lblP4Cards.setVerticalAlignment(SwingConstants.TOP);
		lblP4Cards.setHorizontalAlignment(SwingConstants.CENTER);
		lblP4Cards.setVerticalTextPosition(JLabel.BOTTOM);
		lblP4Cards.setHorizontalTextPosition(JLabel.CENTER);
		lblP4Cards.setIcon(new ImageIcon("C:\\Users\\domin\\Desktop\\Pokerfinal\\Small cards\\b2fv.png"));
		lblP4Cards.setBounds(127, 11, 76, 71);
		getContentPane().add(lblP4Cards);
		players.add(lblP4Cards);
		
		lblP5Cards = new JLabel("0");
		lblP5Cards.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblP5Cards.setForeground(new Color(255, 255, 255));
		lblP5Cards.setVerticalAlignment(SwingConstants.TOP);
		lblP5Cards.setHorizontalAlignment(SwingConstants.CENTER);
		lblP5Cards.setVerticalTextPosition(JLabel.BOTTOM);
		lblP5Cards.setHorizontalTextPosition(JLabel.CENTER);
		lblP5Cards.setIcon(new ImageIcon("C:\\Users\\domin\\Desktop\\Pokerfinal\\Small cards\\b2fv.png"));
		lblP5Cards.setBounds(208, 11, 72, 71);
		getContentPane().add(lblP5Cards);
		players.add(lblP5Cards);
		
		lblP6Cards = new JLabel("0");
		lblP6Cards.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblP6Cards.setForeground(new Color(255, 255, 255));
		lblP6Cards.setVerticalAlignment(SwingConstants.TOP);
		lblP6Cards.setHorizontalAlignment(SwingConstants.CENTER);
		lblP6Cards.setVerticalTextPosition(JLabel.BOTTOM);
		lblP6Cards.setHorizontalTextPosition(JLabel.CENTER);
		lblP6Cards.setIcon(new ImageIcon("C:\\Users\\domin\\Desktop\\Pokerfinal\\Small cards\\b2fv.png"));
		lblP6Cards.setBounds(297, 11, 72, 71);
		getContentPane().add(lblP6Cards);
		players.add(lblP6Cards);
		
		lblP7Cards = new JLabel("0");
		lblP7Cards.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblP7Cards.setForeground(new Color(255, 255, 255));
		lblP7Cards.setVerticalAlignment(SwingConstants.TOP);
		lblP7Cards.setHorizontalAlignment(SwingConstants.CENTER);
		lblP7Cards.setVerticalTextPosition(JLabel.BOTTOM);
		lblP7Cards.setHorizontalTextPosition(JLabel.CENTER);
		lblP7Cards.setIcon(new ImageIcon("C:\\Users\\domin\\Desktop\\Pokerfinal\\Small cards\\b2fv.png"));
		lblP7Cards.setBounds(379, 11, 73, 71);
		getContentPane().add(lblP7Cards);
		players.add(lblP7Cards);
		
		lblP8Cards = new JLabel("0");
		lblP8Cards.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblP8Cards.setForeground(new Color(255, 255, 255));
		lblP8Cards.setHorizontalAlignment(SwingConstants.RIGHT);
		lblP8Cards.setVerticalTextPosition(JLabel.CENTER);
		lblP8Cards.setHorizontalTextPosition(JLabel.LEFT);
		lblP8Cards.setIcon(new ImageIcon("C:\\Users\\domin\\Desktop\\Pokerfinal\\Small cards\\b2fv.png"));
		lblP8Cards.setBounds(416, 93, 79, 51);
		getContentPane().add(lblP8Cards);
		players.add(lblP8Cards);
		
		lblP9Cards = new JLabel("0");
		lblP9Cards.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblP9Cards.setForeground(new Color(255, 255, 255));
		lblP9Cards.setHorizontalAlignment(SwingConstants.RIGHT);
		lblP9Cards.setVerticalTextPosition(JLabel.CENTER);
		lblP9Cards.setHorizontalTextPosition(JLabel.LEFT);
		lblP9Cards.setIcon(new ImageIcon("C:\\Users\\domin\\Desktop\\Pokerfinal\\Small cards\\b2fv.png"));
		lblP9Cards.setBounds(406, 151, 89, 48);
		getContentPane().add(lblP9Cards);
		players.add(lblP9Cards);
		
		lblMyChips = new JLabel("My chips: 0");
		lblMyChips.setForeground(new Color(255, 255, 255));
		lblMyChips.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMyChips.setBounds(234, 263, 124, 29);
		getContentPane().add(lblMyChips);
		
		lblBackground = new JLabel("");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\domin\\Desktop\\Pokerfinal\\Small cards\\bacground.jpg"));
		lblBackground.setBounds(0, 0, 504, 301);
		getContentPane().add(lblBackground);
		for(int i =0;i<players.size();i++)
		{
		players.get(i).setVisible(false);
		}
		
		for(int i =0;i<communityCards.size();i++)
		{
			communityCards.get(i).setVisible(false);
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource()== btnAllin)
			{
				human.makeAllin();
			}
			if(e.getSource()== btnFold)
			{
				human.makeFold();
			}
			if(e.getSource()== btnBet)
			{
				human.makeBet(slider.getValue());
			}
			if(e.getSource()== btnCheck)
			{
				human.makeCheck();
			}
			if(e.getSource()== btnRaise)
			{
				human.makeRaise(slider.getValue());
			}
			if(e.getSource()==btnCall)
			{
				human.makeCall();
			}
			prepareButtons();
	}
	public void setChips(int chips) {
		lblMyChips.setText("My chips: "+chips);
		slider.setMaximum(chips);	
	}
	//Show slider value in label
	@Override
	public void stateChanged(ChangeEvent arg0) {
		lblSliderValue.setText(slider.getValue()+"");
		
		if(slider.getValue()==slider.getMaximum())
		{
			btnRaise.setEnabled(false);
		}else if(slider.getValue()<=human.maxBet)
		{
			btnRaise.setEnabled(false);
		}else
		{
			btnRaise.setEnabled(raiseMemory);
		}
		
	}
	public void prepareNoP(int NoP) {
		for(int i=0;i<NoP-1;i++)
		{
			players.get(i).setVisible(true);
		}
	}
	public void prepareButtons()
	{
		btnAllin.setEnabled(false);
		btnFold.setEnabled(false);
		btnBet.setEnabled(false);
		btnCheck.setEnabled(false);
		btnRaise.setEnabled(false);
		btnCall.setEnabled(false);
	}

	public void showCommunityCards(int icon) {
		int i=0;
		while(communityCards.get(i).isVisible()==true)
		{
			i++;
		}
		communityCards.get(i).setVisible(true);
		communityCards.get(i).setIcon(new ImageIcon("C:\\Users\\domin\\Desktop\\Pokerfinal\\Small cards\\"+icon+".png"));
	}

	public void showMyCards(int card1, int card2) {
		lblCard1.setIcon(new ImageIcon("C:\\Users\\domin\\Desktop\\Pokerfinal\\Small cards\\"+card1+".png"));
		lblCard2.setIcon(new ImageIcon("C:\\Users\\domin\\Desktop\\Pokerfinal\\Small cards\\"+card2+".png"));
		lblCard1.setVisible(true);
		lblCard2.setVisible(true);
	}
}
