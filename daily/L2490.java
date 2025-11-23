public class L2490 {
    public boolean isCircularSentence(String sentence) {
        String[] words = sentence.split(" ");
        return isCircularSentence(words);
    }

    private boolean isCircularSentence(String[] words) {
        for (int i = 0; i < words.length; i++) {
            char thisLast = words[i].charAt(words[i].length() - 1);
            char nextFirst = words[(i + 1) % words.length].charAt(0);
            if (thisLast != nextFirst) {
                return false;
            }
        }
        return true;
    }
}
