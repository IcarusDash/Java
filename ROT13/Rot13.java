import java.util.function.*;


public class Rot13 {
	private static char translate(char c) {
		char startChar = Character.isUpperCase(c) ? 'A' : 'a';
		int offset = (c - startChar + 13) % 26;
		return (char)(startChar + offset);
	}
	
	public static String cipher(String text) {
		StringBuilder textBuilder = new StringBuilder();
		
		for (int i = 0, size = text.length(); i < size; ++i) {
			char c = text.charAt(i);
			textBuilder.append(Character.isAlphabetic(c) ? translate(c) : c);
		}
		
		return textBuilder.toString();
	}
}
