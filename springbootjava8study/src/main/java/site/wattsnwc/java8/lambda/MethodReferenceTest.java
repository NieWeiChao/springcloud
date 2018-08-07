package site.wattsnwc.java8.lambda;

import java.util.ArrayList;

public class MethodReferenceTest {

    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Car car = Car.create(Car::new);
            cars.add(car);
        }
        cars.forEach(Car::showCar);

    }

    @java.lang.FunctionalInterface
    interface Factory<T> {
        T create();
    }

    static class Car {
        public void showCar() {
            System.out.println(this.toString());
        }

        public static Car create(Factory<Car> factory) {
            return factory.create();
        }
    }
}