package ch2;

public class Ch2_9 {
    public static class Car {
        private double fuel_efficiency;
        private double gas_level;
        private double travel_distance;

        public Car(double fuel_efficiency) {
            this.fuel_efficiency = fuel_efficiency;
        }

        public double getGasLeft() {
            return gas_level;
        }

        public double getTravelDistance() {
            return travel_distance;
        }

        public void drive(double distance) {
            this.travel_distance += distance;
            this.gas_level -= distance / fuel_efficiency;
        }

        public void addGas(double more_gas) {
            this.gas_level += more_gas;
        }
    }

    public static void main(String[] args) {
        Car car = new Car(20.0);
        car.addGas(10);
        car.drive(100);
        System.out.printf("Gas: %2.2f, distance: %2.2f\n", car.getGasLeft(), car.getTravelDistance());
        car.addGas(2);
        System.out.printf("Gas: %2.2f, distance: %2.2f\n", car.getGasLeft(), car.getTravelDistance());
        car.drive(40);
        System.out.printf("Gas: %2.2f, distance: %2.2f\n", car.getGasLeft(), car.getTravelDistance());
    }
}
