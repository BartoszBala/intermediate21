package pl.sda.intermediate;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

public class HashCodeTest {


    @Test
    void constantHash() {
        CarConstantHashCode c1= new CarConstantHashCode("Audi A4");
        CarConstantHashCode c2= new CarConstantHashCode("Audi A5");
        CarConstantHashCode c3= new CarConstantHashCode("Audi A6");
        CarConstantHashCode c4= new CarConstantHashCode("Audi A7");
        CarConstantHashCode c5= new CarConstantHashCode("Audi A8");
        CarConstantHashCode c6= new CarConstantHashCode("Audi A9");

        Set<CarConstantHashCode> cars = new HashSet<>();

        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
        cars.add(c3);
        cars.add(c4);
        cars.add(c5);
        cars.add(c6);

        System.out.println(cars.size());

    }

    @RepeatedTest(20)
    void randomTest() throws InterruptedException {

        CarRandomHashCode c1= new CarRandomHashCode("Audi A4");
        CarRandomHashCode c2= new CarRandomHashCode("Audi A5");
        CarRandomHashCode c3= new CarRandomHashCode("Audi A6");
        CarRandomHashCode c4= new CarRandomHashCode("Audi A7");
        CarRandomHashCode c5= new CarRandomHashCode("Audi A8");
        CarRandomHashCode c6= new CarRandomHashCode("Audi A9");

        Set<CarRandomHashCode> cars = new HashSet<>();

        cars.add(c1);
        cars.add(c2);
        cars.add(c3);
        cars.add(c3);
        cars.add(c4);
        cars.add(c5);
        cars.add(c6);
Thread.sleep(500);
        System.out.println(cars.size());




    }
}
