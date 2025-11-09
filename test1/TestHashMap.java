import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class TestHashMap {

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("k", 0);

        ConcurrentHashMap<String, Integer> chm = new ConcurrentHashMap<>();
        chm.put("k", 0);
    }
}