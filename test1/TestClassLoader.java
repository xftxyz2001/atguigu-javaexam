public class TestClassLoader {
    public static void main(String[] args) {
        ClassLoader app = TestClassLoader.class.getClassLoader();
        System.out.println(app);
        ClassLoader ext = app.getParent();
        System.out.println(ext);
        ClassLoader boot = ext.getParent();
        System.out.println(boot);
    }
}
