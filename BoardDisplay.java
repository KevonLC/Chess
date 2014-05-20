import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class BoardDisplay {
	int length = 8;
	int height = 8;
	int movement1;
	int place1;
	int movement2;
	int place2;
	char piece;
	char[][] board = new char[length][height];
	
	public void displayBoard()
	{
		for (int row = 0; row < length; row++)
		{	
			for (int col = 0; col < height; col++){
				if(board[row][col] != '\u0000')
				{
					System.out.print("  " + board[row][col]);
				}				
				else
				{
					System.out.print("  -");
				}
			}
			System.out.println();
		}
	}
	
	public void place(String file) throws IOException
	{
		Pattern place = Pattern.compile("^[KQBNRP][dl][abcdefgh][1-8]$");
		Matcher placer = place.matcher("");
		
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		LineNumberReader lineReader = new LineNumberReader(reader);
		String line = null;
		
		while((line = lineReader.readLine()) != null)
		{
			
			placer.reset(line);
			if(placer.find())
			{				
				piece = (line.charAt(1) == 'd') ? line.charAt(0) : Character.toLowerCase(line.charAt(0));
							
				switch (line.charAt(2)) {

				case 'a':

					movement1 = 1;
					break;
				case 'b':

					movement1 = 2;
					break;
				case 'c':

					movement1 = 3;
					break;
				case 'd':

					movement1 = 4;
					break;
				case 'e':

					movement1 = 5;
					break;
				case 'f':

					movement1 = 6;
					break;
				case 'g':

					movement1 = 7;
					break;
				case 'h':

					movement1 = 8;
					break;
				}
				
				
				board[movement1 - 1][Character.getNumericValue(line.charAt(3)) - 1] = piece;				
			}
		}
		lineReader.close();
	}
	
	public void move(String file) throws IOException
	{
		Pattern move1 = Pattern.compile("^[abcdefgh][1-8] [abcdefgh][1-8]$");
		Pattern capture = Pattern.compile("^[abcdefgh][1-8] [abcdefgh][1-8]\\*$");
		Pattern move2 = Pattern.compile("^[abcdefgh][1-8] [abcdefgh][1-8] [abcdefgh][1-8] [abcdefgh][1-8]$");
		Matcher mover1 = move1.matcher("");
		Matcher mover2 = move2.matcher("");
		Matcher capturer = capture.matcher("");
		
		BufferedReader reader2 = new BufferedReader(new FileReader(file));
		LineNumberReader lineReader = new LineNumberReader(reader2);
		String line = null;
		
		while((line = lineReader.readLine()) != null)
		{
			
			mover1.reset(line);
			mover2.reset(line);
			capturer.reset(line);			
			
			if(mover1.find() || capturer.find())
			{
				switch (line.charAt(0)) {

				case 'a':

					movement1 = 1;
					break;
				case 'b':

					movement1 = 2;
					break;
				case 'c':

					movement1 = 3;
					break;
				case 'd':

					movement1 = 4;
					break;
				case 'e':

					movement1 = 5;
					break;
				case 'f':

					movement1 = 6;
					break;
				case 'g':

					movement1 = 7;
					break;
				case 'h':

					movement1 = 8;
					break;
				}
				
				switch (line.charAt(3)) {

				case 'a':

					place1 = 1;
					break;
				case 'b':

					place1 = 2;
					break;
				case 'c':

					place1 = 3;
					break;
				case 'd':

					place1 = 4;
					break;
				case 'e':

					place1 = 5;
					break;
				case 'f':

					place1 = 6;
					break;
				case 'g':

					place1 = 7;
					break;
				case 'h':

					place1 = 8;
					break;
				}
				
				board[place1 - 1][Character.getNumericValue(line.charAt(4)) - 1] = board[movement1 - 1][Character.getNumericValue(line.charAt(1)) - 1];
				board[movement1 - 1][Character.getNumericValue(line.charAt(1)) - 1] = '\u0000';
			}
			
			if(mover2.find())
			{
				switch (line.charAt(0)) {

				case 'a':

					movement1 = 1;
					break;
				case 'b':

					movement1 = 2;
					break;
				case 'c':

					movement1 = 3;
					break;
				case 'd':

					movement1 = 4;
					break;
				case 'e':

					movement1 = 5;
					break;
				case 'f':

					movement1 = 6;
					break;
				case 'g':

					movement1 = 7;
					break;
				case 'h':

					movement1 = 8;
					break;
				}
				
				switch (line.charAt(3)) {

				case 'a':

					place1 = 1;
					break;
				case 'b':

					place1 = 2;
					break;
				case 'c':

					place1 = 3;
					break;
				case 'd':

					place1 = 4;
					break;
				case 'e':

					place1 = 5;
					break;
				case 'f':

					place1 = 6;
					break;
				case 'g':

					place1 = 7;
					break;
				case 'h':

					place1 = 8;
					break;
				}
				switch (line.charAt(6)) {

				case 'a':

					movement2 = 1;
					break;
				case 'b':

					movement2 = 2;
					break;
				case 'c':

					movement2 = 3;
					break;
				case 'd':

					movement2 = 4;
					break;
				case 'e':

					movement2 = 5;
					break;
				case 'f':

					movement2 = 6;
					break;
				case 'g':

					movement2 = 7;
					break;
				case 'h':

					movement2 = 8;
					break;
				}
				
				switch (line.charAt(9)) {

				case 'a':

					place2 = 1;
					break;
				case 'b':

					place2 = 2;
					break;
				case 'c':

					place2 = 3;
					break;
				case 'd':

					place2 = 4;
					break;
				case 'e':

					place2 = 5;
					break;
				case 'f':

					place2 = 6;
					break;
				case 'g':

					place2 = 7;
					break;
				case 'h':

					place2 = 8;
					break;
				}
				board[place1 - 1][Character.getNumericValue(line.charAt(4)) - 1] = board[movement1 - 1][Character.getNumericValue(line.charAt(1)) - 1];
				board[movement1 - 1][Character.getNumericValue(line.charAt(1)) - 1] = '\u0000';
				board[place2 - 1][Character.getNumericValue(line.charAt(10)) - 1] = board[movement2 - 1][Character.getNumericValue(line.charAt(7)) - 1];
				board[movement2 - 1][Character.getNumericValue(line.charAt(7)) - 1] = '\u0000';
			}
		}
		lineReader.close();
	}
}
