import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private static Person Man20yoHigher;
    private static Person Women30yoHigher;
    private static Person Women25yoElementary;
    private static Person Man5yoFurther;

    @BeforeAll
    private static void before() {
        Man20yoHigher = new Person(
                "I am",
                "20 yo",
                20,
                Sex.MAN,
                Education.HIGHER
        );
        Women30yoHigher = new Person(
                "I am",
                "30 yo",
                30,
                Sex.WOMEN,
                Education.HIGHER
        );
        Women25yoElementary = new Person(
                "I am",
                "25 yo",
                25,
                Sex.WOMEN,
                Education.ELEMENTARY
        );
        Man5yoFurther = new Person(
                "I am",
                "5 yo",
                5,
                Sex.MAN,
                Education.FURTHER
        );
    }

    @Test
    public void findMinorPersonsTest() {
        //given:
        Collection<Person> persons = new ArrayList<>();
        persons.add(Man20yoHigher);
        persons.add(Man5yoFurther);
        persons.add(Women30yoHigher);

        Collection<Person> expected = new ArrayList<>();
        expected.add(Man20yoHigher);
        expected.add(Women30yoHigher);

        //when:
        Collection<Person> minorPersons = Main.findMinorPersons(persons);

        //then:
        assertEquals(expected.containsAll(minorPersons), true);
        assertEquals(minorPersons.size(), 2);
    }

    @Test
    public void findSoldiersTest() {
        //given:
        Collection<Person> persons = new ArrayList<>();
        persons.add(Man20yoHigher);
        persons.add(Man5yoFurther);
        persons.add(Women25yoElementary);

        Collection<String> expected = new ArrayList<>();
        expected.add("20 yo");

        //when:
        Collection<String> soldiers = Main.findSoldiers(persons);

        //then:
        assertEquals(expected.containsAll(soldiers), true);
        assertEquals(soldiers.size(), 1);
    }

    @Test
    public void potentiallyWorkablePersonsTest() {
        //given:
        Collection<Person> persons = new ArrayList<>();

        persons.add(Man20yoHigher);
        persons.add(Man5yoFurther);
        persons.add(Women30yoHigher);
        persons.add(Women25yoElementary);

        Collection<Person> expected = new ArrayList<>();
        expected.add(Man20yoHigher);
        expected.add(Women30yoHigher);

        //when:
        Collection<Person> minorPersons = Main.potentiallyWorkablePersons(persons);

        //then:
        assertEquals(expected.containsAll(minorPersons), true);
        assertEquals(minorPersons.size(), 2);
    }
}