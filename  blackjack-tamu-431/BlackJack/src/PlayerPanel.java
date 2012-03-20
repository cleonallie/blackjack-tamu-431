
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

//import Card;
//import Hand;

/**
 * A container that shows a player's name, remaining cash, and his hand. It also
 * contains fields for its current bet, the minimum bet, and the card image file.
 * The player can be called upong to do bets, insurance, a game action (for
 * computers), recieve money/winnings, and clear his hand. This panel is not
 * designed, however, to handle splits.
 * @author Vance
 */
public class PlayerPanel extends JPanel {
        
        private String name;
        private boolean isHuman;
        private int money;
        private int bet;
        private int minBet;
        private Hand hand;
        
        private Image cardImgs;
        
        private JLabel moneyDisp;
        private JLabel betDisp;
        
        /**
         * Integer representing a win
         */
        public static final int WIN = 1;
        /**
         * Integer representing a push
         */
        public static final int PUSH = 0;
        /**
         * Integer representing a loss
         */
        public static final int LOSS = -1;
        private static Random rnd = new Random();
        
        /**
         * Easy mode for AI
         */
        public static final int EASY = 1;
        /**
         * Hard mode for AI
         */
        public static final int HARD = 2;
        
        private int previousBet;
        private int previousOutcome;
        private int level;
        
        /**
         * Creates a panel displaying the player's name, his remaining money, and
         * his current bet, as well as his hand.
         * @param pName Name of the player
         * @param isHumanPlayer is the player a human or a computer
         * @param difficulty Difficulty of AI (-1 for human)
         * @param startMoney the starting amount of money player has
         * @param minimumBet the minimum the player is allowed to bet
         * @param cardImages the card images file
         */
        public PlayerPanel(String pName, boolean isHumanPlayer, int difficulty, int startMoney, int minimumBet, Image cardImages) {
                super();        
                setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
                setPreferredSize(new Dimension(99, 325));
                setOpaque(false); 
                Color c = Color.DARK_GRAY;
                if (isHumanPlayer) c = Color.LIGHT_GRAY;
                setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(c), name));
                name = pName;
                isHuman = isHumanPlayer;
                level = difficulty;
                money = startMoney;
                bet = 0;
                minBet = minimumBet;
                hand = null;
                cardImgs = cardImages;          
                moneyDisp = new JLabel("$" + Integer.toString(money));
                moneyDisp.setForeground(new Color(87, 233, 100));
                moneyDisp.setFont(new Font(Font.SERIF, Font.PLAIN, 14));
                betDisp = new JLabel("$" + Integer.toString(0));
                betDisp.setForeground(Color.RED);
                betDisp.setFont(new Font(Font.SERIF, Font.PLAIN, 14));
                add(moneyDisp);
                add(betDisp);   
                
                previousBet = 0;
                previousOutcome = 0;
        }
        
        /**
         * Returns the hand of the dealer, probably for comaparison purposes.
         * @return dealers hand
         */
        public Hand getHand() { return hand; }
        
        /**
         * Clears the player's hand and returns it in an ArrayList
         * @return ArrayList containing the cleared hand
         */
        public ArrayList<Card> clearHand() {
                return hand.clearHand();
        }       
        
        /**
         * For computer players only. Causes player to play Blackjack accordingly.
         * @param dealerCard the dealer's visible card
         * @return -1 means not a computer, 0 means stand, 1 means hit, 2 means surrender, 3 means double
         */
        public int askComputerAction(Card dealerCard) {
                if (!isHuman) {
                    if(hand.isBlackJack()){
                        return 0;
                    }
                    
                    if(hand.isBusted()) {
                        return 0;
                    }
                    if(level == EASY){
                        if(hand.getBestValue() == 11){
                            if (rnd.nextInt(101) < (4/13) * 100){
                                return 3;
                            }
                        }        
                        else{
                            int nowValue = hand.getBestValue();                            
                            if (nowValue <= 11) return 1;
                            double bustingChance = (nowValue - 8) / (double) 13;
                            double successChance = 1 - bustingChance;                            
                            if(rnd.nextInt(120) < successChance*100 - 16) 
                                return 1;
                            else
                                return 0;
                        }
                    }
                    else{ //HARDbot code
                        if (hand.length() == 2) {
                                if((dealerCard.getValue() <= 9 && hand.getBestValue() == 10) ||   
                                                (dealerCard.getValue() <= 10 && hand.getBestValue() == 11))
                                        return 3;
                        }
                        if(dealerCard.getHighValue() >= 7){
                            if(hand.getBestValue() >=17) return 0;
                            else return 1;
                        }
                        else if(dealerCard.getHighValue() <= 6){
                            if(hand.getBestValue() > 11) return 0;
                            else return 1;
                        } 
                        else return 0; //just in case
                    }
                }
                return -1;
        }
        
        /**
         * New hand for player with Card c1 and Card c2
         * @param c1 First Card in Hand
         * @param c2 Second Card in Hand
         */
        public void startHand(Card c1, Card c2){
            hand = new Hand(c1, c2);
        }
        
        /**
         * Gets the betting amount from player. If it is human, it pops up a dialog
         * asking for an amount. For computers, it is calculated internally. The
         * bet is automatically subtracted from the players total money.
         * @param count Current card count
         * @return amount to bet
         */
        public int askBet(int count) {
                int normalBet;
                if (isHuman) {
                        normalBet = askHumanBet("Remember, the minimum wager is $" + minBet +
                                        ". How much will are you betting?", minBet, money);
                } else {
                        normalBet = previousBet;
                        
                        if (level == EASY) {
                                int rand = rnd.nextInt(3);                              
                                if (previousOutcome == LOSS) 
                                        normalBet -= minBet * rand;                             
                                else if (previousOutcome == PUSH);
                                else if (previousOutcome == WIN)
                                        normalBet += minBet * rand;                             
                        }
                        else if (level == HARD) {
                                int optimal = minBet*(count);
                                normalBet = optimal;
                        }
                        
                        if (normalBet > money / 20)
                                normalBet = money/20;                   
                        if (normalBet < minBet)
                                normalBet = minBet;
                        
                        previousBet = normalBet;
                }
                money -= normalBet;
                bet = normalBet;
                updateText();
                return normalBet;
        }
        
        
        /**
         * Gets the betting amount from player for insurance. If it is human, it 
         * pops up a dialog asking for an amount. For computers, it is calculated 
         * internally. The bet is automatically subtracted from the players total money.
         * @param count Current card count
         * @return amount to bet
         */
        public int askInsurance(int count) {
                int insureBet;
                if (isHuman) {
                        insureBet = askHumanBet("My hand's looking pretty nice. You can " +
                                        "take insurance against Blackjack for 2:1 odds, but only " +
                                        "with up to half your original bet ($" + bet/2 + "). How " +
                                        "much will it be?", -1, Math.min(money, bet / 2));
                } else {
                        insureBet = 0;
                        if (level == EASY) {            
                                if (rnd.nextInt(4) == 0)
                                        insureBet = Math.min(money, bet / 2);
                        }
                        else if (level == HARD) {
                                if (count >= 3) 
                                        insureBet = Math.min(money, bet / 2);
                        }
                }
                money -= insureBet;
                updateText();
                return insureBet;
        }
        
        /**
         * Lets the player double his/her bet and take one more card
         */
        public void doubleDown() {
                money -= bet;
                bet *= 2;
        }
        
        /**
         * Adds to player's total money amount moneyWon.
         * @param moneyWon amount of money to add
         */
        public void addWinnings(int moneyWon) {
                money += moneyWon;
                updateText();
                                
                if (moneyWon > bet) {
                        previousOutcome = WIN;
                        moneyDisp.setText(moneyDisp.getText() + "  :)");
                } else if (moneyWon == bet) {                   
                        previousOutcome = PUSH;
                        moneyDisp.setText(moneyDisp.getText() + "  :|");
                } else {
                        previousOutcome = LOSS;
                        moneyDisp.setText(moneyDisp.getText() + "  :(");
                }
        }
        
        /**
         * Resets player's betting amount and his hand.
         * @param c1 First Card in new Hand
         * @param c2 Second Card in new Hand
         */
        public void newRound(Card c1, Card c2) {
                bet = 0;
                updateText();
                startHand(c1, c2);              
        }
        
        /**
         * Gets the current betting amount of player.
         * @return player's current bet
         */
        public int getCurrentBet() {
                return bet;
        }
        
        /**
         * Gets the amount of money player has left.
         * @return player's remaining cash
         */
        public int getMoney() {
                return money;
        }
        
        /**
         * Paints the cards stacked top-down in addition to the rest of the 
         * components. The cards are arranged so the user can still see all of
         * the cards' values.
         */
        @Override
        public void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (hand == null) return;
                for (int i = 0; i < hand.length(); i++) {
                        drawCard(g, hand.get(i), 10, 52 + 33*i);
                }
        }
        
        /**
         * Pops up an input dialog asking a question for amount to bet. Non-numbers
         * and clicking on cancel/X result in getting "kicked out", but on merely
         * illegal number values a new dialog asks for a correct input.
         * @param msg question to ask to player
         * @param min minimum player can bet
         * @param max maximum player can bet
         * @return
         */
        private int askHumanBet (String msg, int min, int max) {
                int hBet = 0;
                String sBet = JOptionPane.showInputDialog(msg);
                try {
                        hBet = Integer.valueOf(sBet);
                        while (hBet < 0 || hBet < min || hBet > max) {
                                String errReply;
                                if (hBet < 0) {
                                        errReply = "Huh? What did you say?";
                                } else if (hBet < min) {
                                        errReply = "At least $" + min + " needed:";
                                } else {
                                        errReply = "You can't bet that much:";                                                          
                                }
                                sBet = JOptionPane.showInputDialog(errReply);
                                hBet = Integer.valueOf(sBet);   
                        }
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Come back later");
                       // System.exit(0);
                }
                return hBet;
        }
        
        /**
         * Updates the displays of player's remaining money and current bet.
         */
        private void updateText() {
                moneyDisp.setText("$" + Integer.toString(money));
                betDisp.setText("$" + Integer.toString(bet));
        }
        
        /**
         * Paints a card image onto (x,y) of the container. A facedown card will
         * be drawn accordingly.
         * @param g the graphics context
         * @param card the card to be printed
         * @param x the x-position of the printed card in this container
         * @param y the y-position of the printed card in this container
         */
        private void drawCard(Graphics g, Card card, int x, int y) {
         int cx; // top-left x of cardsImage
         int cy; // top-left y of cardsImage
         boolean faceUp = true;
         if (card.isFaceUp() != faceUp) {
                 cx = 2*79;
                 cy = 4*123;
         }
         else {
            cx = (card.getFace())*79;
            switch (card.getSuit()) {
                    case Card.DIAMONDS: cy = 123;       break;
                    case Card.CLUBS:    cy = 0;         break;              
                    case Card.HEARTS:   cy = 2*123;     break;
                    default:            cy = 3*123;     break; //Spades
            }
         }
         g.drawImage(cardImgs,x,y,x+79,y+123,cx,cy,cx+79,cy+123,this);
        }

        /**
         * Gets whether the player is a Human
         * @return Boolean representing whether the player is a human
         */
        public boolean isHuman() {
                return isHuman;
        }
}
