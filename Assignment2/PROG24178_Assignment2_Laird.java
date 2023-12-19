/* Name: Chris Laird
* Class: PROG24178 1231_18326, Winter 2023
* Assignment: Assignment #2 – Games
* Date: February 9, 2023
* Program: PROG24178_Assignment2_Laird.java
* Creating 2 subclasses of superclass Game 
* CardGame and VideoGame
* Then greating to methods one that
* Counts the amount of CardGames in an array of Games
* that has a certain amount of cards in the hand
* Another method capitalizes all the names of the Games
* in the array and if its a VideoGame it will capitalize the 
* device name
*/



import java.util.*;

/**
 * Requirements:
 * 1. Replace LastName in file and class names with your own names.
 * 2. Finish all TODOs. Test your code before submitting it.
 * 3. Do NOT modify ANY provided code.
 */

//A provided class representing a general game
class Game {
    private String name;
    private int numberOfPlayers;
    public Game() { }
    public Game(String name, int numberOfPlayers) { this.name = name; this.numberOfPlayers = numberOfPlayers; }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }
    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }
} // End of Game class

public class PROG24178_Assignment2_Laird {
    private static int tN = 0, pP = 0, fF = 0, tT = 32;
    private static void tout(boolean re) {
        System.out.println(" -Test#" + (++tN) + ": " + (re ? "passed" : "failed"));
        if (re) pP++; else fF++;
    }
    private static void sout(String s) { System.out.println(s); }
    public static void main(String[] args) {
        try { test(); } catch (Exception ex) { sout("  *Exception: " + ex); }
        sout("== Total:" + tT + ", Passed:" + pP + ", Failed:" + fF + ", Skipped:" + (tT - pP - fF));
    }
    public static void test() throws Exception {
        Game[] games = null;
        try {
            sout("\n== Testing countCardGames()...");
            games = new Game[]{
                    new CardGame("a", 2, 0), new CardGame("b", 3, 1),
                    new CardGame("c", 3, 2), new CardGame("d", 2, 3),
                    new Game(), new VideoGame()};
            tout(countCardGames(games, 4) == 0); tout(countCardGames(games, 3) == 1);
            tout(countCardGames(games, 1) == 3); tout(countCardGames(null, -1) == 0);
            tout(countCardGames(new Game[0], 0) == 0); tout(countCardGames(new Game[]{null, new CardGame()}, 0) == 1);
            tout(countCardGames(new Game[]{null, new CardGame("b", 3, 2)}, 2) == 1);
            tout(countCardGames(new Game[]{null, null}, -1) == 0);
            games = new Game[]{new Game("abc", 2), null, new Game(null, 2),
                    new VideoGame(null, 3, "ipad"), new CardGame("klm", 2, 3),
                    new VideoGame("xyz", 3, null), new CardGame(null, 2, 4),
                    new VideoGame(null, 3, null), new CardGame("klm", 2, 1)};
            tout(countCardGames(games, 2) == 2);
        } catch (Exception ex) { sout("  *Exception: " + ex); }

        try {
            sout("\n== Testing capitalizeStrings()...");
            games = new Game[]{new Game("abc", 2), new VideoGame("xyz", 2, "phone"),
                    new Game("xyz", 3), new VideoGame("def", 3, "ipad"),
                    new CardGame("klm", 2, 1)};
            tout(capitalizeStrings(games) == 5); tout(games[0].getName().equals("ABC"));
            tout(games[1].getName().equals("XYZ")); tout(((VideoGame) games[1]).getDevice().equals("PHONE"));
            tout(games[2].getName().equals("XYZ")); tout(games[3].getName().equals("DEF"));
            tout(((VideoGame) games[3]).getDevice().equals("IPAD")); tout(games[4].getName().equals("KLM"));
            tout(capitalizeStrings(null) == 0); tout(capitalizeStrings(new Game[0]) == 0);
            games = new Game[]{new Game("abc", 2), null, null,
                    new VideoGame("def", 3, "ipad"), new CardGame("klm", 2, 1)};
            tout(capitalizeStrings(games) == 3); tout(games[0].getName().equals("ABC"));
            tout(((VideoGame) games[3]).getDevice().equals("IPAD")); tout(games[4].getName().equals("KLM"));
            games = new Game[]{new Game("abc", 2), null, new Game(null, 2),
                    new VideoGame(null, 3, "ipad"), new CardGame("klm", 2, 1),
                    new VideoGame("xyz", 3, null), new CardGame(null, 2, 1),
                    new VideoGame(null, 3, null), new CardGame("klm", 2, 1)};
            tout(capitalizeStrings(games) == 5); tout(games[3].getName() == null);
            tout(((VideoGame) games[3]).getDevice().equals("IPAD")); tout(games[4].getName().equals("KLM"));
            tout(games[5].getName().equals("XYZ")); tout(((VideoGame) games[5]).getDevice() == null);
            tout(games[7].getName() == null); tout(((VideoGame) games[7]).getDevice() == null);
            tout(games[8].getName().equals("KLM"));
        } catch (Exception ex) { sout("  *Exception: " + ex); }
        sout("\n** Testing Finished **");
    }

    /* ==== Do NOT modify any code above this line ==== */

    /*
      + TODO #3: write a public static method named countCardGames that will
        - take an array of games and an int minNumCards as the arguments
        - go over the games in the array, count the number of card games in the
          array which have a number of cards no less than the minNumCards
        - return the count
        - NOTE: array and elements in array can be null
        - NOTE: any element in the array may be or not be a card game.
    */
    
    //method to count the amount of card games that 
    //have a certain number of cards or more
    public static int countCardGames(Game[] games, int minNumCards){

        int count = 0; //setting a count to 0
        
        /*
         * Checking if games array is null
         * if not it will enter a for loop
         * the for loop checks if the games index is not null,
         * the name at that index if not null and if the index is 
         * an instance of CardGame
         * If so a new oject of cardGame is created at that games index
         * Then it checks if the cardGames number or cards is not 0
         * and if its grater than or equal to the minNumCards
         * If it meats those conditions the count will increase
         */
        if(games != null){

            for(int i = 0; i < games.length; i++){
                
                if(games[i] != null && games[i] instanceof CardGame){

                    CardGame cardGame = (CardGame) games[i];

                    if(cardGame.getNumberOfCards() >= minNumCards)
                        count++;

                }
            }
        }

        return count; //returing the count
    }
	

    /*
      + TODO #4: write a public static method named capitalizeStrings that will
        - take an array of games as the argument
        - go over the games in the array, capitalize the names of all games
        - also capitalize the device type, if the game is a video game
        - return the number of games that have been modified
        - Example 1: if current game name is "Chess", then new name is "CHESS"
        - Example 2: if current device is "phone", then new device is "PHONE"
        - NOTE: argument array, elements and values may be null
    */
	
    //method to capitalize the names of games and devices
    public static int capitalizeStrings(Game[] games){

        int modified = 0; //setting a modified counter to 0

        if(games != null){ // checking to see if the argument passed is null

            for(int i = 0; i < games.length; i++){ // if not null then will enter for loop

                /*
                 * checking to see if the index of the array is not null
                 * and the name if that index is not null
                 * if not then a new Game object is created at that index
                 * then greating a new string with that indexes name
                 * then sets that string to upper case
                 * then sets the objects name to the uppercase string
                 * and increases the modified count
                 */
                if(games[i] != null && games[i].getName() != null){

                    Game game = games[i];

                    String name = game.getName();

                    name = name.toUpperCase();

                    game.setName(name);

                    modified++;
                }

                    /*
                     * then it checks if the object at index i is
                     * an instance of VideoGame, if it is then
                     * a new VideoGame object is created and set to 
                     * the object at index i
                     */
                if(games[i] instanceof VideoGame){

                    VideoGame videoGame = (VideoGame) games[i];

                    /*
                     * then it checks if the objects device is null
                     * if not a string is created with the device name of the object
                     * the device string is then converted to uppercase
                     * then the objects device is set to that string
                     * and then if the videoGames name is null the modified will increase
                     * because if it had a name it would have already been modified when
                     * changing names to uppercase
                     */
                    if (videoGame.getDevice() != null){

                        String device = videoGame.getDevice();

                        device = device.toUpperCase();

                        videoGame.setDevice(device);

                        if(videoGame.getName() == null)
                            modified++;
                     }
                 } 
            }
        }   

        return modified; //returns modified amount 
    }
        
    
	
} // End of PROG24178_Assignment2_Lastname class

/*
  + TODO #1: write a CardGame class, a subclass of Game class that has
    - a private field of int type named exactly as numberOfCards
    - a no-arg constructor
    - a all-arg constructor that takes 3 parameters, name, numberOfPlayers, and numberOfCards
    - the get and set methods for numberOfCards, follow convention to name the methods
*/

/*
 * Creating a CardGame subclass
 * that extends the Game superclass
 */
class CardGame extends Game{ 

    private int numberOfCards; //creating a prvt int for numberOfCards

    public CardGame(){ //creating a no arg constructor
    }

    /*
     * creating an all arg constructor
     * this constructor uses the super keyword
     * to access the properties in the superclass
     */
    public CardGame(String name, int numberOfPlayers, int numberOfCards){
        super(name , numberOfPlayers);
        this.numberOfCards = numberOfCards;
    } 
    

    public int getNumberOfCards() { //method to get the number of cards
        return this.numberOfCards;
    }

    public void setNumberOfCards(int numberOfCards) { //method to set the number of cards
        this.numberOfCards = numberOfCards;
    }
    
}


/*
  + TODO #2: write a VideoGame class, a subclass of Game class that has
    - a private field of String type named exactly as device
      - this field is used to represent the primary device for playing the game
      - the value can be for example Desktop, Phone, iPad, etc.
    - a no-arg constructor
    - a all-arg constructor that takes 3 parameters, name, numberOfPlayers, and device
    - the get and set methods for device, follow convention to name the methods
*/

/*
 * Creating a VideoGame subclass
 * that extends the Game superclass
 */
class VideoGame extends Game{

    private String device; //creating prvt string for devices

    public VideoGame(){ //creating a no arg constructor
    }

    /*
     * creating an all arg constructor
     * this constructor uses the super keyword
     * to access the properties in the superclass
     */
    public VideoGame(String name, int numberOfPlayers, String device){
        super(name, numberOfPlayers);
        this.device = device;
    }


    public String getDevice() { //method to get the devices name
        return this.device;
    }

    public void setDevice(String device) { //method to set the devices name
        this.device = device;
    }

}