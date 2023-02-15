package person;

import java.util.List;

public class Person {

    private final String name;

    private final int age;

    private final String gender;
    public Person(String name, int age, String gender) {
        if(name == null) {
            throw new RuntimeException("Error. Introduzca un nombre");
        }

        if(age < 0) {
            throw new RuntimeException("Error. Introduzca una edad valida");
        }

        if(!gender.equals("M") && !gender.equals("H")) {
            throw new RuntimeException("Error. Genero no valido");
        }

        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String name() {
        return name;
    }

    public  int age() {
        return age;
    }

    public String gender() {
        return gender;
    }

    public double[] averageAgePerGender(List<Person> persons) {
        double[] avergaAgePerGender = new double[2];

        double menAgeSum = 0;
        double womenAgeSum = 0;

        int numberOfMen = 0;
        int numberOfWomen = 0;

        double averageMen = 0;
        double averageWomen = 0;

        for (Person person : persons) {
            if(person.gender().equals("H")) {
                menAgeSum += person.age;
                numberOfMen++;
            }
            else if(person.gender().equals("M")) {
                womenAgeSum += person.age;
                numberOfWomen++;
            }
        }

        if(numberOfMen != 0) {
            averageMen = menAgeSum / (double) numberOfMen;
        }

        if(numberOfWomen != 0) {
            averageWomen = womenAgeSum / (double) numberOfWomen;
        }

        avergaAgePerGender[0] = averageMen;
        avergaAgePerGender[1] = averageWomen;

        return avergaAgePerGender;
    }
}
