package javanext.util;

import java.io.*;

public class Test{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Rectangle rectangle1 = new Rectangle(3,4);
        System.out.println("1.原始对象\n"+rectangle1);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("rectangle1"));
        o.writeObject(rectangle1);
        o.close();

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("rectangle1"));
        Rectangle rectangle2 = (Rectangle) in.readObject();
        System.out.println("2.反序列化后的对象\n"+rectangle2);
        rectangle2.setArea();
        System.out.println("3.恢复成原始对象\n"+rectangle2);
        in.close();
    }
}
