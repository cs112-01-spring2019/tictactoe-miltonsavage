/*
 * TicTacToe class
 * @Milton Savage 
 */
public class TicTacToe
{
	//INSTANCE DATA
	private char[][] board;
	private final char PLAYER1 = 'X';
	private final char PLAYER2 = 'O';
	private final char EMPTY_CELL = '-';

	//CONSTRUCTOR
	public TicTacToe()
	{
		board = new char[3][3];
		for (int i = 0; i < 3; i++){
			for (int j = 0; j < 3; j++){
				board[i][j] = '-';
			}
		}
	}

	//METHODS

	public char[][] getBoard(){
		return board;
	}
	public void setBoard(char[][] inp){
		board = inp;
	}

	public void setTile(int x, int y, char player){
		board[x][y] = player;
	}

	public char getTile(int x, int y){
		return board[x][y];
	}
	public String rowToString(int x){
		String output = "";
		for (int i = 0; i < 3; i++){

			output += "["+board[x][i]+"]";}
		output += "\n";
		return output;
	}

	public boolean isLegal(int x, int y){
		if (getTile(x,y) == '-'){
			return true;
		}
		else {
			return false;
		}
	}

	public String toString()
	{
	   	String output;
		output  = rowToString(0) + rowToString(1) + rowToString(2);
		return output;
	}

	public Player winner(Player player1, Player player2){
		if ((getTile(0,0) == 'X' && getTile(1,0) == 'X' && getTile(2,0) == 'X') || (getTile(0,1) == 'X' && getTile(1,1) == 'X' && getTile(2,1) == 'X') || 
			(getTile(0,2) == 'X' && getTile(1,2) == 'X' && getTile(2,2) == 'X') || (getTile(0,0) == 'X' && getTile(0,1) == 'X' && getTile(0,2) == 'X') || 
			(getTile(1,0) == 'X' && getTile(1,1) == 'X' && getTile(1,2) == 'X') || (getTile(2,0) == 'X' && getTile(2,1) == 'X' && getTile(2,2) == 'X') || 
			(getTile(0,0) == 'X' && getTile(1,1) == 'X' && getTile(2,2) == 'X') || (getTile(0,2) == 'X' && getTile(1,1) == 'X' && getTile(2,0) == 'X')) {
			return player1;}
		else if ((getTile(0,0) == 'O' && getTile(1,0) == 'O' && getTile(2,0) == 'O') || (getTile(0,1) == 'O' && getTile(1,1) == 'O' && getTile(2,1) == 'O') || 
			(getTile(0,2) == 'O' && getTile(1,2) == 'O' && getTile(2,2) == 'O') || (getTile(0,0) == 'O' && getTile(0,1) == 'O' && getTile(0,2) == 'O') || 
			(getTile(1,0) == 'O' && getTile(1,1) == 'O' && getTile(1,2) == 'O') || (getTile(2,0) == 'O' && getTile(2,1) == 'O' && getTile(2,2) == 'O') || 
			(getTile(0,0) == 'O' && getTile(1,1) == 'O' && getTile(2,2) == 'O') || (getTile(0,2) == 'O' && getTile(1,1) == 'O' && getTile(2,0) == 'O')) {
			return player2;
		}
		else return null;}
}
