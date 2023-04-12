import java.util.LinkedHashMap;
import java.util.Map;

public class Task2 {
    public static Character firstNonRepeatingLetter(String inputStr) {
        if(inputStr == null) {
            return ' ';
        }

        String lowerString = inputStr.toLowerCase();
        Map<Character, Integer> charRepeats = new LinkedHashMap<>();
        for (int i = 0; i < lowerString.length(); i++){
            char curChar = lowerString.charAt(i);
            int repeats = charRepeats.containsKey(curChar) ? charRepeats.get(curChar) : 0;
            charRepeats.put(curChar, repeats += 1);
        }

        for (int i = 0; i < inputStr.length(); i++){
            char curChar = inputStr.charAt(i);
            if (charRepeats.get(lowerString.charAt(i)) == 1) {
                return curChar;
            }
        }


        return ' ';
    }
}
