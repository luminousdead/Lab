package lab1.models;


import java.util.ArrayList;
import java.util.List;

public class Discipline {
    private Course course;
    private String disciplineName;
    private List<Student> students = new ArrayList<>();
    private List<Teacher> teachers;

    Discipline() {

    }

    public Discipline(String disciplineName, Teacher teacher, Course course) {
        teacher.addDiscipline(this);
        this.teachers.add(teacher);
        this.disciplineName = disciplineName;
        this.course = course;
    }

    public void setTeacher(Teacher teacher) {
        teacher.addDiscipline(this);
        this.teachers.add(teacher);
    }

    public void deleteStudentFromDisciplineById(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                students.remove(student);
                System.out.println("Student was deleted.");
                return;
            }
        }
        System.out.println("Student with such id not found.");
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public String getInfo() {
        return "\n---------------------------------------------------\n" +
                "Discipline Name = " + disciplineName + "\n" +
                "Teacher Name = " + teachers.get(0).getFullName() + "\n" +
                "The number of students = " + students.size() + "\n" +
                "Discipline course = " + course.getNumber() +"\n" +
                "---------------------------------------------------\n";
    }

    public String getName() {
        return this.disciplineName;
    }
}
