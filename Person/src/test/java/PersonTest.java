import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import person.Person;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PersonTest {
    /*
    -- Casos de prueba
        El programa debe calcular bien la media de un conjunto
        El programa debe calcular bien la edad media de un conjunto sin hombre
        El programa debe calcular bien la edad media de un conjunto sin mujeres
        El programa debe lanzar una excepcion si el nombre introducido es nulo, si la edad es negativa o si el genero no es valido
     */

    Person person;

    @BeforeEach
    void setPerson() {
        person = new Person("Men", 20, "H");
    }

    @AfterEach
    void reStart() {
        person = null;
    }

    @Test
    void averageAge() {
        List<Person> people = new ArrayList<Person>();

        people.add(new Person("Juan", 20, "H"));
        people.add(new Person("Conchi", 25, "M"));
        people.add(new Person("Kike", 32, "H"));
        people.add(new Person("Paqui", 18, "M"));

        double[] expectedValue = new double[2];
        expectedValue[0] = (double) (20 + 32) / 2;
        expectedValue[1] = (double) (25 + 18) / 2;

        assertEquals(expectedValue[0], person.averageAgePerGender(people)[0]);
        assertEquals(expectedValue[1], person.averageAgePerGender(people)[1]);
    }

    @Test
    void noMenSet() {
        List<Person> people = new ArrayList<Person>();

        people.add(new Person("Conchi", 25, "M"));
        people.add(new Person("Paqui", 18, "M"));

        double[] expectedValue = new double[2];
        expectedValue[0] = 0;
        expectedValue[1] = (double) (25 + 18) / 2;

        assertEquals(expectedValue[0], person.averageAgePerGender(people)[0]);
        assertEquals(expectedValue[1], person.averageAgePerGender(people)[1]);

    }
    @Test
    void noWomenSet() {
        List<Person> people = new ArrayList<Person>();

        people.add(new Person("Juan", 20, "H"));
        people.add(new Person("Kike", 32, "H"));

        double[] expectedValue = new double[2];
        expectedValue[0] = (double) (20 + 32) / 2;
        expectedValue[1] = 0;

        assertEquals(expectedValue[0], person.averageAgePerGender(people)[0]);
        assertEquals(expectedValue[1], person.averageAgePerGender(people)[1]);
    }

    @Test
    void nullName(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Person p1 = new Person(null, 30, "M");
        });
        assertEquals("Error. Introduzca un nombre", exception.getMessage());
    }

    @Test
    void negativeAge(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Person p1 = new Person("Kike", -30, "M");
        });
        assertEquals("Error. Introduzca una edad valida", exception.getMessage());
    }

    @Test
    void invalidGender(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            Person p1 = new Person("Kike", 30, "A");
        });
        assertEquals("Error. Genero no valido", exception.getMessage());
    }
}