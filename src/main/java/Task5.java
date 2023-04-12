import java.util.Arrays;

public class Task5 {
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
}
