import java.util.StringJoiner;

public class L3280 {
    public String convertDateToBinary(String date) {
        String[] ymd = date.split("-");
        StringJoiner sj = new StringJoiner("-");
        for (String it : ymd) {
            sj.add(Integer.toBinaryString(Integer.parseInt(it)));
        }
        return sj.toString();
    }
}
