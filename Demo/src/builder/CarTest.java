package builder;

public class CarTest {
    public static void main(String[] args) {
        Car car = new Car.CarBuilder("Sedan","Automatic","Diesel").cruseControl(true).build();
        System.out.println(car);
    }
}
