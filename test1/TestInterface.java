public class TestInterface implements I1{
    public static void main(String[] args) {
    }
}

interface I1 {
    int a = 1;

    default int m0() {
        return 0;
    }

}

