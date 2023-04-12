public class ExtraTask2 {
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
