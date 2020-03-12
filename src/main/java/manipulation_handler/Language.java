package manipulation_handler;

import java.util.HashMap;

public class Language {
    HashMap<String, String> languageHashMap;

    public Language() {
        languageHashMap = new HashMap<String, String>();
    }

    public Language(HashMap<String, String> languageHashMap) {
        this.languageHashMap = languageHashMap;
    }

    public HashMap<String, String> getLanguageHashMap() {
        return languageHashMap;
    }

    public void setLanguageHashMap(HashMap<String, String> languageHashMap) {
        this.languageHashMap = languageHashMap;
    }
}
