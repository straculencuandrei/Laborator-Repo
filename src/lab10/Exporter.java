package lab10;

import java.util.List;

public class Exporter {
    public void startExport(IStudentiExport strategyInstance, List<Student> students) {
        if (strategyInstance != null && students != null) {
            strategyInstance.doExport(students);
        }
    }
}