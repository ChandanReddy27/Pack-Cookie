package pack_cookie;

/**
 * Game.java
 * @author Chandan Reddy
 * @author Ethan Ly
 * CIS 36B, Lab 7.1
 */

import java.util.Scanner;

public class Game {
	private int upperX;
	private int upperY;
	private int totalCookies;

	private Ghost g;
	private Player p;
	private Spooky s;
	private Spectre c;
	private String board[][];

	/**
	 * Constructor for the Game class Initializes private variables Calls initialize
	 * board to intialize the board. Places characters at their starting positions
	 */
	public Game() {
		initializeBoard();
		totalCookies = 96;
		g = new Ghost();
		s = new Spooky();
		c = new Spectre();
		p = new Player();
		board[p.getYPos()][p.getXPos()] = "P";
		board[g.getYPos()][g.getXPos()] = "G";
		board[s.getYPos()][s.getXPos()] = "S";
		board[c.getYPos()][c.getXPos()] = "C";
	}

	/**
	 * Initializes the board to all *s Called by the constructor
	 */
	private void initializeBoard() {
		board = new String[10][10];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				board[i][j] = "*";
			}
		}
	}

	/**
	 * Places the player and ghost at a new spot on the board
	 */
	public void updateBoard(String move) {
		if (move.equals("u")) {
			p.moveUp();
			if (board[p.getYPos()][p.getXPos()].equals("*")) {
				p.updateScore();
			}
			board[p.getYPos()][p.getXPos()] = "P";
		}
		if (move.equals("d")) {
			p.moveDown();
			if (board[p.getYPos()][p.getXPos()].equals("*")) {
				p.updateScore();
			}
			board[p.getYPos()][p.getXPos()] = "P";
		}
		if (move.equals("l")) {
			p.moveLeft();
			if (board[p.getYPos()][p.getXPos()].equals("*")) {
				p.updateScore();
			}
			board[p.getYPos()][p.getXPos()] = "P";
		}
		if (move.equals("r")) {
			p.moveRight();
			if (board[p.getYPos()][p.getXPos()].equals("*")) {
				p.updateScore();
			}
			board[p.getYPos()][p.getXPos()] = "P";

		}
		g.move();
		s.move();
		c.move();
		if (g.getYPos() == s.getYPos() && g.getXPos() == s.getXPos()) {
			g.move();
		}
		if (g.getYPos() == c.getYPos() && g.getXPos() == c.getXPos()) {
			c.move();
		}
		if (s.getXPos() == c.getXPos() && s.getYPos() == c.getYPos()) {
			s.move();
		}
		board[p.getYPos()][p.getXPos()] = "P";
		board[g.getYPos()][g.getXPos()] = "G";
		board[s.getYPos()][s.getXPos()] = "S";
		board[c.getYPos()][c.getXPos()] = "C";
	}

	/**
	 * Replaces the current location of the player and ghost with two blank spaces
	 */
	public void clearBoard() {
		board[g.getYPos()][g.getXPos()] = " ";
		board[p.getYPos()][p.getXPos()] = " ";
		board[s.getYPos()][s.getXPos()] = " ";
		board[c.getYPos()][c.getXPos()] = " ";
	}

	/**
	 * Prints out board as shown in sample output including displaying the current
	 * score
	 */
	public void printBoard() {
		System.out.println("Score: " + p.getScore());
		for (int i = 0; i < board.length; i++) {
			System.out.println("\n");
			for (int j = 0; j < board[i].length; j++) {
				System.out.print(board[i][j] + " ");
			}
		}
	}

	public boolean gameBoundary(String move) {
		if (move.equalsIgnoreCase("u")) {
			if (p.getYPos() == 0) {
				return false;
			}
		}
		if (move.equalsIgnoreCase("d")) {
			if (p.getYPos() == 9) {
				return false;
			}
		}
		if (move.equalsIgnoreCase("l")) {
			if (p.getXPos() == 0) {
				return false;
			}
		}
		if (move.equalsIgnoreCase("r")) {
			if (p.getXPos() == 9) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Determines whether the player has lost by either being eaten by the ghost or
	 * because there are not enough cookies left on the board to win
	 * 
	 * @return whether the player has lost
	 */
	public boolean gameOverLose() {
		if (p.getXPos() == g.getXPos() && p.getYPos() == g.getYPos()) {
			return true;
		}
		if (p.getXPos() == s.getXPos() && p.getYPos() == s.getYPos()) {
			return true;
		}
		if (p.getXPos() == c.getXPos() && p.getYPos() == c.getYPos()) {
			return true;
		}
		if (totalCookies + p.getScore() <= 20) {
			return true;
		}
		return false;
	}

	/**
	 * Determines whether the player has won the game by scoring 20 points
	 * 
	 * @return whether the player has won
	 */
	public boolean gameOverWin() {
		return p.getScore() == 20;
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String choice = "";

		System.out.println("Welcome to Pac-Cookie!\n");
		System.out.println("Your goal is to eat 20 cookies!");
		System.out.println("But, beware the not-so-friendly ghost..." + "\nHe will eat the cookies... and YOU!");
		System.out.println("\nReady to play? Let's go!\n");

		Game game = new Game();

		// Add your code here!
		while (game.gameOverLose() == false || game.gameOverWin() == false) {
			game.printBoard();
			System.out.print("\n\nHow do you want to move? (u/d/l/r): ");
			choice = input.nextLine();
			if (choice.equalsIgnoreCase("u") || choice.equalsIgnoreCase("d") || choice.equalsIgnoreCase("l")
					|| choice.equalsIgnoreCase("r")) {
				if (game.gameBoundary(choice)) {
					game.clearBoard();
					game.updateBoard(choice);
				} else {
					System.out.println("\nOuch!\n");
					continue;
				}
			} else {
				System.out.println("Invalid move!");
				continue;
			}
			if (game.gameOverLose()) {
				game.printBoard();
				System.out.println("\n\nYou lose!");
				break;
			} else if (game.gameOverWin()) {
				game.printBoard();
				System.out.println("\n\nCongratulations! You win!\nFinal Score: 20");
				break;
			}
		}
		input.close();

	}
}