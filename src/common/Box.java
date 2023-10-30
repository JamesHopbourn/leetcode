package common;


public class Box {
    private int height;
    private int width;
    private int length;

    public Box() {
    }

    private Box(Box box) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    public Box builder(){
        return this;
    }
    public Box build() {
        return new Box(this);
    }

    public Box setHeight(int height) {
        this.height = height;
        return this;
    }

    public Box setWidth(int width) {
        this.width = width;
        return this;
    }

    public Box setLength(int length) {
        this.length = length;
        return this;
    }

    @Override
    public String toString() {
        return "Box{" +
                "height=" + height +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
