import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class inputReader {
	
	
	public void readFile(String file) throws IOException
	{
		String color;
		//syntax for named capture groups
		//(?<piece>\w\d)\\s(?<second>\w\w\d)
		//Consider limiting digit catch to 1-8
		Pattern place = Pattern.compile("^[KQBNRP][dl][abcdefgh][1-8]$");
		Pattern move1 = Pattern.compile("^[abcdefgh][1-8] [abcdefgh][1-8]$");
		Pattern capture = Pattern.compile("^[abcdefgh][1-8] [abcdefgh][1-8]\\*$");
		Pattern move2 = Pattern.compile("^[abcdefgh][1-8] [abcdefgh][1-8] [abcdefgh][1-8] [abcdefgh][1-8]$");
		Matcher placer = place.matcher("");
		Matcher mover1 = move1.matcher("");
		Matcher mover2 = move2.matcher("");
		Matcher capturer = capture.matcher("");
		
		BufferedReader br = new BufferedReader(new FileReader(file));
		LineNumberReader lineReader = new LineNumberReader(br);
		String line = null;
		
		while((line = lineReader.readLine()) != null)
		{
			placer.reset(line);
			mover1.reset(line);
			mover2.reset(line);
			capturer.reset(line);
			if(placer.find())
			{
				color = (line.charAt(1) == 'd') ? "Black" : "White";
				
				switch (line.charAt(0)) {

				case 'Q':

					line = color + " Queen placed at " + line.charAt(2)
							+ line.charAt(3);
					break;
				case 'K':

					line = color + " King placed at " + line.charAt(2)
							+ line.charAt(3);
					break;
				case 'B':

					line = color + " Bishop placed at " + line.charAt(2)
							+ line.charAt(3);
					break;
				case 'N':

					line = color + " Knight placed at " + line.charAt(2)
							+ line.charAt(3);
					break;
				case 'R':

					line = color + " Rook placed at " + line.charAt(2)
							+ line.charAt(3);
					break;
				case 'P':

					line = color + " Pawn placed at " + line.charAt(2)
							+ line.charAt(3);
					break;
				}
				
				System.out.println(line);
			}
			
			if(mover1.find() || capturer.find())
			{
				if(line.contains("*"))
				{
					line = "Move piece from " + line.charAt(0) + line.charAt(1) + " and capture piece at " + line.charAt(3) + line.charAt(4);
				}
				else
				{
					line = "Move piece from " + line.charAt(0) + line.charAt(1) + " to " + line.charAt(3) + line.charAt(4);
				}				
				System.out.println(line);
			}
			
			if(mover2.find())
			{
				line = "Move piece from " + line.charAt(0) + line.charAt(1) + " to " + line.charAt(3) + line.charAt(4) + ", then move piece from " + line.charAt(6) + line.charAt(7) + " to " + line.charAt(9) + line.charAt(10);
				System.out.println(line);
			}
		}
		lineReader.close();
	}
}
