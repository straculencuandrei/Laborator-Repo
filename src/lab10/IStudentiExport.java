package lab10;

import java.util.List;

public interface IStudentiExport {
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