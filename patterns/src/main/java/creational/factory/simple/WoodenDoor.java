package creational.factory.simple;

class WoodenDoor implements Door {

    protected final Integer width;
    protected final Integer height;

    WoodenDoor (Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public Integer getWidth () {
        return this.width;
    }

    @Override
    public Integer getHeight () {
        return this.height;
    }

    @Override
    public String toString () {
        return "WoodenDoor{" +
                "width=" + width +
                ", height=" + height +
                '}';
    }
}
