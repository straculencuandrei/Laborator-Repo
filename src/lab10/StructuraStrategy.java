package lab10;

import java.util.List;

class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String group;
    private double grade;

    public Student(int id, String firstName, String lastName, String group, double grade) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.grade = grade;
    }

    @Override
    public String toString() {
        return id + "," + firstName + "," + lastName + "," + group + "," + grade;
    }
}

interface IStudentiExport {
    void doExport(List<Student> studenti);
}

interface IStudentiImport {
    List<Student> doImport();
}

class Exporter {
    public void startExport(IStudentiExport strategyInstance, List<Student> students) {
        strategyInstance.doExport(students);
    }
}

class Importer {
    public List<Student> startImport(IStudentiImport strategyInstance) {
        return strategyInstance.doImport();
    }
}