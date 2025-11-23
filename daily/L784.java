import java.util.ArrayList;
import java.util.List;

public class L784 {

    public static void main(String[] args) {
        System.out.println(new L784().letterCasePermutation("a1b2"));
    }
    
    

    List<String> ans;;

    public List<String> letterCasePermutation(String s) {
        this.ans = new ArrayList<>();
        letterCasePermutation(s.toCharArray(), 0);
        return ans;
    }

    private void letterCasePermutation(char[] charArray, int begin) {
        ans.add(new String(charArray));

        for (int i = begin; i < charArray.length; i++) {
            if (!Character.isLetter(charArray[i])) {
                continue;
            }
            if (Character.isUpperCase(charArray[i])) {
                charArray[i] = Character.toLowerCase(charArray[i]);
            } else {
                charArray[i] = Character.toUpperCase(charArray[i]);
            }
            letterCasePermutation(charArray, i + 1);
            charArray[i] = Character.isUpperCase(charArray[i]) ? Character.toLowerCase(charArray[i])
                    : Character.toUpperCase(charArray[i]);
        }

    }
}
