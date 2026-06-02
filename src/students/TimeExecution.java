package students;

import java.util.List;
import lab10.IStudentiExport;
import lab10.Student;

public abstract class TimeExecution implements ITimeExecution {
    protected IStudentiExport strategy;

    public TimeExecution(IStudentiExport strategy) {
        this.strategy = strategy;
    }

    @Override
    public long executionTime(List<Student> studenti) {
        long startTime = System.currentTimeMillis();
        strategy.doExport(studenti);
        long endTime = System.currentTimeMillis();
        return (endTime - startTime);
    }
}