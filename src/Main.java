import java.util.HashMap;
import java.util.Map;

import static funny.Compression.betterCompression;

public class Main {
    public static void main(String[] args) {
        String string = betterCompression("a12b56c1");
        System.out.println(string);
    }
}