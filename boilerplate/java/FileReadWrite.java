import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FileReadWrite {
    

    public static void main(String[] args) throws Exception{
        
        File f = new File("info.txt");
        Path p = f.toPath();

        Car c1 = new Car("Ferrarri", 2019, 20000000);
        Car c2 = new Car("Lamborghini", 2020, 20000000);
        AbstractCar c3 = new Car("BMW", 2021, 20000000);

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        FileOutputStream fo = new FileOutputStream("oos.bin");
        ObjectOutputStream os = new ObjectOutputStream(fo);
        
        os.writeObject(c1);
        os.writeObject(c2);
        os.writeObject(c3);

        os.close();

        FileInputStream fi = new FileInputStream("oos.bin");
        ObjectInputStream oi = new ObjectInputStream(fi);

        System.out.println(oi.readObject());
        System.out.println(oi.readObject());
        System.out.println(oi.readObject());
        // if(readObj.getClass() == ArrayList.class){
        //     ArrayList<Integer> readal = (ArrayList<Integer>)readObj;
        //     System.out.println(readal);
        // }

        oi.close();
        
    }
}

class Car extends AbstractCar implements Serializable{
    public Car (String model, int year, int price){
        this.model = model;
        this.price = price;
        this.year = year;
    }
}

abstract class AbstractCar {
    String model;
    int year;
    int price;

    @Override
    public String toString() {
        return "Car [model=" + model + ", year=" + year + ", price=" + price + "]";
    }
}

interface Drivable {
    int gears = 0;
    
}
