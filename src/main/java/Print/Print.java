package Print;

public class Print {
    static void P(Object x) {
        System.out.println(x);
    }

    static void P(char[] x) {
        System.out.println(new String(x));
    }

    protected static void print(Object x) {
        System.out.println(x);
    }

    static void print() {
        System.out.println();
    }

    static void print(char[] x) {
        System.out.println(new String(x));
    }
}
