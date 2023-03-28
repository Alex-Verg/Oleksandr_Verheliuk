import java.util.*;
import java.util.stream.IntStream;

public class Tasks {
    public static List<Integer> getIntegersFromList(List<?> inputList) {
        List<Integer> resultList = new ArrayList<Integer>();
        if(inputList == null) {
            return Collections.emptyList();
        }
        for (Object o : inputList) {
            if (o instanceof Integer) {
                resultList.add((Integer) o);
            }
        }
        return resultList;
    }

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

    public static Integer digitalRoot(int n){
        int m;
        while (n > 9) {
            m = n;
            n = 0;
            while (m > 0) {
                n += m % 10;
                m = m / 10;
            }
        }
        return n;
    }

    public static long countPairsFor(int[] inputArr, int target){
        if (inputArr == null || inputArr.length < 2) {
            return 0;
        }
        int pairs = 0;
        for (int i=0; i < inputArr.length; i++){
            for (int j=i+1; j < inputArr.length; j++)
                if(inputArr[i] + inputArr[j] == target) {
                    pairs += 1;
                }
        }
        return pairs;
    }

    public static long countPairsStream(int[] inputArr, int target){
        if (inputArr == null || inputArr.length < 2) {
            return 0;
        }
        return IntStream.range(0, inputArr.length).flatMap(i -> IntStream.range(i+1, inputArr.length).filter(j -> inputArr[i] + inputArr[j] == target)).count();
    }

    public static String meeting(String inputStr){
        if (inputStr == null || inputStr.length() == 0) {
            return "";
        }
        inputStr = inputStr.toUpperCase();
        String[] guests = inputStr.split(";");
        String outputStr = "";
        for (int i=0; i< guests.length; i++) {
            String[] names = guests[i].split(":");
            guests[i] = "(" + names[1] + ", " + names[0] +")";
        }
        Arrays.sort(guests);
        outputStr = String.join("", guests);
        return outputStr;
    }

    public static String getIp(long num) {
        String ipString = "";
        long m;
        for(int i = 0; i < 3; i++) {
            m = num % 256;
            num = num / 256;
            ipString = "." + Long.toString(m) + ipString;
        }
        return ipString = Long.toString(num) + ipString;
    }
}
