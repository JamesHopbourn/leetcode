package common;

public class Demo {
    public static void main(String[] args) {
        Box box = new Box().builder().setHeight(1).setLength(2).setWidth(3).build();
        
        System.out.println(box);
    }
}
