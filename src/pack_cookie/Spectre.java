package pack_cookie;

/**
 * Spectre.java
 * @author Ethan Ly
 * @author Chandan Reddy
 * CIS 36B, Lab 7.1
 */

import java.util.Random;

public class Spectre extends Character{
    private int numMoves;
    int max;
    
  
  public Spectre() {
    setXPos(6);
    setYPos(5);
    numMoves = 0;
    max = 9;
  }

    public Spectre(int max) {
    	setXPos(max - 3);
      setYPos(max - 4);
      this.max = max;
      numMoves = 0;
    }
    

    public void move() {
        if(numMoves % 7 == 0) {
          generateRandomMove();
        } else if(!(getYPos() == 0)) {
          setYPos(getYPos() - 1);
        } else if(getYPos() == 0 && !(getXPos() < 4)) {
          setXPos(getXPos() - 3);
        } else if(getXPos() == 0 && getYPos() == 0) {
          setXPos(max - 3);
          setYPos(max - 4);
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




