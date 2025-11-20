public class L3228 {
    public static void main(String[] args) {
        new L3228().maxOperations("110");
    }

    public int maxOperations(String s) {
        char[] charArray = s.toCharArray();
        int cnt = 0;
        for (int i = 0; i < charArray.length - 1; i++) {
            if (charArray[i] == '1' && charArray[i + 1] == '0') {
                cnt++;
                charArray[i] = '0';
                for (int j = i + 1; j < charArray.length; j++) {
                    if (j == charArray.length - 1 || charArray[j + 1] == '1') {
                        charArray[j] = '1';
                        break;
                    }
                }
                if (i > 0) {
                    i -= 2;
                }
            }
        }
        return cnt;
    }
}
