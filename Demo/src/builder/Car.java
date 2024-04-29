package builder;

public class Car {

    private String carType;
    private String transmission;
    private String engine;
    private boolean crusecontrol;//Optional
    private boolean fourWheeldrive;//Optional

    private Car(CarBuilder carBuilder) {
        this.carType = carBuilder.carType;
        this.engine = carBuilder.engine;
        this.transmission = carBuilder.transmission;
        this.crusecontrol = carBuilder.crusecontrol;
        this.fourWheeldrive = carBuilder.fourWheeldrive;
    }

    @Override
    public String toString() {
        return "Car [" + "carType = " + carType + ", engine = " + engine + ", transmission = " + transmission + ", cruseControl = " + crusecontrol + ", fourWheelrive = " + fourWheeldrive + " ]";
    }

    public static class CarBuilder {

        String carType;
        String transmission;
        String engine;
        boolean crusecontrol;//Optional
        boolean fourWheeldrive;//Optional

        public CarBuilder(String carType, String transmission, String engine) {
            this.carType = carType;
            this.engine = engine;
            this.transmission = transmission;
        }

        public CarBuilder cruseControl(boolean crusecontrol) {
            this.crusecontrol = crusecontrol;
            return this;
        }

        public CarBuilder fourWheeldrive(boolean fourWheeldrive) {
            this.fourWheeldrive = fourWheeldrive;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
