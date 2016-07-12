import java.util.Random;

public class Jar {
  private String mItemName;
  private int mMaximumNumber;
  private int mPlayerGuess;


  public void setItemName(String itemName) {
    mItemName = itemName;
  }

  public String getItemName() {
    return mItemName;
  }
    
  public void setMaximumNumber(int maximumNumber) {
    mMaximumNumber = maximumNumber;
  }

  public int getMaximumNumber() {
    return mMaximumNumber;
  }
  
  public int FillJar(int number) {
    Random random = new Random();
    return random.nextInt(number) + 1;
  }
  
}