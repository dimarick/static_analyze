package static_analyze;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        //Тернарный оператор ?:, который должен возвращать один тип данных
        boolean flag = true;
        Number n = flag ? new Integer(1) : new Double(2.0);
        System.out.println(n.getClass());
        //Для решения проблемы можно использовать автоупаковку
        Number i = flag ? 1 : 2.0;
        System.out.println(i);
        //NPE, если работать со значением null
        Integer a = flag ? 1 : null;
        int value = a;
        System.out.println(value);
        //Для решения NPE можно вместо null взять 0
        Integer b = flag ? 1 : 0;
        int valu = b;
        System.out.println(valu);
        example();
        //DateFormat ошибка в использовании одного объекта format на всех. В многопоточной серде каждый из потоков будет добавлять свои данные, что приведет к ошибке
        private static final DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        public String getDate () {
            return format.format(new Date());
        }
        //Решением может служить создание нового объекта потока
        public String getDate () {
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            return format.format(new Date());
        }
        //BigDecimal, в котором из double создается BigDecimal
        System.out.println(new BigDecimal(1.1));
        //Для решения проблемы вывода можно использовать строковое представление числа
        System.out.println(new BigDecimal("1.1"));
        //неправильное сравнение с помощью логического сравнения equals()
        BigDecimal d1 = new BigDecimal("1.1");
        BigDecimal d2 = new BigDecimal("1.10");
        System.out.println(d1.equals(d2));
        //Для сравнения чисел с разным количеством знаков после запятой можно использовать математическое сравнение compareTo()
        BigDecimal d3 = new BigDecimal("1.1");
        BigDecimal d4 = new BigDecimal("1.10");
        System.out.println(d3.compareTo(d4) == 0);
        //Переводы строк и printf, слишком сложно для вывода с малым коилчеством аргументов. Для парсеров может быть затруднительным
        System.out.printf("%s\n", "str#1");
        System.out.println("str#2");
        //для решения пробелмы нужно использовать println, если вывод состоит из простых аргментов
        System.out.println("str#1");
        System.out.println("str#2");
    }

    public static double example() {
        //NPE, если работать со значением null
        double[] vals = new double[]{1.0, 2.0, 3.0};
        double getVal ( int idx){
            return (idx < 0 || idx >= vals.length) ? null : vals[idx];

            //Для решения проблемы можно использовать Double вместо double
            double[] val = new double[]{1.0, 2.0, 3.0};
            Double getV ( int id){  // Double вместо double
                return (id < 0 || id >= val.length) ? null : val[id];
            }
        }
    }
}

