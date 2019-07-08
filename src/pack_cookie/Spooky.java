package pack_cookie;

/**
 * Spooky.java
 * @author Ethan Ly
 * @author Chandan Reddy
 * CIS 36B, Lab 7.1
 */

import java.util.Random;

public class Spooky extends Character{
    private int numMoves;
    int max;
    
  
  public Spooky() {
    setXPos(8);
    setYPos(7);
    numMoves = 0;
    max = 9;
  }
  
    public Spooky(int max) {
    	setXPos(max - 1);
      setYPos(max - 2);
      this.max = max;
      numMoves = 0;
    }
    

    public void move() {
        if(numMoves % 5 == 0) {
          generateRandomMove();
        } else if(!(getYPos() == 0)) {
          setYPos(getYPos() - 1);
        } else if(getYPos() == 0 && !(getXPos() == 9)) {
          setXPos(getXPos() + 1);
        } else if(getXPos() == 0 && getYPos() == max) {
          setXPos(max - 1);
          setYPos(max - 2);
        }
      	numMoves++;
    }
    

    public void generateRandomMove() { 
      Random rand = new Random();
    	int randXPos = rand.nextInt(max);
    	setXPos(randXPos);
    	int randYPos = rand.nextInt(max);
    	setYPos(randYPos);
    }
}

