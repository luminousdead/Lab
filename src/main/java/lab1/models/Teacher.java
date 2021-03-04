package lab1.models;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends User {
    private List<Discipline> disciplineList = new ArrayList<>();

    public Teacher(String fName, String lName) {
        super(fName, lName);
    }

    public void addDiscipline(Discipline d) {
        this.disciplineList.add(d);
    }

    @Override
    void getStatus() {
        System.out.println("Это преподаватель.");
    }

    @Override
    String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------ Info ------------\n");
        sb.append("Teacher First Name = " + this.firstName + "\n");
        sb.append("Teacher Last Name = " + this.lastName + "\n");
        sb.append("Teacher Id = " + getId() + "\n");
        sb.append("------------- Disciplines taught by this teacher -------------\n");
        for (int i = 0; i < disciplineList.size() - 1; i++) {
            sb.append(i + " : " + disciplineList.get(i).getName() + "\n");
        }
        sb.append("---------------------------------------");
        return sb.toString();
    }
}
