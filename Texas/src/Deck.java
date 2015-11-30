import java.util.ArrayList;
import java.util.Random;

public class Deck {
        private int countCard=0;
        public ArrayList<Card> cards;
        Deck()
        {
        cards = new ArrayList<Card>();
         int suit, rank;
         for(suit=1; suit<=4; suit++){
                 for(rank=1; rank<=13; rank++){
                         cards.add(new Card(suit, rank));                        
                 }
         }
        }       
        public String takeCard(int cardId)
        {
                String cardName="";
                cardName+=cards.get(cardId).getSuit();
                cardName+=cards.get(cardId).getRank();
                cards.remove(cardId);
                countCard++;
                if(countCard==52)
                {
                        countCard=0;
                        shuffle();
                }
                return cardName;
        }
        void shuffle()
        {
                for(int i=0; i<2*cards.size(); i++)
                {
                        Random r = new Random();
                        int cardId = r.nextInt(cards.size());
                        Card card = cards.get(cardId);
                        cards.remove(cardId);
                        cards.add(r.nextInt(cards.size()), card);
                }
        }
}