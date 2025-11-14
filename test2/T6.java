public class T6 {
    public static void main(String[] args) {

        String str = "aabcccccaaa";

        StringBuilder sb = new StringBuilder();
        char lastChar = str.charAt(0);
        int cnt = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == lastChar) {
                cnt++;
            } else {
                sb.append(lastChar);
                sb.append(cnt);
                lastChar = str.charAt(i);
                cnt = 1;
            }
        }
        sb.append(lastChar);
        sb.append(cnt);
        System.out.println(sb.length() < str.length() ? sb.toString() : str);
    }
}
