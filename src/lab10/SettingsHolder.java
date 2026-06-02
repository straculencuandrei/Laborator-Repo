package lab10;

import java.util.Map;

public class SettingsHolder {
    private static SettingsHolder instance = null;
    private final Map<String, String> settings;

    private SettingsHolder() {
        settings = readSettings();
    }

    private Map<String, String> readSettings() {
        return null;
    }

    public static SettingsHolder getInstance() {
        if (instance == null) {
            instance = new SettingsHolder();
        }
        return instance;
    }
}