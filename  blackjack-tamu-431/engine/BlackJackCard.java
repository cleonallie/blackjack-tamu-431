package engine;

public class BlackJackCard extends Card
{
	public BlackJackCard()
	{
		super();
	}
	
	public BlackJackCard(int v, String s)
	{
		super(v,s);
	}

  	public int getValue()
	{
		int value = 0;
		
		if (super.getFace() > 10 && super.getFace() != 1)
			value = 10;
		else if (super.getFace() == 1)
			value = 11;
		else
			value = super.getFace();
		
		return value;
	}
}