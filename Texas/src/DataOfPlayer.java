public class DataOfPlayer
{
        private int id, myTokens ;
        private String name, cards[];
        private Deck dk;
        DataOfPlayer(int id, Deck dk)
        {
                this.id=id;
                cards = new String[4];
                this.dk=dk;
        }
        //Cards
        public void takeCards()
        {
                for(int i=0; i<2; i++)
                {
                        cards[i]=dk.takeCard(0);
                }
        }
}