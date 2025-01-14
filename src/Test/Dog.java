package Test;

public class Dog extends Animal{
    public Dog(Integer id, String dogName) {
        this.id = id;
        this.dogName = dogName;
    }

    private Integer id;
    private String dogName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "id=" + id +
                ", dogName='" + dogName + '\'' +
                '}';
    }
}
