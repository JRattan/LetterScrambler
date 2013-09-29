package letterscrambler;

public class LetterScrambler {
	
	public static String Scramble(String text, String key){
		// If either the text or the key to use is empty, simply return text
		if(text.isEmpty() || key.isEmpty())
			return text;
		
		char[] scrambled = new char[text.length()];
		for(int i = 0; i < text.length(); i++)
		{
			char current_char = text.charAt(i);
			// Check if char is a letter or number
			if (Character.isLetter(current_char) || Character.isDigit(current_char)) 
			{
				int pos = (i + key.charAt(i % key.length())) % text.length();
				pos = CheckArrayEmptyPos(scrambled, pos);
				
				if(Character.isUpperCase(current_char) && Character.isLowerCase(text.charAt(pos)))
					current_char = Character.toLowerCase(current_char);
				if(Character.isLowerCase(current_char) && Character.isUpperCase(text.charAt(pos)))
					current_char = Character.toUpperCase(current_char);
				scrambled[pos] = current_char;
			}
			// If char is neither a letter or number, place it in its current position
			// If there's a char already present, that char gets moved to a new location
			else
			{
				int pos = i;
				if (scrambled[pos] != '\u0000')
				{
					char temp_char = scrambled[pos];
					int temp_pos = CheckArrayEmptyPos(scrambled, (pos + 1) % text.length());
					scrambled[temp_pos] = temp_char;
				}
				scrambled[pos] = current_char;
			}
		}
		
		return new String(scrambled);
	}
	
	// Looks for an empty element in the array. NULL '\u0000' in char arrays
	// Keeps incrementing until it finds it
	// If it reaches the same position, returns a -9999 (should be changed to throw exception instead)
	// Returns the first position where a NULL element is found
	public static int CheckArrayEmptyPos(char[] array, int pos) {
		int current_pos = pos;
		while(array[current_pos] != '\u0000') {
			current_pos = (current_pos + 1) % array.length;
			if (current_pos == pos) return -9999;
		}
		return current_pos;
	}

}
