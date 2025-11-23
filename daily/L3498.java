public class L3498 {
    public static void main(String[] args) {
        new L3498().reverseDegree("abc");
    }
    
    public int reverseDegree(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res += (26 - (s.charAt(i) - 'a')) * (i + 1);
        }
        return res;
    }
}
