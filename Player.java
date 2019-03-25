/*
 *
 * @Milton Savage
 */
public class Player {
	private String name;
	private int wins;
	private int losses;
	private char symbol;
	// INSTANCE DATA: name, wins, losses

	//CONSTRUCTOR
	public Player(String playerName, char playerSymbol)
	{
		name = playerName;
		wins = 0;
		losses = 0;
		symbol = playerSymbol;
	}

	// METHODS
	// getName(), setName(), getWins(), getLosses(), toString(), etc
	public String getName()
	{
		return name;
	}

	public void setName(String inp){
		name = inp;
	}

	public int getWins(){
		return wins;
	}

	public void incrementWins(){
		wins ++;
	}

	public void incrementLosses(){
		losses ++;
	}

	public void setWins(int inp){
		wins = inp;
	}

	public int getLosses(){
		return losses;
	}

	public void setLosses(int inp){
		losses = inp;
	}

	public char getSymbol(){
		return symbol;
	}

	public void setSymbol(char inp){
		symbol = inp;
	}

	public String toString()
	{
		return "Name: " + this.getName() + " Wins: " + this.getWins() + " Losses: " + this.getLosses();
	}

}
