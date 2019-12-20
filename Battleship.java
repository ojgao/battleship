import java.util.*;

public class Battleship{
	public static void main(String[] args) {
		ComputerBoard cb = new ComputerBoard();
		PlayerBoard pb = new PlayerBoard();
		Computer c = new Computer(pb);
		Player p = new Player(cb);
		System.out.println("Let's see who goes first...");
		Random r =  new Random();
		int res = r.nextInt(2);
		if(res == 0) {
			System.out.println("The computer will go first!");
			c.makeGuess();
			pause(2000);
			p.makeGuess();
			pause(1000);
		} else {
			System.out.println("You go first!");
			System.out.println();
			p.makeGuess();
			pause(1000);
			c.makeGuess();
			pause(2000);
		}
		while(!p.isWinner() && !c.isWinner()) {
			if(res == 0) {
				c.makeGuess();
				pause(2000);
				p.makeGuess();
				pause(1000);
			} else {
				p.makeGuess();
				pause(1000);
				c.makeGuess();
				pause(2000);
			}
		}
		pb.printBoard();
		if (p.isWinner()){
			System.out.println("Congratulations! You Win!");
		} else {
			System.out.println("Sorry. You Lose.");
		}
	}

	public static void pause(int ms) {
		try
		{
		    Thread.sleep(ms);
		}
		catch(InterruptedException ex)
		{
		    Thread.currentThread().interrupt();
		}
	}
}
