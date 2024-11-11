import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class Test {

    @org.junit.jupiter.api.Test
    void testEncapsulationOfGrades() {
        Student student = new Student("Андрей");
        student.addGrade(4);
        student.addGrade(5);

        List<Integer> grades = student.getGrades();
        assertEquals(2, grades.size());
        assertThrows(UnsupportedOperationException.class, () -> grades.add(3),
                "Список оценок должен быть неизменяемым");
    }

    @org.junit.jupiter.api.Test
    void testAddValidGrades() {
        Student student = new Student("Андрей");
        student.addGrade(3);
        student.addGrade(5);

        assertEquals(2, student.getGrades().size());
        assertTrue(student.getGrades().contains(3));
        assertTrue(student.getGrades().contains(5));
    }

    @org.junit.jupiter.api.Test
    void testAddInvalidGradeThrowsException() {
        Student student = new Student("Андрей");
        assertThrows(IllegalArgumentException.class, () -> student.addGrade(6),
                "Добавление оценки за пределы диапазона вызовет исключение");
        assertThrows(IllegalArgumentException.class, () -> student.addGrade(1),
                "Добавление оценки за пределы диапазона вызовет исключение");
    }
}
