package lab10;

// Adaugat public pentru a fi vizibila peste tot
public class Student {
    private final int id;
    private final String firstName;
    private final String lastName;
    private final String group;
    private final double grade;

    public Student(int id, String firstName, String lastName, String group, double grade) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.group = group;
        this.grade = grade;
    }

    // Metode getter publice necesare pentru logare sau logica externa
    public int getId() { return id; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getGroup() { return group; }
    public double getGrade() { return grade; }

    @Override
    public String toString() {
        return id + "," + firstName + "," + lastName + "," + group + "," + grade;
    }
}
