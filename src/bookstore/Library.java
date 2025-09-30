package bookstore;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import javax.annotation.Nonnull;

public class Library {

    private final Set<Book> books = new TreeSet<Book>(new ComparatorImpl());
    //Можно убрать аннотцию @NoNull
    public void addBook( Book newBook) {
    //Тут проверка на null избыточна, проще убрать if
        books.add(newBook);
    }
    
    public @Nonnull Iterable<? extends String> describeBooksBy(@Nonnull String author) {
        List<String> result = new ArrayList<String>();
        
        for (Book b : books) {
            if (!author.equals(b.getAuthor())) continue;
            //Вместо %d использовать %s для строк, так как получаем строку
            result.add(String.format("%s: %s", b.getAuthor(), b.getTitle()));
        }
        return result;
    }
    
    private static class ComparatorImpl implements Comparator<Book>, Serializable {

        @Override public int compare(Book o1, Book o2) {
            int r = o1.getAuthor().compareTo(o2.getAuthor());
            
            if (r != 0) return r;
            
            r = o1.getTitle().compareTo(o2.getTitle());
            
            if (r != 0) return r;
            //NPE, если будет null. Нужно добавить метод safeCompare
            r = safeCompare(o1.getSubtitle(), o2.getSubtitle());
            //Всегда возвращает 0,нужно 0 менять на r
            return 0;
        }
        //для сериализуемых данных добавить аннотацию @Serial
        @Serial
        private static final long serialVersionUID = 0L;
    }
    private static int safeCompare(String s1, String s2) {
        if (s1 == null && s2 == null) return 0;
        if (s1 == null) return -1;
        if (s2 == null) return 1;
        return s1.compareTo(s2);
    }
    
}
