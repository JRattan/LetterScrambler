package letterscrambler;

public class Testmain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String text = "This is a text! This should scramble these few letters. including 123 numbers 1 and 2!";
		String key = "hello world!";
		
		System.out.println(LetterScrambler.Scramble(text, key));

	}

}
