package student;

import java.util.HashMap;
import java.util.Map;

public class StudentSystem {
    private Map<String, Student> repo;

    public StudentSystem() {
        this.repo = new HashMap<>();
    }

    public Map<String, Student> getRepo() {
        return this.repo;
    }

    public void parseCommand(String[] args) {
        String firstArg = args[0];
        String name = args[1];

        if (firstArg.equals("Create")) {
            int age = Integer.parseInt(args[2]);
            double grade = Double.parseDouble(args[3]);
            if (!repo.containsKey(name)) {
                Student student = new Student(name, age, grade);
                repo.put(name, student);
            }
        } else if (firstArg.equals("Show")) {
            if (repo.containsKey(name)) {
                StringBuilder text = new StringBuilder();
                Student student = repo.get(name);
                text.append(String.format("%s is %s years old.", student.getName(), student.getAge()));

                if (student.getGrade() >= 5.00) {
                    text.append(" Excellent student.");
                } else if (student.getGrade() < 5.00 && student.getGrade() >= 3.50) {
                    text.append(" Average student.");
                } else {
                    text.append(" Very nice Inheritance.InterfacesAndAbstraktions.Exercises.person.");
                }

                System.out.println(text.toString());
            }
        }
    }
}
