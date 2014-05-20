import java.io.IOException;


public class Main {

	
	public static void main(String[] args) throws IOException {
		BoardDisplay displayer = new BoardDisplay();
		displayer.place("chessinput.txt");
		displayer.move("chessinput.txt");
		displayer.displayBoard();
		
	}

}
