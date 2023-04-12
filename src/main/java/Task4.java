import java.util.stream.IntStream;

public class Task4 {
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
}
