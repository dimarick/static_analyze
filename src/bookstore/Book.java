package bookstore;

import javax.annotation.CheckForNull;
import javax.annotation.Nonnull;

public class Book {
    //Нужно инициализировать поля
    private @Nonnull String author="";
    //Нужно инициализировать поля
    private @Nonnull String title="";
    private @CheckForNull String subtitle;

    public @Nonnull String getAuthor() {
        return author;
    }

    //Метод вернет NPE, если переменная будет null.
    // Для решения проблемы нужно пометить так же как и переменную
    //То есть вместо @Nonull @CheckForNull
    public @CheckForNull String getSubtitle() {
        return subtitle;
    }

    public @Nonnull String getTitle() {
        return title;
    }

}
