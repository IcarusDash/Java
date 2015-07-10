
public class Rot13Main {
	public static void main(String[] args) {
		if (args.length > 0)
			System.out.println( Rot13.cipher( String.join(" ", args) ) );
		else 
			new Rot13GUI().setVisible(true);
	}      
}
