import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Пример 1
        boolean flag=false;
        Number n = flag ? new Integer(1) : new Double(2.0);
        //Пример 2
        Integer n = flag ? 1 : null;
        //Пример 3
        double[] vals = new double[] {1.0, 2.0, 3.0};
        double getVal(int idx) {
            return (idx < 0 || idx >= vals.length) ? null : vals[idx];
        }
        //Пример 4
        public String getDate() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        }
        //Пример 5
        System.out.println(new BigDecimal(1.1));
        //Пример 6
        BigDecimal d1 = new BigDecimal("1.1");
        BigDecimal d2 = new BigDecimal("1.10");
        System.out.println(d1.equals(d2));
        //Пример 7
        System.out.printf("%s\n", "str#1");
        System.out.println("str#2");
    }
}
