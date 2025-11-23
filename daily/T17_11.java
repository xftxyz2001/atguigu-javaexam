public class T17_11 {
    public int findClosest(String[] words, String word1, String word2) {
        int minDist = Integer.MAX_VALUE;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                index1 = i;
                if (index2 != -1) {
                    minDist = Math.min(minDist, index1 - index2);
                }
            } else if (words[i].equals(word2)) {
                index2 = i;
                if (index1 != -1) {
                    minDist = Math.min(minDist, index2 - index1);
                }
            }
        }
        return minDist;
    }
}
