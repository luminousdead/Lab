package lab1.models;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private List<Discipline> studentDisciplines = new ArrayList<>();

    private Course studentCourse;

    public Student(String fName, String lName) {
        super(fName, lName);
    }


    public void setCourse(Course course) {
        this.studentCourse = course;
        studentDisciplines = studentCourse.getDisciplines();
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------ Info ------------\n");
        sb.append("Student First Name = " + this.firstName + "\n");
        sb.append("Student Last Name = " + this.lastName + "\n");
        sb.append("Student Id = " + getId() + "\n");
        sb.append("Student Course Number = " + studentCourse.getNumber() + "\n");
        sb.append("------------- Disciplines -------------\n");
        for (int i = 0; i < studentDisciplines.size(); i++) {
            sb.append((i + 1) + " : " + studentDisciplines.get(i).getName() + "\n");
        }
        sb.append("---------------------------------------");
        return sb.toString();
    }

    @Override
    public void getStatus() {
        System.out.println("Это студент.");
    }
}
