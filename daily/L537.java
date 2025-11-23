public class L537 {
    public String complexNumberMultiply(String num1, String num2) {
        ComplexNumber c1 = new ComplexNumber(num1);
        ComplexNumber c2 = new ComplexNumber(num2);
        return c1.multiply(c2).toString();
    }
}

class ComplexNumber {
    private long a, b; // a + bi

    public ComplexNumber(String s) {
        int i = s.indexOf('+');
        a = Long.parseLong(s.substring(0, i));
        b = Long.parseLong(s.substring(i + 1, s.length() - 1));
    }

    public ComplexNumber(long a, long b) {
        this.a = a;
        this.b = b;
    }

    public ComplexNumber multiply(ComplexNumber c) {
        long a1 = a * c.a - b * c.b;
        long b1 = a * c.b + b * c.a;
        return new ComplexNumber(a1, b1);
    }

    public String toString() {
        return a + "+" + b + "i";
    }

}