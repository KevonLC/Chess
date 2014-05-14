import java.io.IOException;


public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		FileRead fr = new FileRead();
		fr.readFile(args [0]);
	}

}
