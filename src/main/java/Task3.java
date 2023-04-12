import java.util.LinkedHashMap;
import java.util.Map;

public class Task3 {
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
}
