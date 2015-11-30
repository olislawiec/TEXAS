public class Card {     
        public String suit,rank;
        public int suitint,rankint;
        public String[] suits = { "C", "D", "H", "S" };
        public String[] ranks  = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13" };
        Card(int suit,int rank)
        {
                this.suitint=suit-1;
                this.rankint=rank-1;
                this.suit=suits[suit-1];
                this.rank=ranks[rank-1];
        }
        
        public String getRank() 
        {
                return rank; 
        }
        public String getSuit() 
        {               
                return suit;    
        }

}