import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class L3541 {

    public int maxFreqSum(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chi = s.charAt(i);
            hash.put(chi, hash.getOrDefault(chi, 0) + 1);
        }
        int maxAEIOU = 0;
        int maxOther = 0;
        for (Entry<Character, Integer> entry : hash.entrySet()) {
            Character key = entry.getKey();
            if (key == 'a' || key == 'e' || key == 'i' || key == 'o' || key == 'u') {
                maxAEIOU = Math.max(maxAEIOU, entry.getValue());
            } else {
                maxOther = Math.max(maxOther, entry.getValue());
            }
        }
        return maxAEIOU + maxOther;
    }
}