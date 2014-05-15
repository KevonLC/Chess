import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		inputReader ir = new inputReader();
		if(args.length == 0)
		{			
			System.out.println("Please input a file");
			System.exit(0);
		}
		else
		{
			ir.readFile(args [0]);
		}
		
	}

}
