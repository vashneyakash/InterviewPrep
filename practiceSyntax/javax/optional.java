package javax;

import java.util.Optional;

public class optional {

    public static class Person {

        private Optional<Car> optionalCar;

        public Optional<Car> getOptionalCar() {
            return optionalCar;
        }
    }
    public static class Car {

        private Optional<Insurance> optionalInsurance;

        public Optional<Insurance> getOptionalInsurance() {
            return optionalInsurance;
        }
    }

    public static class Insurance {

        private String name;

        public String getName() {
            return name;
        }

    }

    public class Test {

        // map cannot deal with nested Optionals
        public Optional<String> getCarInsuranceName(Person person) {
//            return person.getOptionalCar()
//                    .map(Car::getOptionalInsurance) // ① leads to a Optional<Optional<Insurance>
//                    .map(Insurance::getName);       // ②
            return person.getOptionalCar()
                    .flatMap(Car::getOptionalInsurance) // ① leads to a Optional<Optional<Insurance>
                    .map(Insurance::getName);
        }

        public Optional<String> getCarInsurance(Person person) {
//            return person.getOptionalCar()
//                    .map(Car::getOptionalInsurance) // ① leads to a Optional<Optional<Insurance>
//                    .map(Insurance::getName);       // ②
            return person.getOptionalCar()
                    .flatMap(Car::getOptionalInsurance) // ① leads to a Optional<Optional<Insurance>
                    .map(Insurance::getName);
        }

    }
}
