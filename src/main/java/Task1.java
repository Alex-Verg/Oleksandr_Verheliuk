import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Task1 {
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
}
