
/**
 * A class that can be used to create poker cards in a standard 52 card French
 * deck. Cards can be one of 13 faces, one of four suits, and one of two colors.
 * Methods will get the names, faces, values, suits, or colors of the cards and
 * can flip the card face up or face down
 * @author Brian
 */
public class Card {
    
    /**
     * The face value of an Ace
     */
    public static final int ACE = 0; 
    /**
     * The face value of a Two
     */
    public static final int DEUCE = 1; 
    /**
     * The face value of a Two
     */
    public static final int TWO = 1; 
    /**
     * The face value of a Three
     */
    public static final int TRE = 2; 
    /**
     * The face value of a Three
     */
    public static final int THREE = 2; 
    /**
     * The face value of a Four
     */
    public static final int FOUR = 3; 
    /**
     * The face value of a Five
     */
    public static final int FIVE = 4;
    /**
     * The face value of a Six
     */
    public static final int SIX = 5; 
    /**
     * The face value of a Seven
     */
    public static final int SEVEN = 6;
    /**
     * The face value of an Eight
     */
    public static final int EIGHT = 7; 
    /**
     * The face value of a Nine
     */
    public static final int NINE = 8; 
    /**
     * The face value of a Ten
     */
    public static final int TEN = 9; 
    /**
     * The face value of a Jack
     */
    public static final int JACK = 10; 
    /**
     * The face value of a Queen
     */
    public static final int QUEEN = 11; 
    /**
     * The face value of a King
     */
    public static final int KING = 12; 
    
    /**
     * Value of a Diamond
     */
    public static final int DIAMONDS = 0; 
    /**
     * Value of a Club
     */
    public static final int CLUBS = 1; 
    /**
     * Value of a Club
     */
    public static final int HEARTS = 2; 
    /**
     * Value of a Spade
     */
    public static final int SPADES = 3;
            
    private int suit; 
    //Will contain a value from 0 to 3. Will represent the suits of cards from
    //smallest suit to largest (diamond, club, heart, spades)
    private int face; //Will contain a value from 0 to 12, from Ace to King
    private boolean isFaceUp; //Tells whether the card is face up or face down
    /**
     * Create a card with suit cSuit, face cFace, and facing direction faceDir
     * @param cSuit Suit of the Card
     * @param cFace Face of the Card
     * @param faceDir Face up (true) or Face down (false)
     */
    public Card(int cSuit, int cFace, boolean faceDir){
        suit = cSuit;
        face = cFace;
        isFaceUp = faceDir;
    }
    
    /**
     * Create a card with suit cSuit, face cFace
     * @param cSuit Suit of the Card
     * @param cFace Face of the Card
     */
    public Card(int cSuit, int cFace){
        suit = cSuit;
        face = cFace;
        isFaceUp = true;
    }
    
    /**
     * Gets the suit of the card
     * @return integer value of the suit of the Card
     */
    public int getSuit(){
        return suit;
    }
    
    /**
     * Gets the color of the card
     * @return Color of the card as a String
     */
    public String getColorName(){
        if(suit == 0 || suit == 2)
            return "Red";
        else
            return "Black";
    }
    
    /**
     * Gets the face, or the name, of the Card
     * @return Face of the Card
     */
    public int getFace(){
        return face;
    }
    
    /**
     * Gets the value of the Card
     * Uses the face of the Card to calculate the value
     * Ace is 0, 1-9 are itself, 10 and higher are 10
     * @return value of the card
     */
    public int getValue(){
        if(face >= DEUCE && face <= TEN)
            return face;
        else if(face > TEN)
            return 10;
        return -1;
    }
    
    /**
     * Gets the highest value of the card
     * @return integer of the highest possible value of the card
     */
    public int getHighValue() {
        int high = getValue();
        if (high == -1) {
                return 11;
        } else {
                return high;
        }
    }
    
    /**
     * Gets the lowest value of the card
     * @return integer of the lowest possible value of the card
     */
    public int getLowValue() {
        int low = getValue();
        if (low == -1) {
                return 1;
        } else {
                return low;
        }
    }
    
    /**
     * Flips the card orientation
     */
    public void flip(){
        isFaceUp = !isFaceUp;
    }
    
    /**
     * Tells whether the cards is face up
     * @return boolean representing whether the card is face up or down
     */
    public boolean isFaceUp(){
        return isFaceUp;        
    }
    /**
     * Gets the suit name in a string
     * @return String with the suit of the card
     */
    public String getSuitName(){
        switch(suit) {
            case DIAMONDS: return "Diamonds";
            case CLUBS: return "Clubs";
            case HEARTS: return "Hearts";
            case SPADES: return "Spades";
            default: return "Error: No Case";    
        }
    }
    /**
     * Gets the face name in a string
     * @return String with the face of the card
     */
    public String getFaceName() {
        switch (face) {
            case ACE: return "Ace";
            case TWO: return "Two"; 
            case THREE: return "Three"; 
            case FOUR: return "Four"; 
            case FIVE: return "Five"; 
            case SIX: return "Six"; 
            case SEVEN: return "Seven"; 
            case EIGHT: return "Eight"; 
            case NINE: return "Nine";
            case TEN: return "Ten";
            case JACK: return "Jack"; 
            case QUEEN: return "Queen"; 
            case KING: return "King"; 
            default: return "Error: No Face";                 
        }
    }
    
    }
