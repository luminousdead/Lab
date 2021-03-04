package lab1;

import lab1.models.Course;
import lab1.models.Discipline;
import lab1.models.Student;
import lab1.models.Teacher;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// todo Проверить на наличие лишних связей в программе
//  (нарисовать схему где что лежит и куда передаются ссыки)
public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        program.run();
    }
}

class Program {
    private Scanner scanner = new Scanner(System.in);
    private String input;
    List<Course> courses = new ArrayList<>();
    List<Student> allStudents = new ArrayList<>();
    List<Discipline> allDisciplines = new ArrayList<>();


    List<Teacher> teachers = List.of(
            new Teacher("игорь", "Михайлович"),
            new Teacher("Светлана", "Борисовна"),
            new Teacher("Алексей", "Витальевич"),
            new Teacher("Борис", "Борисович"),
            new Teacher("Алена", "Лезжова"),
            new Teacher("TestName1", "TestLastName1")
    );

    // todo Сделать просто лист всех студентов при запуске программы
    List<Student> studentsFirstCourse = List.of(
            new Student("имя_Студента_1", "Курс_1"),
            new Student("имя_Студента_2", "Курс_1"),
            new Student("имя_Студента_3", "Курс_1"),
            new Student("имя_Студента_4", "Курс_1")
    );

    List<Student> studentsSecondCourse = List.of(
            new Student("имя_Студента_1", "Курс_2"),
            new Student("имя_Студента_2", "Курс_2"),
            new Student("имя_Студента_3", "Курс_2"),
            new Student("имя_Студента_4", "Курс_2")
    );

    List<Student> studentsThirdCourse = List.of(
        new Student("Сергей", "Гонтаренко"),
        new Student("Степан", "Тербалян"),
        new Student("Елена", "Каратаева")
    );

    List<Student> studentsFourthCourse = List.of(
            new Student("имя_Студента_1", "Курс_4"),
            new Student("имя_Студента_2", "Курс_4")
    );

    Program() {
        createCourse1WithDisciplines();
        createCourse2WithDisciplines();
        createCourse3WithDisciplines();
        createCourse4WithDisciplines();
        allStudents.addAll(studentsFirstCourse);
        allStudents.addAll(studentsSecondCourse);
        allStudents.addAll(studentsThirdCourse);
        allStudents.addAll(studentsFourthCourse);
    }

    public void run() {
        int in;
        while (true) {
            System.out.println("\n------ Menu ------");
            System.out.println("1. Добавить нового студента.");
            System.out.println("2. Добавить нового преподавателя.");
            System.out.println("3. Добавить новую дисциплину.");
            System.out.println("4. Посмотреть информацию о студенте.");
            System.out.println("5. Посмотреть информацию о преподавателе.");
            System.out.println("6. Посмотреть информацию о дисциплине.");
            System.out.println("7. Узнать информацию о том, кем является человек.");
            System.out.println("0. Exit.");
            System.out.print("> ");
            try {
                in = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Wrong input!");
                continue;
            }

            System.out.println("------------------");
            switch (in) {
                case 1:
                    createStudent();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:
                    showStudentInfo();
                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 0:
                    System.out.println("bb");
                    return;
                default:
                    System.out.println("Wrong Input.\n");
                    break;
            }
        }
    }

    private void createStudent() {
        while (true) {
            try {
                System.out.println("\nВведите имя и фамилию студента через пробел(имя Фамилия):");
                System.out.print("> ");
                input = scanner.nextLine();
                String[] fullName = input.split(" ");

                System.out.println("Введите курс на котором учится студент(1, 2, 3, 4):");
                System.out.print("> ");
                input = scanner.nextLine();
                int courseNumber = Integer.parseInt(input) - 1;

                if (courseNumber > 3 || courseNumber < 0 || fullName.length != 2) {
                    throw new Exception();
                }

                Student student = new Student(fullName[0], fullName[1]);
                student.setCourse(courses.get(courseNumber));
                for (Discipline discipline : courses.get(courseNumber).getDisciplines() ) {
                    discipline.addStudent(student);
                }
                allStudents.add(student);
                System.out.println("Студент успешно записан!");
                break;
            } catch (Exception e) {
                System.out.println("Wrong Input");
            }
        }
    }

    private void showStudentInfo() {
        try {
            System.out.println("\nВведите имя и фамилию студента через пробел(имя Фамилия):");
            System.out.print("> ");
            input = scanner.nextLine();
            String[] fullName = input.split(" ");

            if (fullName.length != 2) {
                throw new Exception();
            }

            for (Student student : allStudents) {
                if (student.getFullName().equals(input)) {
                    System.out.println(student.getInfo());
                    return;
                }
            }
            System.out.println("Студент не найден.");
        } catch (Exception e) {
            System.out.println("Wrong Input");
        }
    }


    private void createCourse1WithDisciplines() {
        Course course = new Course(1);

        course.addDiscipline(new Discipline("Мат. анализ (Первый курс)", teachers.get(0), course));
        course.addDiscipline(new Discipline("Химия (Первый курс)", teachers.get(1), course));

        for (Discipline discipline : course.getDisciplines()) {
            for (Student student : studentsFirstCourse) {
                student.setCourse(course);
                discipline.addStudent(student);
            }
            allDisciplines.add(discipline);
        }
        courses.add(course);
    }

    private void createCourse2WithDisciplines() {
        Course course = new Course(2);

        course.addDiscipline(new Discipline("Дициплина второго курса #1", teachers.get(1), course));
        course.addDiscipline(new Discipline("Дициплина второго курса #2", teachers.get(2), course));

        for (Discipline discipline : course.getDisciplines()) {
            for (Student student : studentsSecondCourse) {
                student.setCourse(course);
                discipline.addStudent(student);
            }
            allDisciplines.add(discipline);
        }

        courses.add(course);
    }

    private void createCourse3WithDisciplines() {
        Course course = new Course(3);

        course.addDiscipline(new Discipline("Дициплина третьего курса #1", teachers.get(4), course));
        course.addDiscipline(new Discipline("Дициплина третьего курса #2", teachers.get(3), course));

        for (Discipline discipline : course.getDisciplines()) {
            for (Student student : studentsThirdCourse) {
                student.setCourse(course);
                discipline.addStudent(student);
            }
            allDisciplines.add(discipline);
        }

        courses.add(course);
    }

    private void createCourse4WithDisciplines() {
        Course course = new Course(4);

        course.addDiscipline(new Discipline("Дициплина четвертого курса #1", teachers.get(5), course));
        course.addDiscipline(new Discipline("Дициплина четвертого курса #2", teachers.get(5), course));

        for (Discipline discipline : course.getDisciplines()) {
            for (Student student : studentsFourthCourse) {
                student.setCourse(course);
                discipline.addStudent(student);
            }
            allDisciplines.add(discipline);
        }

        courses.add(course);
    }
}
