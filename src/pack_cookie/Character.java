package pack_cookie;

/**
 * Character.java
 * @author Ethan Ly
 * @author Chandan Reddy
 * CIS 36B, Lab 7.1
 */
public abstract class Character {
    private int xPos;
    private int yPos;
    
    /**
     * Sets the x (column) location of the character
     * @param x the x position of the character in the x-y plane
     */
    public void setXPos(int x) {
        xPos = x;
    }
    
    /**
     * Sets the y (row) location of the character
     * @param y the y position of the character in the x-y plane
     */
    public void setYPos(int y) {
        yPos = y;
    }
    
    
    /**
     * Returns the x position of the character
     * @return the x position of the character in the x-y plane
     */
    public int getXPos() {
        return xPos;
    }
    
    /**
     * Returns the y position of the character
     * @return the y position of the character in the x-y plane
     */
    public int getYPos() {
        return yPos;
    }
    
    
    /**
     * Moves the character one space to the left
     * by subtracting one from its x position
     * Or, prevents the player from going outside 
     * the bounds of the board by leaving the 
     * character in the same position.
     */
    public void moveLeft() {
        xPos-=1;
    }
    
    /**
     * Moves the character one space to the right
     * by adding one to its x position
     * Or, prevents the player from going outside 
     * the bounds of the board by leaving the 
     * character in the same position.
     */
    public void moveRight() {
        xPos+=1;
    }
    
    /**
     * Moves the character one space down
     * by adding one to its y position
     * Or, prevents the player from going outside 
     * the bounds of the board by leaving the 
     * character in the same position.
     */
    public void moveDown() {
        yPos+=1;
    }
    
    /**
     * Moves the character one space up
     * by subtracting one from its y position
     * Or, prevents the player from going outside 
     * the bounds of the board by leaving the 
     * character in the same position.
     */
    public void moveUp() {
        yPos-=1;
    }
}



