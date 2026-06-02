package students;

import lab10.IStudentiExport;
import lab10.Student;
import java.util.List;

public class TimeExecutionDecorator extends TimeExecution {
    private final List<Student> studenti;

    public TimeExecutionDecorator(IStudentiExport exporter, List<Student> studenti) {
        super(exporter);
        this.studenti = studenti;
    }

    public long executionTime() {
        long execTime = super.executionTime(studenti);
        System.out.println("Execution time: " + execTime + " ms");
        return execTime;
    }
}
