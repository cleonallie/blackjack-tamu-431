namespace engine
{

    public abstract class Card
    {
        public static string[] FACES = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};
        private string suit;
        private int face;
   
        public Card()
        {
           
            face = 0;
            suit = "";
        }

        public Card(int f, string s)
        {
            face = f;
            suit = s;
        }

        public void setFace(int f)
        {
            face = f;
        }

        public void setSuit(string s)
        {
            suit = s;
        }

        public int getFace()
        {
            return face;
        }

        public string getSuit()
        {
            return suit;
        }

        // Abstracted because card value depends on the game as well as the card
        public abstract int getValue();

        public bool equals(object obj)
        {
            if (obj == null)
                return false;

            Card compareCard = (Card)obj;
            if (compareCard.getFace() == this.getFace())
            {
                if (compareCard.getSuit().Equals(this.getSuit()))
                    return true;
            }
            return false;
        }

        public bool isPair(object obj)
        {
            Card compareCard = (Card)obj;

            // if not a face card 
            if (compareCard.getFace() < 10)
                // same face
                return compareCard.getFace() == this.getFace();
            else
                return this.getFace() >= 10;
        }

        public string toString()
        {
            return FACES[face] + " of " + getSuit() + " | value = " + getValue();
        }
    }
}