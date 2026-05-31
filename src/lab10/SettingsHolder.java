package lab10;

import java.util.HashMap;
import java.util.Map;

public class SettingsHolder {
    private static SettingsHolder instance = null;
    private Map<String, String> settings;

    private SettingsHolder() {
        settings = readSettings();
    }

    public static SettingsHolder getInstance() {
        if (instance == null) {
            instance = new SettingsHolder();
        }
        return instance;
    }

    private Map<String, String> readSettings() {
        Map<String, String> defaultSettings = new HashMap<>();
        defaultSettings.put("appName", "Aplicatie Studenti");
        defaultSettings.put("version", "1.0");
        return defaultSettings;
    }

    public String getSetting(String key) {
        if (settings == null) {
            return null;
        }
        return settings.get(key);
    }
}