package Test;

import java.util.List;

public class AnimalDogServiceImpl implements AnimalService<Animal>{

    @Override
    public boolean isSupport(String type) {
        return type.equals("0");
    }

    @Override
    public boolean bathInsert(List<Animal> list) {
        for (int i = 0; i < list.size(); i++) {
            Dog dog = (Dog)list.get(i);
            System.out.println(dog.getDogName());
        }
        return false;
    }
}
