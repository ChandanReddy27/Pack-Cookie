package pack_cookie;

/**
 * Ghost.java
 * @author Ethan Ly
 * @author Chandan Reddy
 * CIS 36B, Lab 7.1
 */

import java.util.Random;

public class Ghost extends Character{
    private int numMoves;
    int max;
    
  
  public Ghost() {
    setXPos(9);
    setYPos(9);
    numMoves = 0;
    max = 9;
  }
    /**
     * One argument constructor
     * Calls setXPos() and setYPos()
     * to give the ghost its initial
     * placement at the bottom right
     * of the board
     * Also initializes max (the max
     * x and y dimension on the board)
     * and numMove to 0
     * @param max the 
     */
    public Ghost(int max) {
    	setXPos(max);
      setYPos(max);
      this.max = max;
      numMoves = 0;
    }
    
    /**
     * Moves the Ghost according to an 
     * algorithim:
     * If the number of moves it has made
     * is divisible by 10, it generates a
     * random move. Otherwise, it moves up
     * until it cannot go farther. Then,
     * it moves left until it can go no 
     * farther. 
     * Once it reaches the 0,0
     * corner it jumps back to its starting
     * position. Updates numMoves.
     */
    public void move() {
        if(numMoves % 10 == 0) {
          generateRandomMove();
        } else if(!(getYPos() == 0)) {
          setYPos(getYPos() - 1);
        } else if(getYPos() == 0 && !(getXPos() == 0)) {
          setXPos(getXPos() - 1);
        } else if(getXPos() == 0 && getYPos() == 0) {
          setXPos(max);
          setYPos(max);
        }
      	numMoves++;
    }
    
    /**
     * Places the ghost at a random
     * board position
     */
    public void generateRandomMove() { 
      Random rand = new Random();
    	int randXPos = rand.nextInt(max);
    	setXPos(randXPos);
    	int randYPos = rand.nextInt(max);
    	setYPos(randYPos);
    }
}

