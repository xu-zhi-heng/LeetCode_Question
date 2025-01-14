package Test;

import java.util.List;

public interface AnimalService<T> {
    boolean isSupport(String type);
    boolean bathInsert(List<T> list);
}
