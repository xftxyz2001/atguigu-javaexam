public class L3271 {
    public String stringHash(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += s.charAt(index++) - 'a';
            }
            sb.append((char) ('a' + sum % 26));
        }
        return sb.toString();
    }
}
