import java.util.*;

/* GameDriver - Client program that allows a user to play the Game TictacToe.
 * Main is the only method found here. Other static helper methods can 
 * be used to organize the statements in main.
 * @author : Milton Savage
 * 
 */
public class TicTacToeDriver 
{
	static final char P1CHAR = 'X';
	static final char P2CHAR = 'O';
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args)
	{
		Player player1, player2 = null;
		boolean playing = true;
		Player currentPlayer;
		int turns = 0;
		boolean betweenGames = false;
		TicTacToe board = new TicTacToe();

		System.out.println("=======================");
		System.out.println("LET'S PLAY TIC TAC TOE!");
		System.out.println("=======================");
		System.out.println(board);

		
		System.out.println("> Enter the name of Player1:");
		String name1 = scan.next();
		player1 = new Player(name1, P1CHAR);
		System.out.println("Welcome Player 1: "+player1.getName());

		System.out.println("> Enter the name of Player2:");
		String name2 = scan.next();
		player2 = new Player(name2, P2CHAR);
		System.out.println("Welcome Player 2: "+player2.getName());

		currentPlayer = player1;

		while (playing == true){
			changeTile(currentPlayer, board);		//allows player to make a move

			turns ++;

			if (currentPlayer == player1){	//switches player
				currentPlayer = player2;
			}
			else{
				currentPlayer = player1;
			}


			System.out.println(board);		//shows the new state of the board

			Player winningPlayer = board.winner(player1, player2);

			if (winningPlayer == player1){			//checks for a winner
				System.out.println("Congratulations, " + player1.getName() + " you win!");
				wonGame(player1, player2);
				betweenGames = true;
			}
			else if (winningPlayer == player2){
				System.out.println("Congratulations, " + player2.getName() + " you win!");
				wonGame(player2, player1);
				betweenGames = true;

			}
			else if (turns >= 9){									//checks for tie
				System.out.println("It's a tie!");
				betweenGames = true;
			}

			if (betweenGames == true){								//checks if game just ended
				betweenGames = false;
				System.out.println("Player 1 wins: " + player1.getWins() + "\nPlayer 2 wins: " + player2.getWins());
				System.out.println("Play again? 1 for yes and 0 for no.");
				int response = scan.nextInt();

				if (response == 1){
					board = new TicTacToe();
					turns = 0;
					System.out.println(board);
				}
				else{
					playing = false;
				}
			}

		}
	}
	public static void changeTile(Player currentPlayer, TicTacToe board){
		System.out.println("Please choose a row (0, 1, or 2)");
		int row = scan.nextInt();
		System.out.println("Please choose a column (0, 1, or 2)");
		int column = scan.nextInt();
		while (board.isLegal(row, column) == false){
			System.out.println("Illegal move!");
			System.out.println("Please choose a row (0, 1, or 2)");
			row = scan.nextInt();
			System.out.println("Please choose a column (0, 1, or 2)");
			column = scan.nextInt();
		}
		board.setTile(row, column, currentPlayer.getSymbol());
	}
	
	
	public static void wonGame(Player winner, Player loser){
		winner.incrementWins();
		loser.incrementLosses();
	}
}


