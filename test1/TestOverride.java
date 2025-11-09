import java.util.ArrayList;
import java.util.List;

public class TestOverride {

    public static void main(String[] args) {
        
    }
}

class C1 {
    protected List<String> getData() {
        return List.of("AAA","BBB");
    }
}

class C2 extends C1{
    @Override
    public ArrayList<String> getData() {
        return new ArrayList<>();
    }
    
}