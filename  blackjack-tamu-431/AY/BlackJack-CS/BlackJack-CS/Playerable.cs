using engine;

namespace player {

public interface Playerable
{
   void addCardToHand( Card temp );

   void resetHand();

   bool isHitting();

   void setWinCount( int numWins );

   int getWinCount();

   int getHandSize();

   int getHandValue();
}
}