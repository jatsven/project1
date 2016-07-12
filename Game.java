public class Game {
 
  public static void main(String[] args) {
    Jar jar = new Jar();
    Prompter prompter = new Prompter(jar);
    prompter.welcomeText("ADMINISTRATOR");
    jar.setItemName(prompter.adminItemInput());
    jar.setMaximumNumber(prompter.adminNumberInput());
    prompter.displayInfoToPlayer();
    prompter.welcomeText("PLAYER");
    prompter.promptForGuess();
    prompter.yourScore();
  }
}
