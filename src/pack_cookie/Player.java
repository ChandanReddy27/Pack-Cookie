package pack_cookie;

public final class Player extends Character{
    private int score;
    
    /**
     * Player default constructor
     * Gives the player a starting
     * position of [0,0] on the board
     * and sets score to 0
     */
    public Player() {
    	setXPos(0);
    	setYPos(0);
    	score = 0;
    }
    
    /**
     * Returns the player's current score
     * @return the score
     */
    public int getScore() {
        return score;
    }
    
    /**
     * Updates the player's score
     */
    public void updateScore() {
        this.score++;
    }
}


