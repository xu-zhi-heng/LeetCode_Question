package Test;

import java.util.List;

public class AnimalCatServiceImpl implements AnimalService<Animal> {

    @Override
    public boolean isSupport(String type) {
        return type.equals("1");
    }

    @Override
    public boolean bathInsert(List<Animal> list) {
        for (int i = 0; i < list.size(); i++) {
            Cat cat = (Cat)list.get(i);
            System.out.println(cat.getCatName());
        }
        return false;
    }
}
