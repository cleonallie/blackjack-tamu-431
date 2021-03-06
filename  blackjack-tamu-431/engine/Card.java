package engine;

public abstract class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};
	private String suit;
	private int face;

	Card()
	{
		face = 0;
		suit = "";
	}
	
	Card(int f, String s)
	{
		face = f;
		suit = s;
	}

	public void setFace(int f)
	{
		face = f;
	}
	
	public void setSuit(String s)
	{
		suit = s;
	}

	public int getFace()
	{
		return face;
	}
	
	public String getSuit()
	{
		return suit;
	}
	
	// Abstracted because card value depends on the game as well as the card
  	public abstract int getValue();

	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;
		
		Card compareCard = (Card)obj;
		if (compareCard.getFace() == this.getFace()) {
			if (compareCard.getSuit().equals(this.getSuit()))
				return true;
		}
		return false;
	}
	
	public boolean isPair(Object obj)
	{
		Card compareCard = (Card)obj;

		// if not a face card 
		if (compareCard.getFace()<10)
			// same face
			return compareCard.getFace() == this.getFace();
		else
			return this.getFace() >= 10;
	}

  	public String toString()
	{
		return FACES[face] + " of " + getSuit() + " | value = " + getValue();  	
	}
}