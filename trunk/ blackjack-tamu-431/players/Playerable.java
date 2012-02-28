package players;

import engine.Card;

public interface Playerable
{
   public void addCardToHand( Card temp );

   public void resetHand();

   public boolean isHitting();

   public void setWinCount( int numWins );

   public int getWinCount();

   public int getHandSize();

   public int getHandValue();
}