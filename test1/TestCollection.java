import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import java.util.Vector;

class Hash0 {

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

}

public class TestCollection {
    public static void main(String[] args) {
        HashMap<Hash0, Integer> map = new HashMap<>();
        map.put(new Hash0(), null);
        map.put(new Hash0(), null);
        map.put(new Hash0(), null);
        map.put(new Hash0(), null);
        map.put(new Hash0(), null);
        map.put(new Hash0(), null);
        map.put(new Hash0(), null);
        map.put(new Hash0(), null);
        map.put(new Hash0(), null);
    }
}
