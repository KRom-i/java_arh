package creational.prototype;

public class Sheep implements Cloneable {

    private String name;
    private String category;

    public Sheep (String name, String category) {
        this.name = name;
        this.category = category;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getCategory () {
        return category;
    }

    public void setCategory (String category) {
        this.category = category;
    }

    @Override
    public String toString () {
        return "Sheep{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public Sheep clone () throws CloneNotSupportedException {
        return (Sheep) super.clone ();
    }
}
