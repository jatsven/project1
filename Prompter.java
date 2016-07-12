import java.io.Console;

public class Prompter {
  private Jar mJar;
  public int numberOfGuesses = 0;
  //public double currentHighScore;
  public String nameHighScore = "User";

  public Prompter(Jar jar) {
    mJar = jar;
  }
  
  public void welcomeText(String name) {
    System.out.println("");
    System.out.println("++ ++ ++ ++ ++");
    System.out.printf("+%s+\n", name);
    System.out.println("++ ++ ++ ++ ++");
    System.out.println("");
  }
  
  public String adminItemInput() {
    Console console = System.console();
    String itemInput = console.readLine("\nEnter an item: \n");
    return itemInput;
  }
    
  public int adminNumberInput() {
    Console console = System.console();
    String numberInputAsString = console.readLine("\nEnter a maximum number: \n");
    int numberInput = Integer.parseInt(numberInputAsString);
    return numberInput;
  }
    
  public int playerNumberInput() {
    Console console = System.console();
    String numberInputAsString = console.readLine("\nEnter a number: \n");
    int playerNumberInput = Integer.parseInt(numberInputAsString);
    while(playerNumberInput < 1 || playerNumberInput > mJar.getMaximumNumber()) {
      numberInputAsString = console.readLine("\nThis number is out of boundary. Enter a new number: \n");
    playerNumberInput = Integer.parseInt(numberInputAsString);
    }
    return playerNumberInput;
  }
  
  public void displayInfoToPlayer() {
    System.out.printf("\nThe jar has capacity for at most %d %s(e)s.\n",
                    mJar.getMaximumNumber(),
                    mJar.getItemName());
  }
  
  public void promptForGuess() {
    int randomNumber = mJar.FillJar(mJar.getMaximumNumber());
    int playersGuess = playerNumberInput();
    String guessFeedback = "";
    
    while(playersGuess != randomNumber) {
      increaseNumberOfGuesses(1);
      if(playersGuess < randomNumber) {
        guessFeedback = "too LOW";
      } else {
        guessFeedback = "too HIGH";
      }
      System.out.printf("\nWrong number, number is %s. Try again.", guessFeedback);
      System.out.printf("\nYou have guessed %d time(s).\n",getNumberOfGuesses());
      displayInfoToPlayer();
      playersGuess = playerNumberInput();
    }
      increaseNumberOfGuesses(1);
      System.out.printf("\nWohoo. You guessed correct number!!");
      System.out.printf("\nThere are %d %s(s) in the jar!!",
                        randomNumber,
                        mJar.getItemName());
      System.out.printf("\nYou needed %d guess(es)", numberOfGuesses);
      
    }

  public void increaseNumberOfGuesses(int n) {
    numberOfGuesses += n;
  }
  
  public int getNumberOfGuesses() {
    return numberOfGuesses;
  }
  
  public double yourScore() {
    System.out.printf("\n\n");
    System.out.printf("You needed %d guess(es) in a jar containing at most %d items",
                      numberOfGuesses,
                      mJar.getMaximumNumber());
    double numberOfGuessesAsDouble = (double) numberOfGuesses;
    double maximumNumberAsDouble = (double) mJar.getMaximumNumber();
    double yourScore = numberOfGuessesAsDouble / maximumNumberAsDouble;
    System.out.printf("\nThis gives you the score: (number of guesses)/(maximum possible number of items in jar) =\n(%d/%d) = %f\n",
                      numberOfGuesses,
                      mJar.getMaximumNumber(),
                      yourScore);
    System.out.printf("\n");
    System.out.printf("NOTE:\nAfter completed guessing game you always get a score as: 0 < yourScore\nThe CLOSER your score is to zero, the BETTER:)\n");
    
    return yourScore;
  }
  
  
}

  
  