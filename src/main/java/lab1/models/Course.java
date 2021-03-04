package lab1.models;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private final int courseNumber;
    private final List<Discipline> disciplineList = new ArrayList<>();

    public Course(int courseNumber) {
        this.courseNumber = courseNumber;
    }

    public int getNumber() {
        return this.courseNumber;
    }
    public void addDiscipline(Discipline discipline) {
        disciplineList.add(discipline);
    }
    public List<Discipline> getDisciplines() {
        return disciplineList;
    }
}
