import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
    }

    public static void example1(String[] args) {
        //Пример 1
        boolean flag=false;
        Number n = flag ? new Integer(1) : new Double(2.0);
    }

    public static void example2(String[] args) {
        //Пример 2
        boolean flag=false;
        Integer n = flag ? 1 : null;
    }

    //Пример 3
    double[] vals = new double[] {1.0, 2.0, 3.0};
    double getVal(int idx) {
        return (idx < 0 || idx >= vals.length) ? null : vals[idx];
    }
    //Пример 4
    public String getDate() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public static void example5(String[] args) {
        //Пример 5
        System.out.println(new BigDecimal(1.1));
    }

    public static void example6(String[] args) {
        //Пример 6
        BigDecimal d1 = new BigDecimal("1.1");
        BigDecimal d2 = new BigDecimal("1.10");
        System.out.println(d1.equals(d2));
    }

    public static void example7(String[] args) {
        //Пример 7
        System.out.printf("%s\n", "str#1");
        System.out.println("str#2");
    }
}
